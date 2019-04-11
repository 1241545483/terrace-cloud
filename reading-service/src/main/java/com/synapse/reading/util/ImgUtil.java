package com.synapse.reading.util;

import com.synapse.reading.service.MiniQrcodeService;
import org.apache.poi.util.TempFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.font.FontDesignMetrics;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ImgUtil {

    protected static Logger logger = LoggerFactory.getLogger(ImgUtil.class);


    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    /**
     * 判断用户密码是否正确
     * newpasswd  用户输入的密码
     * oldpasswd  正确密码
     */
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
//        DrawSuccessPosterByLesson("http://img.jssns.cn/SHILU/1/51404790711261348.png","http://img.jssns.cn/SHILU/1/40168681985236551.png","智性阅读");
//        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment(); //返回本地 GraphicsEnvironment 。
//        String [] forName = e.getAvailableFontFamilyNames(); //返回包含在此所有字体系列名称的数组， GraphicsEnvironment本地化为默认的语言环境，如返回 Locale.getDefault() 。
//        for (int i = 0; i < forName.length; i++) //逐行输出
//            System.out.println(forName[i]);
//       System.out.println(DrawSuccessPoster("http://img.jssns.cn/SHILU/1/b2572a8da5d47d586a04cae64168b649.png","http://img.jssns.cn/SHILU/1/eb818d6c4a0645f781bccfd515c71be1.png","http://img.jssns.cn/SHILU/1/43022872422734077.png","用户名", "在美好的声音中，遇见美妙的梦中，遇见你,dsdhasdkasdasd","嘿嘿嘿呵呵呵呵","哈哈哈"));
//      System.out.println(DrawSuccessPosterByBook("http://img.jssns.cn/SHILU/1/d5fec4fd30bffacd99eeb370cde3b794.png", "http://img.jssns.cn/SHILU/1/b9e31094ef25b321c4fd3c9aa57d2e20.jpg", "http://img.jssns.cn/SHILU/1/43022872422734077.png", "用户名", "在美好的声音中，遇见美妙的梦中，遇见你,dsdhasdkasdasd", "嘿嘿嘿呵呵呵呵", "http://img.njlsedu.cn/SHILU/1/da654a2ea016216d6d9b2f9dd5c1e3a3.png"));
//        System.out.println( DrawSuccessPosterByLesson("http://img.jssns.cn/SHILU/1/51410296903862188.png","http://img.jssns.cn/SHILU/1/51411069217550650.png","小李子，请扫码加我微信"));
    }


    public static Path DrawSuccessPoster(BufferedImage bgBuffer, BufferedImage goodsBuffer, String qrcodeUrl, String wxNickName, String solgan, String albumName, String audioName) throws IOException {

        //背景图片处理
        //    File bg = new File("E:\\backup\\succesBackground.png");// 奖品图缩小

//        URL bg = new URL(modelUrl);
//        BufferedImage bgBuffer = ImageIO.read(modelUrl);

        int widthBg = bgBuffer.getWidth();
        int heightBg = bgBuffer.getHeight();


        //音频图片处理
//        URL AudioRead = new URL(url);//url 头像的URL

//        BufferedImage goodsBuffer = ImageIO.read(url);

        BufferedImage goodsMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(goodsBuffer, 210), 210,
                0);
//        FileOutputStream outImgStream =new FileOutputStream(modelUrl);

        Path tempPng = Files.createTempFile("", ".png");
        ImageIO.write(bgBuffer, "png", tempPng.toFile());

        ImageIO.write(goodsMinBuffer, "png", tempPng.toFile());


//二维码图片处理
        URL qrcodeUrlRead = new URL(qrcodeUrl);//url 为图片的URL// 二维码缩小处理
        BufferedImage erBuffer = ImageIO.read(qrcodeUrlRead);

        BufferedImage erMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(erBuffer, 186), 186, 0);// 二维码缩小

        ImageIO.write(erMinBuffer, "png", tempPng.toFile());


        BufferedImage new1 = ImgUtil.synthesisPicAtXy(bgBuffer, erMinBuffer, 406, 534);// 二维码合并

        BufferedImage new2 = ImgUtil.synthesisPicAtXy(new1, goodsMinBuffer, 38, 296);// 奖品图合并


        ImageIO.write(new2, "png", tempPng.toFile());

        Color black1 = new Color(67, 32, 32);
        Color color = new Color(255, 255, 255); // 白色
        Color black = new Color(51, 51, 51); // 黑色
        Color hui = new Color(171, 171, 171); // 深灰
        Color hui1 = new Color(153, 153, 153); // 蛋灰

        Font font8 = new Font("微软雅黑", Font.BOLD, 8);
        Font font12 = new Font("微软雅黑", Font.BOLD, 14);
        Font font23 = new Font("思源黑体 CN", Font.PLAIN, 23);
        Font font28B = new Font("思源黑体 CN", Font.BOLD, 28);
        Font font28 = new Font("思源黑体 CN", Font.PLAIN, 28);
        Font font26 = new Font("思源黑体 CN", Font.PLAIN, 26);
        Font font34 = new Font("思源黑体 CN", Font.PLAIN, 34);
        Font font50 = new Font("思源黑体 CN", Font.BOLD, 50);

        BufferedImage txt = ImgUtil.addTxtAtXy(new2, albumName, 30, 90, font50, black);
        txt = ImgUtil.addTxtAtXy(txt, audioName, 37, 150, font34, black);
