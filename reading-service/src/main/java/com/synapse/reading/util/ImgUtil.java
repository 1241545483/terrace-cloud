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

        DrawSuccessPoster("http://img.jssns.cn/SHILU/1/b2572a8da5d47d586a04cae64168b649.png", "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eryLJEEaUiaChys4Vegu5FduefB349CNeIBzffGiaXHeYutOexIQWI1OLnGnk5Yg2cDIO3SD2JjXdJw/132", "http://img.jssns.cn/SHILU/1/40135292169711806.png", "用户名", "在美好的声音中，遇见美妙的梦中，遇见你",  "专辑名称", "音频名称音频名称音频名称音频名称音频名");

    }


    public static Path DrawSuccessPoster(String modelUrl, String url, String qrcodeUrl, String wxNickName, String solgan,  String albumName, String audioName) throws IOException {

        //背景图片处理
        //    File bg = new File("E:\\backup\\succesBackground.png");// 奖品图缩小

        URL bg = new URL(modelUrl);
        BufferedImage bgBuffer = ImageIO.read(bg);

        int widthBg = bgBuffer.getWidth();
        int heightBg = bgBuffer.getHeight();


        //音频图片处理
        URL AudioRead = new URL(url);//url 头像的URL

        BufferedImage goodsBuffer = ImageIO.read(AudioRead);

        BufferedImage goodsMinBuffer = ImgUtil.roundImage(ImgUtil.resizeByHeight(goodsBuffer, 167), 182,
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


        BufferedImage new1 = ImgUtil.synthesisPicAtXy(bgBuffer, erMinBuffer, 395, 553);// 二维码合并

        BufferedImage new2 = ImgUtil.synthesisPicAtXy(new1, goodsMinBuffer, 44, 304);// 奖品图合并


        ImageIO.write(new2, "png", tempPng.toFile());

        Color black1 = new Color(67, 32, 32);
        Color color = new Color(255, 255, 255); // 白色
        Color black = new Color(51, 51, 51); // 黑色
        Color hui = new Color(171, 171, 171); // 深灰
        Color hui1 = new Color(153, 153, 153); // 蛋灰

        Font font8 = new Font("微软雅黑", Font.BOLD, 8);
        Font font12 = new Font("微软雅黑", Font.BOLD, 14);
        Font font23 = new Font("微软雅黑", Font.BOLD, 23);
        Font font28 = new Font("微软雅黑", Font.BOLD, 28);
        Font font24 = new Font("微软雅黑", Font.BOLD, 24);
        Font font34 = new Font("微软雅黑", Font.BOLD, 34);
        Font font50 = new Font("微软雅黑", Font.BOLD, 50);

        BufferedImage txt = ImgUtil.addTxtAtXy(new2, albumName, 30, 65, font50, black);
        String audioNameAll = "";
        int lines = (audioName.length() / 8);
        if (audioName.length() > 8) {
            for (int i = 0; i < lines; i++) {
                audioNameAll = audioName.substring(0 + (i * 8), 8 + (i * 8));
                txt = ImgUtil.addTxtAtXy(txt, audioNameAll, 37, 120 + (font34.getSize() + 4) * i, font34, black);
            }
            audioNameAll = audioName.substring((lines * 8));
            txt = ImgUtil.addTxtAtXy(txt, audioNameAll, 37, 120 + (font34.getSize() + 4) * lines, font34, black);
        } else {
            txt = ImgUtil.addTxtAtXy(txt, audioName, 37, 120, font34, black);
        }
        String userName = "我是" + wxNickName;
        txt = ImgUtil.addTxtAtXy(txt, userName, 42, 696, font24, black1);
        String name = "邀您一起读书";
        String name1 = "识别二维码，免费听好书";
        txt = ImgUtil.addTxtAtXy(txt, name, 42, 750, font28, black1);
        txt = ImgUtil.addTxtAtXy(txt, name1, 42, 800, font23, black1);


        String activityName = "";
        //换行处理
        int line = (solgan.length() / 8);
        if (solgan.length() > 8) {
            for (int i = 0; i < line; i++) {
                activityName = solgan.substring(0 + (i * 8), 8 + (i * 8));
                txt = ImgUtil.addTxtAtXy(txt, activityName, 273, 294 + (font28.getSize() + 4) * i, font28, black);
            }
            activityName = solgan.substring((line * 8));
            txt = ImgUtil.addTxtAtXy(txt, activityName, 273, 294 + (font28.getSize() + 4) * line, font28, black);
        } else {
            txt = ImgUtil.addTxtAtXy(txt, solgan, 273, 294, font28, black);
        }
//        Path tempFile = Files.createTempFile("", ".png");
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



