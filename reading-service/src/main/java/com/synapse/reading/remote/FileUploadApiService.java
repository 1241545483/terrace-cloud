package com.synapse.reading.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "${fileupload.url}")
public interface FileUploadApiService {
    @RequestMapping(value = "/upload/SHILU/realUrl", method = RequestMethod.GET)
    public Map<String, String> realUrl(@RequestParam("tmpUrl")String tmpUrl);

}