//        String audioNameAll = "";
//        int lines = (audioName.length() / 8);
//        if (audioName.length() > 8) {
//            for (int i = 0; i < lines; i++) {
//                audioNameAll = audioName.substring(0 + (i * 8), 8 + (i * 8));
//                txt = ImgUtil.addTxtAtXy(txt, audioNameAll, 37, 150 + (font34.getSize() + 4) * i, font34, black);
//            }
//            audioNameAll = audioName.substring((lines * 8));
//            txt = ImgUtil.addTxtAtXy(txt, audioNameAll, 37, 150 + (font34.getSize() + 4) * lines, font34, black);
//        } else {
//            txt = ImgUtil.addTxtAtXy(txt, audioName, 37, 150, font34, black);
//        }
//        String userName = "我是" + wxNickName;
        txt = ImgUtil.addTxtAtXy(txt, wxNickName, 92, 704, font26, black1);
//        String name = "邀您一起读书";
//        String name1 = "识别二维码，免费听好书";
//        txt = ImgUtil.addTxtAtXy(txt, name, 42, 750, font28B, black1);
//        txt = ImgUtil.addTxtAtXy(txt, name1, 42, 800, font23, black1);


        String activityName = "";
        //换行处理
        int line = (solgan.length() / 11);
        if (solgan.length() > 11) {
            for (int i = 0; i < line; i++) {
                activityName = solgan.substring(0 + (i * 11), 11 + (i * 11));
                txt = ImgUtil.addTxtAtXy(txt, activityName, 273, 320 + (font28.getSize() + 12) * i, font28, black);
            }
            activityName = solgan.substring((line * 8));
            txt = ImgUtil.addTxtAtXy(txt, activityName, 273, 320 + (font28.getSize() + 12) * line, font28, black);
        } else {
            txt = ImgUtil.addTxtAtXy(txt, solgan, 273, 320, font28, black);
        }
//        Path tempFile = Files.createTempFile("", ".png");
        //  Graphics2D gd = txt.createGraphics();
        //  gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        ImageIO.write(txt, "png", tempPng.toFile());
        // 上传到服务器
//        System.out.println(tempPng.toAbsolutePath());
//        MiniQrcodeService miniQrcodeService = new MiniQrcodeService();
//        FileInputStream fis = new FileInputStream(tempPng.toFile());
//        String shareUrl = miniQrcodeService.inputStreamUpload(fis, "shareUrl");
//        System.err.println(shareUrl);
        return tempPng;

    }


    public static Path DrawSuccessPosterByLesson(String modelUrl,  String qrcodeUrl, String wxNickName) throws IOException {

        //背景图片处理
        //    File bg = new File("E:\\backup\\succesBackground.png");// 奖品图缩小

        URL bg = new URL(modelUrl);
        BufferedImage bgBuffer = ImageIO.read(bg);

        int widthBg = bgBuffer.getWidth();
        int heightBg = bgBuffer.getHeight();


        //书籍图片处理
//        URL BookRead = new URL(url);//url 头像的URL
//
//        BufferedImage goodsBuffer = ImageIO.read(BookRead);

//        BufferedImage goodsMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(goodsBuffer, 280), 220,0);
//        BufferedImage goodsMinBuffer = ImgUtil.zoomInImage(goodsBuffer, 220, 280);
//        FileOutputStream outImgStream =new FileOutputStream(modelUrl);

        Path tempPng = Files.createTempFile("", ".png");
        ImageIO.write(bgBuffer, "png", tempPng.toFile());
//
//        ImageIO.write(goodsMinBuffer, "png", tempPng.toFile());


//二维码图片处理
        URL qrcodeUrlRead = new URL(qrcodeUrl);//url 为图片的URL// 二维码缩小处理
        BufferedImage erBuffer = ImageIO.read(qrcodeUrlRead);

        BufferedImage erMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(erBuffer, 214), 214, 0);// 二维码缩小

        ImageIO.write(erMinBuffer, "png", tempPng.toFile());

        //背景图片处理
