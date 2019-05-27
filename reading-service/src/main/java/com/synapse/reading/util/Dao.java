package com.synapse.reading.util;


import com.aliyun.vod.upload.impl.UploadImageImpl;
import com.aliyun.vod.upload.req.UploadImageRequest;
import com.aliyun.vod.upload.resp.UploadImageResponse;
import com.aliyuncs.vod.model.v20170321.CreateUploadImageRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;

public class Dao  {

    private static final String accessKeyId = "LTAIu9Ly4UYtB0MT";
    //账号AK信息请填写(必选)
    private static final String accessKeySecret = "8r47lu5kRje8UarSp1DG81oX0NF8CB";
    public static void main(String[] args) {
        //1.音视频上传-本地文件上传
        //视频标题(必选)
        String title = "测试标题";
        //本地文件上传和文件流上传时，文件名称为上传文件绝对路径，如:/User/sample/文件名称.mp4 (必选)
        //文件名必须包含扩展名
        String fileName = "测试文件名称.mp4";

        //2.图片上传-本地文件上传
        testUploadImageLocalFile(accessKeyId, accessKeySecret);
    }


        private static void testUploadImageLocalFile(String accessKeyId, String accessKeySecret) {
            // 图片类型（必选）取值范围：default（默认)，cover（封面），watermark(水印)
            String imageType = "cover";
            UploadImageRequest request = new UploadImageRequest(accessKeyId, accessKeySecret, imageType);
        /* 图片文件扩展名（可选）取值范围：png，jpg，jpeg */
            //request.setImageExt("png");
        /* 图片标题（可选）长度不超过128个字节，UTF8编码 */
            //request.setTitle("图片标题");
        /* 图片标签（可选）单个标签不超过32字节，最多不超过16个标签，多个用逗号分隔，UTF8编码 */
            //request.setTags("标签1,标签2");
        /* 存储区域（可选）*/
//          request.setStorageLocation("out-4f3952f78c0211e8b3020013e7.oss-cn-shanghai.aliyuncs.com");
        /* 流式上传时，InputStream为必选，fileName为源文件名称，如:文件名称.png(可选)*/
            request.setFileName("E:\\backup\\succesBackground.png");
//            request.setInputStream();
        /* 开启默认上传进度回调 */
            // request.setPrintProgress(true);
        /* 设置自定义上传进度回调 (必须继承 ProgressListener) */
            // request.setProgressListener(new PutObjectProgressListener());
            UploadImageImpl uploadImage = new UploadImageImpl();
            UploadImageResponse response = uploadImage.upload(request);
            System.out.print("RequestId=" + response.getRequestId() + "\n");
            if (response.isSuccess()) {
                System.out.print("ImageId=" + response.getImageId() + "\n");
                System.out.print("ImageURL=" + response.getImageURL() + "\n");
            } else {
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
            }
        }
    }


