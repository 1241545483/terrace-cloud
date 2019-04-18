package com.synapse.reading.service;


import com.synapse.reading.model.ExcelRowModel;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel导入服务
 * <p>
 * Created by huwei on 2017/11/18.
 */

@Service
public class ExcelImportService {

    private static Logger logger = LoggerFactory.getLogger(ExcelImportService.class);

    /**
     * 读取excel文件中的学员信息
     *
     * @param excel_url
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Map<String, List<ExcelRowModel>> excelAnalysis(String excel_url) throws IOException, ClassNotFoundException {

        if(excel_url.endsWith(".tmp")){
            excel_url = excel_url.replace(".tmp","");
        }
        Map<String, List<ExcelRowModel>> result = new HashMap<String, List<ExcelRowModel>>();
        List<ExcelRowModel> memberInfos = new ArrayList<>();
        List<ExcelRowModel> erroInfoMemberInfos = new ArrayList<>();

        URL url = new URL(excel_url);
        InputStream is = url.openStream();
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(is);
        } catch (Exception e) {
            System.out.println(e);
            POIFSFileSystem fs = new POIFSFileSystem(is);
            workbook = new HSSFWorkbook(fs);
        }
        Sheet sheet = workbook.getSheetAt(0);

        if (workbook == null || sheet == null) {
            return null;
        }
        //行数
        //读取第一页,一般一个excel文件会有三个工作表，这里获取第一个工作表来进行操作     HSSFSheet sheet = wb.getSheetAt(0);
        //循环遍历表sheet.getLastRowNum()是获取一个表最后一条记录的记录号，
        //如果总共有3条记录，那获取到的最后记录号就为2，因为是从0开始的
        int recordNum = sheet.getLastRowNum();
        for (int j = 0; j < recordNum; j++) {
            int rowNum = j + 1;
            Class excelRowModelClass = ExcelRowModel.class;

            Field[] fields = excelRowModelClass.getDeclaredFields();
//            System.out.println("row: " + j);
            try {
                //创建一个行对象
                Row row = sheet.getRow(rowNum);
                ExcelRowModel obj = (ExcelRowModel) excelRowModelClass.newInstance();
                //把一行里的每一个字段遍历出来
                for (int i = 0; i < fields.length; i++) {
                    //创建一个行里的一个字段的对象，也就是获取到的一个单元格中的值
                    Cell cell = row.getCell(i);
                    fields[i].setAccessible(true);
                    fields[i].set(obj, getStringVal(cell));
                }
                if (isColumnEmpty(rowNum, obj)) {
                    erroInfoMemberInfos.add(obj);
                    logger.warn("第{}条数据，用户名或手机号或身份证为空！", rowNum);
                } else {
                    memberInfos.add(obj);
                }
            } catch (Exception e) {
                logger.error("excel导入，第" + rowNum + "条记录读取失败");
            }
        }
        is.close();
        result.put("excel_members", memberInfos);
        result.put("error_info", erroInfoMemberInfos);

        return result;
    }

    /**
     *  判断必要字段是否为空：姓名，手机号，身份证
     * @param obj
     * @return
     */
    private boolean isColumnEmpty(int row,ExcelRowModel obj) {
        if(StringUtils.isEmpty(obj.getUserName())){
            obj.setErrMsg("第" + row + "行数据姓名为空");
            return true;
        }
        if(StringUtils.isEmpty(obj.getPhone()) && StringUtils.isEmpty(obj.getIdCard())){
            obj.setErrMsg(obj.getUserName() + "[第" + row + "行]数据手机号或身份证为空");
            return true;
        }
        return false;
    }

    /**
     * 将excel的单元格转换为字符串
     *
     * @param cell
     * @return
     */
    public String getStringVal(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "true" : "false";
            case Cell.CELL_TYPE_NUMERIC:
                cell.setCellType(CellType.STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, List<ExcelRowModel>> result = new ExcelImportService().excelAnalysis(new File("d:/import.xlsx").toURI().toURL().toString());
        System.out.println(result);
    }
}