//        URL backdropUrlRead = new URL(backdropUrl);//url 为图片的URL// 二维码缩小处理
//        BufferedImage bdBuffer = ImageIO.read(backdropUrlRead);

//        BufferedImage erbdBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(bdBuffer, 186), 186, 0);// 二维码缩小
//        erbdBuffer = ImgUtil.zoomInImage(bdBuffer, 186, 186);
//        ImageIO.write(erbdBuffer, "png", tempPng.toFile());


        BufferedImage new0 = ImgUtil.synthesisPicAtXy(bgBuffer, erMinBuffer, 218, 314);// 二维码合并

//        BufferedImage new1 = ImgUtil.synthesisPicAtXy(new0, goodsMinBuffer, 195, 250);// 二维码图合并
//
//        BufferedImage new2 = ImgUtil.synthesisPicAtXy(new1, erbdBuffer, 325, 595);// 背景图合并

        ImageIO.write(new0, "png", tempPng.toFile());

        Color yellow = new Color(184, 119, 14);
        Color color = new Color(255, 255, 255); // 白色
        Color black = new Color(51, 51, 51); // 黑色
        Color hui = new Color(171, 171, 171); // 深灰
        Color hui1 = new Color(153, 153, 153); // 蛋灰
//        Color yellow = new Color(255, 255, 0); //黄色

        Font font8 = new Font("思源黑体 CN", Font.BOLD, 8);
        Font font12 = new Font("思源黑体 CN", Font.BOLD, 14);
        Font font23 = new Font("思源黑体 CN", Font.BOLD, 23);
//        Font font28 = new Font("思源黑体 CN", Font.BOLD, 28);
        Font font30 = new Font("思源黑体 CN", Font.PLAIN, 30);
        Font font24 = new Font("思源黑体 CN", Font.BOLD, 24);
        Font font32 = new Font("思源黑体 CN", Font.BOLD, 32);
        Font font34 = new Font("思源黑体 CN", Font.BOLD, 34);
        Font font50 = new Font("思源黑体 CN", Font.BOLD, 50);

//        int length = bookName.length();
//       BufferedImage txt = ImgUtil.addTxtAtXy(new2, bookName, (594 - length * font28.getSize()) / 2, 230, font28, black1);
        String userName = wxNickName ;
        BufferedImage  txt = ImgUtil.addTxtAtXy(new0, userName, 100, 68, font30, yellow);
//        String name = "智性阅读";
//
//        String name2 = "扫码学习";
//        txt = ImgUtil.addTxtAtXy(txt, name, 30, 50, font32, black);
//
//        txt = ImgUtil.addTxtAtXy(txt, name2, (594 - name2.length() * font28.getSize()) / 2, 830, font28, color);
//
//        String activityName = "";
//        //换行处理
//        int line = (solgan.length() / 12);
//        if (solgan.length() > 12) {
//            for (int i = 0; i < line; i++) {
//                activityName = solgan.substring(0 + (i * 12), 12 + (i * 12));
//                txt = ImgUtil.addTxtAtXy(txt, activityName, 140, 510 + (font28.getSize() + 4) * i, font28, black);
//            }
//            activityName = solgan.substring((line * 12));
//            txt = ImgUtil.addTxtAtXy(txt, activityName, 140, 510 + (font28.getSize() + 4) * line, font28, black);
//        } else {
//            txt = ImgUtil.addTxtAtXy(txt, solgan, 140, 510, font28, black);
//        }
//        Path tempFile = Files.createTempFile("", ".png");
        // Graphics2D gd = txt.createGraphics();
        // gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        ImageIO.write(txt, "png", tempPng.toFile());
        // 上传到服务器
