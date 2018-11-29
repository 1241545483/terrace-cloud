package com.synapse.reading.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.utils.JsonUtils;

import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.remote.MiniQrcodeAPiService;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zhanyang
 * @DATE: 2018/7/18
 */
@Service
@Transactional
public class MiniQrcodeService {


    @Value("${mini.app.appid}")
    private String appId;

    @Value("${mini.app.secret}")
    private String secret;

    @Autowired
    private MiniQrcodeAPiService miniQrcodeAPiService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Value("${imgUploadUrl}")
    private String imgUploadUrl;//"https://www.jssns.cn/upload/SHILU"


    private static Logger logger = LoggerFactory.getLogger(MiniQrcodeService.class);

    public String getAccessToken() {
//        redisTemplate.delete("mini_access_token");//根据key删除缓存
        String access_token = redisTemplate.boundValueOps("reading_mini_access_token").get();
        if (!StringUtils.isEmpty(access_token)) {
            return access_token;
        }
        Map<String, Object> result = miniQrcodeAPiService.getAccessToken("client_credential", appId, secret);
        if (!CollectionUtils.isEmpty(result) && (Integer) result.get("expires_in") == 7200) {
            access_token = (String) result.get("access_token");
            redisTemplate.opsForValue().set("reading_mini_access_token", access_token, 7200, TimeUnit.SECONDS);
        }
        return access_token;
    }


    public Map<String, Object> generateMiniQrcode(String itemId) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("page", "pages/index/index");
        param.put("scene", itemId);
        param.put("width", 430);
        param.put("auto_color", true);
        param.put("is_hyaline", false);
        String json = JsonUtils.toJson(param);
        String res = httpPostWithJson("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + getAccessToken(), json, itemId);
        Map<String, Object> map = JsonUtils.toObject(res, Map.class);
        return map;
    }

    public Map<String, Object> generate(MiniQrcodeParam params) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("page", params.getPage());
        param.put("scene", params.getScene());
        param.put("width", 430);
        param.put("auto_color", true);
        param.put("is_hyaline", false);
        String json = JsonUtils.toJson(param);
        logger.info(getAccessToken() + "============json = " + json);
        String res = httpPostWithJson("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + getAccessToken(), json, params.getScene());
        Gson gson = new Gson();
        Type memberType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> map = gson.fromJson(res, memberType);
        return map;
    }

    public String httpPostWithJson(String url, String json, String name) throws Exception {
        String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity stringEntity = new StringEntity(json);
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "UTF-8"));
        httpPost.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity httpEntity = response.getEntity();
            if (httpClient != null) {
                InputStream inputStream = httpEntity.getContent();
//                File targetFile = new File("D:\\targetFile.png");
//                FileUtils.copyInputStreamToFile(inputStream, targetFile);
//                return null;
                String filName = System.currentTimeMillis() + "_" + "mini" + ".png";
                result = inputStreamUpload(inputStream, filName);
            }
        }
        return result;
    }

    public void getFile(InputStream is, String fileName) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        in = new BufferedInputStream(is);
        out = new BufferedOutputStream(new FileOutputStream(fileName));
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }
        in.close();
        out.close();
    }


    public String inputStreamUpload(InputStream inputStream, String filName) {
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
                return buffer.toString();
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
