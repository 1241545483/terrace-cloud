package com.synapse.reading.service;

import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.util.AESDecodeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Random;
@Service
@Transactional
public class WxPayService {

    //生成商户订单号
    public String getRandomOrderId() {
        Random random = new Random(System.currentTimeMillis());
        int value = random.nextInt();
        while (value < 0) {
            value = random.nextInt();
        }
        return value + "";
    }

    //解密encryptedData 获取前台传过来的openid
    public String getOpenid(Map<String, String> param) {
        String openid =null;
        if (param.get("encryptedData") != null) {
            String phoneData = null;
            try {
                phoneData = AESDecodeUtils.decryptPre(param.get("encryptedData"), param.get("iv"), param.get("sessionkey"));
                Map map = JsonUtils.toObject(phoneData, Map.class);
                openid = String.valueOf(map.get("openId"));
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        return  openid;
    }
}