//        System.out.println(tempPng.toAbsolutePath());
//        MiniQrcodeService miniQrcodeService = new MiniQrcodeService();
//        FileInputStream fis = new FileInputStream(tempPng.toFile());
//        String shareUrl = miniQrcodeService.inputStreamUpload(fis, "shareUrl");
//        System.err.println(shareUrl);
        return tempPng;

    }




    public static Path DrawSuccessPosterByBook(BufferedImage bgBuffer, BufferedImage goodsBuffer, String qrcodeUrl, String wxNickName, String solgan, String bookName, BufferedImage bdBuffer) throws IOException {

        //背景图片处理
        //    File bg = new File("E:\\backup\\succesBackground.png");// 奖品图缩小

//        URL bg = new URL(modelUrl);
//        BufferedImage bgBuffer = ImageIO.read(bg);

        int widthBg = bgBuffer.getWidth();
        int heightBg = bgBuffer.getHeight();


        //书籍图片处理
//        URL BookRead = new URL(url);//url 头像的URL
//
//        BufferedImage goodsBuffer = ImageIO.read(BookRead);

//        BufferedImage goodsMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(goodsBuffer, 280), 220,0);
        BufferedImage goodsMinBuffer = ImgUtil.zoomInImage(goodsBuffer, 220, 280);
//        FileOutputStream outImgStream =new FileOutputStream(modelUrl);

        Path tempPng = Files.createTempFile("", ".png");
        ImageIO.write(bgBuffer, "png", tempPng.toFile());

        ImageIO.write(goodsMinBuffer, "png", tempPng.toFile());


//二维码图片处理
        URL qrcodeUrlRead = new URL(qrcodeUrl);//url 为图片的URL// 二维码缩小处理
        BufferedImage erBuffer = ImageIO.read(qrcodeUrlRead);

        BufferedImage erMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(erBuffer, 210), 210, 0);// 二维码缩小

        ImageIO.write(erMinBuffer, "png", tempPng.toFile());

        //背景图片处理
//        URL backdropUrlRead = new URL(backdropUrl);//url 为图片的URL// 二维码缩小处理
//        BufferedImage bdBuffer = ImageIO.read(backdropUrlRead);

        BufferedImage erbdBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(bdBuffer, 186), 186, 0);// 二维码缩小
        erbdBuffer = ImgUtil.zoomInImage(bdBuffer, 186, 186);
        ImageIO.write(erbdBuffer, "png", tempPng.toFile());


        BufferedImage new0 = ImgUtil.synthesisPicAtXy(bgBuffer, erMinBuffer, 94, 589);// 二维码合并

        BufferedImage new1 = ImgUtil.synthesisPicAtXy(new0, goodsMinBuffer, 195, 250);// 二维码图合并

        BufferedImage new2 = ImgUtil.synthesisPicAtXy(new1, erbdBuffer, 325, 595);// 背景图合并

        ImageIO.write(new2, "png", tempPng.toFile());

        Color black1 = new Color(67, 32, 32);
        Color color = new Color(255, 255, 255); // 白色
        Color black = new Color(51, 51, 51); // 黑色
        Color hui = new Color(171, 171, 171); // 深灰
        Color hui1 = new Color(153, 153, 153); // 蛋灰
        Color yellow = new Color(255, 255, 0); //黄色

        Font font8 = new Font("思源黑体 CN", Font.BOLD, 8);
        Font font12 = new Font("思源黑体 CN", Font.BOLD, 14);
        Font font23 = new Font("思源黑体 CN", Font.BOLD, 23);
//        Font font28 = new Font("思源黑体 CN", Font.BOLD, 28);
        Font font28 = new Font("思源黑体 CN", Font.PLAIN, 28);
        Font font24 = new Font("思源黑体 CN", Font.BOLD, 24);
        Font font32 = new Font("思源黑体 CN", Font.BOLD, 32);
        Font font34 = new Font("思源黑体 CN", Font.BOLD, 34);
        Font font50 = new Font("思源黑体 CN", Font.BOLD, 50);

        int length = bookName.length();
        BufferedImage txt = ImgUtil.addTxtAtXy(new2, bookName, (594 - length * font28.getSize()) / 2, 230, font28, black1);
        String userName = wxNickName + "邀请您一起免费观看";
        txt = ImgUtil.addTxtAtXy(txt, userName, 30, 85, font28, black1);
        String name = "智性阅读";

        String name2 = "扫码学习";
        txt = ImgUtil.addTxtAtXy(txt, name, 30, 30, font32, black);

        txt = ImgUtil.addTxtAtXy(txt, name2, (594 - name2.length() * font28.getSize()) / 2, 830, font28, color);

        String activityName = "";
        //换行处理
        int line = (solgan.length() / 12);
        if (solgan.length() > 12) {
            for (int i = 0; i < line; i++) {
                activityName = solgan.substring(0 + (i * 12), 12 + (i * 12));
                txt = ImgUtil.addTxtAtXy(txt, activityName, 140, 510 + (font28.getSize() + 4) * i, font28, black);
            }
            activityName = solgan.substring((line * 12));
            txt = ImgUtil.addTxtAtXy(txt, activityName, 140, 510 + (font28.getSize() + 4) * line, font28, black);
        } else {
            txt = ImgUtil.addTxtAtXy(txt, solgan, 140, 510, font28, black);
        }
