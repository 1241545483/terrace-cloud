
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyifan on 18-2-14.
 */
public class MybatisGenerator {

    private static String[] tables = new String[]{"category","relevance_item"};
    private static String BASE_PATH_ROOT = "/D:/program/reading";
    private static String AUTHOR = "liuguangfu";

    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/reading?characterEncoding=utf8&useSSL=false";
    private static String dbUser = "root";
    private static String dbPSW = "root";

    private static String PKG = "com.synapse.reading";
    private static final String superControllerClass = "com.synapse.reading.controller.BaseController";
    private static String MODEL_PATH_ROOT = BASE_PATH_ROOT + "/reading-model";
    private static String SERVICE_PATH_ROOT = BASE_PATH_ROOT + "/reading-service";
    private static String WEB_PATH_ROOT = BASE_PATH_ROOT + "/reading-web";

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("basePackage", PKG);
                map.put("basePath", "/reading");
                map.put("version", "v1");
                map.put("paramPackage", "com.synapse.reading.dto.param");
                map.put("resultPackage", "com.synapse.reading.dto.result");
                map.put("respositoryPackage", "com.synapse.reading.respository");
                map.put("testPackage", "com.synapse.reading");
                map.put("constantPackage", "com.synapse.reading.constants");
                map.put("testConfig", "TestConfig");
                map.put("idGenPackage","com.synapse.reading.remote");
                map.put("idGenEntity","IdService");
                map.put("idGenPrefix","ID");
                this.setMap(map);
            }
        };

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(SERVICE_PATH_ROOT + "/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setServiceImplName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(dbUser);
        dsc.setPassword(dbPSW);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tables); // 需要生成的表
        // 自定义 controller 父类
        strategy.setSuperControllerClass(superControllerClass);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PKG);
        pc.setController("controller");
        pc.setServiceImpl("service");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/resources/" + PKG.replaceAll("\\.","/") + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        // 调整 Mapper.java 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/mapper/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });
        // 调整 respository.java 生成目录演示
        focList.add(new FileOutConfig("/templates/respository.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/respository/" + tableInfo.getEntityName() + "Respository.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 respository.xml 生成目录演示
        focList.add(new FileOutConfig("/templates/respository.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH_ROOT + "/src/main/resources/" + PKG.replaceAll("\\.","/") + "/respository/" + tableInfo.getEntityName() + "Respository.xml";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 Model 生成目录演示
        focList.add(new FileOutConfig("/templates/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/model/" + tableInfo.getEntityName() + ".java";
            }
        });
        // 调整 Param 生成目录演示
        focList.add(new FileOutConfig("/templates/param.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/dto/param/" + tableInfo.getEntityName() + "Param.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 Result 生成目录演示
        focList.add(new FileOutConfig("/templates/result.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/dto/result/" + tableInfo.getEntityName() + "Result.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 Controller 生成目录演示
        focList.add(new FileOutConfig("/templates/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return WEB_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/controller/" + tableInfo.getEntityName() + "Controller.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });


        // 调整 Constants 生成目录演示
        focList.add(new FileOutConfig("/templates/constant.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MODEL_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.", "/") + "/constants/" + tableInfo.getEntityName() + "Constants.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 Service 生成目录演示
        focList.add(new FileOutConfig("/templates/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.","/") + "/service/" + tableInfo.getEntityName() + "Service.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        // 调整 BaseService 生成目录演示
        focList.add(new FileOutConfig("/templates/baseService.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH_ROOT + "/src/main/java/" + PKG.replaceAll("\\.", "/") + "/service/" + tableInfo.getEntityName() + "BaseService.java";
            }
        });
        // 调整 Test 生成目录演示
        focList.add(new FileOutConfig("/templates/serviceTest.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH_ROOT + "/src/test/java/" + PKG.replaceAll("\\.","/") + "/service/" + tableInfo.getEntityName() + "ServiceTest.java";
            }

            @Override
            public boolean overwrite() {
                return false;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setController(null);
        tc.setMapper(null);
        tc.setEntity(null);
        tc.setXml(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}
