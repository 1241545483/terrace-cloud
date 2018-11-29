package com.synapse.reading.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "WX",url = "https://api.weixin.qq.com")
public interface MiniQrcodeAPiService {
    /**
     * 获取access_token
     * @param grant_type
     * @param appid
     * @param secret
     * @return
     */
    @RequestMapping(value = "/cgi-bin/token", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    Map<String,Object> getAccessToken(@RequestParam("grant_type") String grant_type, @RequestParam("appid") String appid, @RequestParam("secret") String secret);


    /**
     * 小程序二维码流
     * @param grant_type
     * @param appid
     * @param secret
     * @return
     */
    @RequestMapping(value = "/wxa/getwxacodeunlimit", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    Map<String,Object> getMiniQrcodeStream(@RequestParam("access_token") String access_token, @RequestBody Map<String, Object> param);




}