//        Path tempFile = Files.createTempFile("", ".png");
        // Graphics2D gd = txt.createGraphics();
        // gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        ImageIO.write(txt, "png", tempPng.toFile());
        // 上传到服务器
//        System.out.println(tempPng.toAbsolutePath());
//        MiniQrcodeService miniQrcodeService = new MiniQrcodeService();
//        FileInputStream fis = new FileInputStream(tempPng.toFile());
//        String shareUrl = miniQrcodeService.inputStreamUpload(fis, "shareUrl");
//        System.err.println(shareUrl);
        return tempPng;

    }

    public static Path DrawSuccessPosterByIssue(BufferedImage modelUrl, String qrcodeUrl, BufferedImage starUrl, String wxNickName, String bookName, int rightNum, int starNum) throws IOException {

        //背景图片处理
        //    File bg = new File("E:\\backup\\succesBackground.png");// 奖品图缩小
//        URL bg = new URL(modelUrl);
//        BufferedImage bgBuffer = ImageIO.read(bg);

        int widthBg = modelUrl.getWidth();
        int heightBg = modelUrl.getHeight();


        //书籍图片处理
//        URL BookRead = new URL(url);//url 头像的URL
//
//        BufferedImage goodsBuffer = ImageIO.read(BookRead);

//        BufferedImage goodsMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(goodsBuffer, 280), 220,0);
//        BufferedImage goodsMinBuffer = ImgUtil.zoomInImages(logoUrl, 120,120);
//        FileOutputStream outImgStream =new FileOutputStream(modelUrl);

        Path tempPng = Files.createTempFile("", ".png");
        ImageIO.write(modelUrl, "png", tempPng.toFile());

//        ImageIO.write(goodsMinBuffer, "png", tempPng.toFile());


//二维码图片处理
        URL qrcodeUrlRead = new URL(qrcodeUrl);//url 为图片的URL// 二维码缩小处理
        BufferedImage erBuffer = ImageIO.read(qrcodeUrlRead);

        BufferedImage erMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(erBuffer, 186), 186, 0);// 二维码缩小

        ImageIO.write(erMinBuffer, "png", tempPng.toFile());

        //背景图片处理
//        URL backdropUrlRead = new URL(backdropUrl);//url 为图片的URL// 二维码缩小处理
//        BufferedImage bdBuffer = ImageIO.read(backdropUrlRead);

        BufferedImage erbdBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(starUrl, 186), 186, 0);// 二维码缩小
        erbdBuffer = ImgUtil.zoomInImage(starUrl, 300, 48);
        ImageIO.write(erbdBuffer, "png", tempPng.toFile());


        BufferedImage new0 = ImgUtil.synthesisPicAtXy(modelUrl, erMinBuffer, 215, 544);// 二维码合并

//        BufferedImage new1 = ImgUtil.synthesisPicAtXy(new0, goodsMinBuffer, 244, 160);// 二维码图合并

        BufferedImage new2 = ImgUtil.synthesisPicAtXy(new0, erbdBuffer, 175, 295);// 背景图合并

        ImageIO.write(new2, "png", tempPng.toFile());

        Color yellow = new Color(251,212,35);
        Color color = new Color(255, 255, 255); // 白色
        Color black = new Color(51, 51, 51); // 黑色
        Color hui = new Color(67, 32, 32); // 深灰
        Color hui1 = new Color(153, 153, 153); // 蛋灰
        Color red = new Color(249, 84, 108); //红色

        Font font8 = new Font("思源黑体 CN", Font.BOLD, 8);
        Font font12 = new Font("思源黑体 CN", Font.BOLD, 14);
        Font font23 = new Font("思源黑体 CN", Font.BOLD, 23);
//        Font font28 = new Font("思源黑体 CN", Font.BOLD, 28);
        Font font28 = new Font("思源黑体 CN", Font.PLAIN, 28);
        Font font24 = new Font("思源黑体 CN", Font.BOLD, 24);
        Font font30 = new Font("思源黑体 CN", Font.PLAIN, 30);
        Font font34 = new Font("思源黑体 CN", Font.BOLD, 34);
        Font font42 = new Font("思源黑体 CN", Font.BOLD, 42);


        wxNickName = wxNickName+"";
