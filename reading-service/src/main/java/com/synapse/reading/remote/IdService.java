package com.synapse.reading.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 全局ID服务
 * Created by wangyifan on 18-4-14.
 */
@FeignClient(name = "${feign.idgen.url}")
//@FeignClient(name = "reid",url =  "${feign.idgen.url}")
public interface IdService {

    @RequestMapping(value = "/{prefix}", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    String gen(@PathVariable("prefix") String prefix);
}
