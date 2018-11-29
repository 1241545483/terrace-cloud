package com.synapse.reading.remote;

import com.synapse.common.trans.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:zhanyang
 * @DATE: 2018/4/4
 */
@FeignClient(name = "${feign.link.url}")
public interface ShortLinkApiService {

    @RequestMapping(value = "/api/link/v1/short", method = RequestMethod.POST
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8" )
    Result getCodeByUrl(@RequestBody String url);

    @RequestMapping(value = "/api/link/v1/real", method = RequestMethod.GET
            ,  consumes = "application/json;charset=UTF-8" )
    Result getUrlByCode(@RequestParam("code") String code);
}