//        String name2 = "让孩子知道自己有多优秀!";
        String name3 = "恭喜您在";
        String name4 ="习题闯关中";
        String name5 = "恭喜您在"+bookName+"习题闯关中";
        String rightNums =rightNum+"";
        String starNums = starNum+"";
        String name6 ="答对"+rightNum+"题，获取"+starNum+"颗星";
        String name7 ="答对";
        String name8 ="题，获取";
        String name9 ="颗星";

       BufferedImage txt =  ImgUtil.addTxtAtXy(new2, wxNickName, (650 - wxNickName.length() * font30.getSize()) / 2, 290, font30, hui);
        Graphics2D g2d = txt.createGraphics();
        FontMetrics metrics = g2d.getFontMetrics(font28);
        // Determine the Y coordinate for the text (note we add the ascent, as

//        txt = ImgUtil.addTxtAtXy(txt, name2, (650 - metrics.stringWidth(name2)) / 2, 820, font28, color);
        txt = ImgUtil.addTxtAtXy(txt, name3, (650 - metrics.stringWidth(name5)) / 2, 422, font28, color);
        txt = ImgUtil.addTxtAtXy(txt, bookName, (650 - metrics.stringWidth(name5)) / 2+metrics.stringWidth(name3), 422, font28, yellow);
        txt = ImgUtil.addTxtAtXy(txt, name4, (650 - metrics.stringWidth(name5)) / 2+metrics.stringWidth(name3)+metrics.stringWidth(bookName), 422, font28, color);
        txt = ImgUtil.addTxtAtXy(txt, name7, (650 - metrics.stringWidth(name6)) / 2, 422 + (font30.getSize() + 4), font28, color);
        txt = ImgUtil.addTxtAtXy(txt, rightNums, (650 - metrics.stringWidth(name6)) / 2+ metrics.stringWidth(name7), 422 + (font30.getSize() + 4), font28, yellow);
        txt = ImgUtil.addTxtAtXy(txt, name8, (650 - metrics.stringWidth(name6)) / 2+ metrics.stringWidth(name7)+metrics.stringWidth(rightNums), 422 + (font30.getSize() + 4), font28, color);
        txt = ImgUtil.addTxtAtXy(txt, starNums, (650 - metrics.stringWidth(name6)) / 2+ metrics.stringWidth(name7)+metrics.stringWidth(rightNums)+metrics.stringWidth(name8), 422 + (font30.getSize() + 4), font28, yellow);
        txt = ImgUtil.addTxtAtXy(txt, name9, (650 - metrics.stringWidth(name6)) / 2+ metrics.stringWidth(name7)+metrics.stringWidth(rightNums)+metrics.stringWidth(name8)+metrics.stringWidth(starNums), 422 + (font30.getSize() + 4), font28, color);
//        String activityName = "";
        //换行处理

//        int line = (slognName.length() / 12);
//        if (slognName.length() > 12) {
//            for (int i = 0; i < line; i++) {
//                activityName = slognName.substring(0 + (i * 12), 12 + (i * 12));
//                txt = ImgUtil.addTxtAtXy(txt, activityName, (594 - 12 * font30.getSize()) / 2, 420 + (font30.getSize() + 4) * i, font30, color);
//            }
//            activityName = slognName.substring((line * 12));
//            txt = ImgUtil.addTxtAtXy(txt, activityName, (594 - 12 * font30.getSize()) / 2, 420 + (font30.getSize() + 4) * line, font30, color);
//        } else {
//            txt = ImgUtil.addTxtAtXy(txt, slognName, (594 - 12 * font30.getSize()) / 2, 420, font30, color);
//        }
//        Path tempFile = Files.createTempFile("", ".png");
        // Graphics2D gd = txt.createGraphics();
        // gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        ImageIO.write(txt, "png", tempPng.toFile());
        // 上传到服务器
