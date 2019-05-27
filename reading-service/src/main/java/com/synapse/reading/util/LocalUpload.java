package com.synapse.reading.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.reading.remote.Upload;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LocalUpload implements Upload {
    @Value("${imgUploadUrl}")
    private String imgUploadUrl;

    @Override
    public String upload(InputStream inputStream, String filName) {
        //创建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求   请求地址请更换为自己的。
        //1)
        HttpPost post = new HttpPost(imgUploadUrl);
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            //第一个参数为 相当于 Form表单提交的file框的name值 第二个参数就是我们要发送的InputStream对象了
            //第三个参数是文件名
            //3)
            builder.addBinaryBody("file", inputStream, ContentType.create("multipart/form-data"), filName);
            //4)构建请求参数 普通表单项
            StringBody stringBody = new StringBody("12", ContentType.MULTIPART_FORM_DATA);
            builder.addPart("id", stringBody);
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            //发送请求
            HttpResponse response = client.execute(post);
            entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                //转换为字节输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
                StringBuffer buffer = new StringBuffer();
                String body = null;
                while ((body = br.readLine()) != null) {
                    buffer.append(body);
                }
                Gson gson = new Gson();
                Type memberType = new TypeToken<Map<String, Object>>() {
                }.getType();
                Map<String, Map<String, List<Map<String, String>>>> map = gson.fromJson(buffer.toString(), memberType);
               String url = map.get("bizInfo").get("models").get(0).get("url");
                return url;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
