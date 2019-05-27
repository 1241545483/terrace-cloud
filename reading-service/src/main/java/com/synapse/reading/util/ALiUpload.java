package com.synapse.reading.util;

import com.aliyun.vod.upload.impl.UploadImageImpl;
import com.aliyun.vod.upload.req.UploadImageRequest;
import com.aliyun.vod.upload.resp.UploadImageResponse;
import com.synapse.reading.remote.Upload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;


@Service
@Transactional
public class ALiUpload implements Upload {
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${endpoint}")
    private String endpoint;
    /**
     * 上传到OSS服务器 如果同名文件会覆盖服务器上的
     *
     * @param
     * @param instream 文件流
     * @return 出错返回"" ,唯一MD5数字签名
     */
    @Override
    public  String upload(InputStream instream,String name) {
        // 图片类型（必选）取值范围：default（默认)，cover（封面），watermark(水印)
        String imageType = "default";
        UploadImageRequest request = new UploadImageRequest(accessKeyId, accessKeySecret,imageType );
        /* 图片文件扩展名（可选）取值范围：png，jpg，jpeg */
        //request.setImageExt("png");
        /* 图片标题（可选）长度不超过128个字节，UTF8编码 */
        //request.setTitle("图片标题");
        /* 图片标签（可选）单个标签不超过32字节，最多不超过16个标签，多个用逗号分隔，UTF8编码 */
        //request.setTags("标签1,标签2");
        /* 存储区域（可选）*/
          request.setStorageLocation(endpoint);
        /* 流式上传时，InputStream为必选，fileName为源文件名称，如:文件名称.png(可选)*/
//        request.setFileName("E:\\backup\\succesBackground.png");
        request.setInputStream(instream);
        /* 开启默认上传进度回调 */
        // request.setPrintProgress(true);
        /* 设置自定义上传进度回调 (必须继承 ProgressListener) */
        // request.setProgressListener(new PutObjectProgressListener());
        UploadImageImpl uploadImage = new UploadImageImpl();
        UploadImageResponse response = uploadImage.upload(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");
        if (response.isSuccess()) {
            System.out.print("ImageId=" + response.getImageId() + "\n");
            return    response.getImageURL() ;
        } else {
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            return  response.getMessage() ;

        }
//        return "";
    }
}