//        System.out.println(tempPng.toAbsolutePath());
//        MiniQrcodeService miniQrcodeService = new MiniQrcodeService();
//        FileInputStream fis = new FileInputStream(tempPng.toFile());
//        String shareUrl = miniQrcodeService.inputStreamUpload(fis, "shareUrl");
//        System.err.println(shareUrl);
        return tempPng;

    }

    /**
     * 获取指定字体指定内容的宽度
     *
     * @param font
     * @param content
     * @return
     */
    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }

    /**
     * 获取指定字体指定内容的宽度
     *
     * @param font
     * @param content
     * @return
     */
    public static int getWordWidthBody(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);

        return metrics.stringWidth(content);

    }

    /**
     * 按比例裁剪图片
     *
     * @param src    待处理的图片流
     * @param startX 开始x坐标
     * @param startY 开始y坐标
     * @param endX   结束x坐标
     * @param endY   结束y坐标
     * @return
     */
    public static BufferedImage crop(BufferedImage src, int startX, int startY, int endX, int endY) {
        int width = src.getWidth();
        int height = src.getHeight();
        if (startX <= -1) {
            startX = 0;
        }
        if (startY <= -1) {
            startY = 0;
        }
        if (endX <= -1) {
            endX = width - 1;
        }
        if (endY <= -1) {
            endY = height - 1;
        }
        BufferedImage result = new BufferedImage(endX, endY, src.getType());
        for (int y = startY; y < endY + startY; y++) {
            for (int x = startX; x < endX + startX; x++) {
                int rgb = src.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        return result;
    }

       /**
     * 对图片进行强制放大或缩小
     *
     * @param originalImage 原始图片
     * @return
     */
    public static BufferedImage zoomInImage(BufferedImage originalImage, int width, int height) {
        /* 新建一个空白画布 */
        BufferedImage image = new BufferedImage(width, height, originalImage.getType());
        // BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        /* 设置背景透明 */
        image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        // g2d.dispose();
        g2d = image.createGraphics();

        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return image;
    }

    public static BufferedImage zoomInImages(BufferedImage originalImage, int width, int height) {
        /* 新建一个空白画布 */
        BufferedImage image = new BufferedImage(width, height, originalImage.getType());
        // BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

//        /* 设置背景透明 */
//        image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//        // g2d.dispose();
//        g2d = image.createGraphics();

        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return image;
    }


    /**
     * 实现图像的等比缩放(固定宽度)
     *
     * @param source  待处理的图片流
     * @param targetW 宽度
     * @return
     */
    public static BufferedImage resizeByWidth(BufferedImage source, double targetW) {
        double targetH = 0;
        double width = source.getWidth();// 图片宽度
        double height = source.getHeight();// 图片高度
        targetH = targetW / width * height;

        return zoomInImage(source, (int) targetW, (int) targetH);

    }

    /**
     * 实现图像的等比缩放(固定高度)
     *
     * @param source  待处理的图片流
     * @param targetH 高度
     * @return
     */
    public static BufferedImage resizeByHeight(BufferedImage source, double targetH) {
        double targetW;

        double width = source.getWidth();// 图片宽度
        double height = source.getHeight();// 图片高度
        targetW = targetH / height * width;

        return zoomInImage(source, (int) targetW, (int) targetH);
        // 图片宽高都太小时，强制放大图片
    }

    /***
     *
     * @param srcImgPath
     *            源图片文件路径
     * @param destImgPath
     *            新生成的图片的保存路径，需要带有保存的文件名和后缀
     * @param targetSize
     *            文件的边长，单位：像素，最终得到的是一张正方形的图，所以要求targetSize<=源文件的最小边长
     * @param cornerRadius
     *            圆角半径，单位：像素。如果=targetSize那么得到的是圆形图
     * @return 文件的保存路径
     * @throws IOException
     */
    public static String roundImage(String srcImgPath, String destImgPath, int targetSize, int cornerRadius) {
        BufferedImage bufferedImage = null;
        BufferedImage circularBufferImage = null;
        try {
            bufferedImage = ImageIO.read(new File(srcImgPath));
            circularBufferImage = roundImage(bufferedImage, targetSize, cornerRadius);
            ImageIO.write(circularBufferImage, "png", new File(destImgPath));
            return destImgPath;
        } catch (Exception e) {
            logger.error("图片合成roundImage异常：" + e);
        } finally {
            if (bufferedImage != null) {
                bufferedImage.flush();
                bufferedImage = null;
            }
            if (circularBufferImage != null) {
                circularBufferImage.flush();
                circularBufferImage = null;
            }

        }

        return destImgPath;
    }

    /**
     * 将图片处理为圆角图片
     *
     * @param image
     * @param targetSize   直径
     * @param cornerRadius
     * @return
     */
    public static BufferedImage roundImage(BufferedImage image, int targetSize, int cornerRadius) {
        BufferedImage outputImage = new BufferedImage(targetSize, targetSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = outputImage.createGraphics();

        g2d.setComposite(AlphaComposite.Src);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fill(new RoundRectangle2D.Float(0, 0, targetSize, targetSize, cornerRadius, cornerRadius));
        g2d.setComposite(AlphaComposite.SrcAtop);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return outputImage;
    }

    /**
     * 将第二张图片放到第一张的指定位置
     *
     * @param imageFirst
     * @param imageSecond
     * @param x
     * @param y
     */
    public static BufferedImage synthesisPicAtXy(BufferedImage imageFirst, BufferedImage imageSecond, int x, int y) {
        BufferedImage image = null;
        try {
            /* 读取第一张图片 宽高 */
            int width = imageFirst.getWidth();// 图片宽度
            int height = imageFirst.getHeight();// 图片高度

            /* 读取第二张图片 宽高 */
            int widthTwo = imageSecond.getWidth();// 图片宽度
            int heightTwo = imageSecond.getHeight();// 图片高度

            /* 计算总宽度 */
            int w = 0;
            if (x + widthTwo > width) {
                w = widthTwo + x;
            } else {
                w = width;
            }

            /* 计算总高度 */
            int h = 0;
            if (y + heightTwo > height) {
                h = heightTwo + y;
            } else {
                h = height;
            }

            /* 新建一个空白画布 */
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();

            /* 设置背景透明 */
            image = g2d.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
            // g2d.dispose();
            g2d = image.createGraphics();
            g2d.drawImage(imageFirst, 0, 0, w, h, null);
            g2d.drawImage(imageSecond, x, y, widthTwo, heightTwo, null);

            return image;

        } catch (Exception e) {
            if (image != null) {
                image.flush();
                image = null;
            }
            logger.error("横向合成图片出错....", e);
        }
        return null;
    }

    /**
     * 将第二张图片放到第一张的指定位置
     *
     * @param first
     * @param second
     * @param out
     * @param x
     * @param y
     */
    public static String synthesisPicAtXy(String first, String second, String out, int x, int y) {
        BufferedImage imageFirst = null;
        BufferedImage imageSecond = null;
        BufferedImage outBuffered = null;
        try {
            File fileOne = new File(first);
            imageFirst = ImageIO.read(fileOne);
            File fileTwo = new File(second);
            imageSecond = ImageIO.read(fileTwo);
            outBuffered = synthesisPicAtXy(imageFirst, imageSecond, x, y);
            File outFile = new File(out);
            ImageIO.write(outBuffered, "png", outFile);// 写图片
            return out;

        } catch (Exception e) {
            logger.error("横向合成图片出错....", e);
        } finally {
            if (imageFirst != null) {
                imageFirst.flush();
                imageFirst = null;
            }
            if (imageSecond != null) {
                imageSecond.flush();
                imageSecond = null;
            }
            if (outBuffered != null) {
                outBuffered.flush();
                outBuffered = null;
            }
        }
        return null;
    }

    /**
     * 将文字添加到图片指定的位置
     *
     * @param src
     * @param out
     * @param x
     * @param y
     * @param center 可选居中 默认false
     * @param font
     * @return
     */
    public static String addTxtAtXy(String src, String out, String txt, int x, int y, boolean center, Font font,
                                    Color color) {
        BufferedImage picBuffer = null;
        BufferedImage outBuffered = null;
        try {
            File fileOne = new File(src);
            picBuffer = ImageIO.read(fileOne);
            outBuffered = addTxtAtXy(picBuffer, txt, x, y, font, color);
            File outFile = new File(out);
            ImageIO.write(outBuffered, "png", outFile);// 写图片
            return out;

        } catch (Exception e) {
            logger.error("横向合成图片出错....", e);
            // e.printStackTrace(e);
        } finally {
            if (picBuffer != null) {
                picBuffer.flush();
                picBuffer = null;
            }
        }
        return null;
    }

    /**
     * 将文字txt添加到图片指定的位置(x,y)
     *
     * @param src
     * @param txt
     * @param x
     * @param y
     * @param font  可选水平居中 默认false
     * @param color
     * @return
     */
    public static BufferedImage addTxtAtXy(BufferedImage src, String txt, int x, int y, Font font, Color color) {
        BufferedImage outBuffer = null;
        try {

            /* 读取图片 宽高 */
            int width = src.getWidth();// 图片宽度
            int height = src.getHeight();// 图片高度

            /* 新建一个空白画布 */
            outBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outBuffer.createGraphics();
            /* 设置背景透明 */
            outBuffer = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);

            g2d = outBuffer.createGraphics();
            g2d.drawImage(src, 0, 0, width, height, null);

            g2d.setColor(color);
            g2d.setFont(font);

//            最常用的渲染提示是在文本的边缘混合前景和背景颜色。要在应用程序中请求这种提示，必须用下面的方法：
//            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//            如果滥用这个方法，会导致文本展示过度的模糊。这种情况下，更好的渲染提示如下：
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, (RenderingHints.VALUE_TEXT_ANTIALIAS_GASP));
//            LCD展示是一个属性，Java 2D API可以用它创建不是很模糊的抗锯齿文本，但在小字体时又能清晰展示。要使用这种绘制方式，需要使用以下代码：
//            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, (RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB));

            // 10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
            g2d.drawString(txt, x, y);
            g2d.dispose();
            return outBuffer;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace(e);
            logger.error("合成图片 添加文字出错....", e);
        }
        return null;

    }

}



