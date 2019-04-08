package com.synapse.reading.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @Author:zhanyang
 * @DATE: 2018/7/18
 */
public class AESDecodeUtils {


    public static String decryptPre(String encrypDataPre, String ivDataPre,String  sessionKeyPre) throws Exception {
        byte[] encrypData = Base64.decodeBase64(encrypDataPre);
        byte[] ivData = Base64.decodeBase64(ivDataPre);
        byte[] sessionKey = Base64.decodeBase64(sessionKeyPre);
        return decrypt(sessionKey,ivData,encrypData);
    }

    public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串
        return new String(cipher.doFinal(encData),"UTF-8");
    }
}
