package xyz.ieden.api.resource;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.entity.Result;

/**
 * @author ThinkPad
 * @date Created by 2018/4/18 14:29
 * <p>
 * Remote 操作
 */
@RestController
@RequestMapping(value = "remote ")
public class RemoteResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteResource.class);

    @GetMapping(value = "containers")
    public Result<JSONObject> getContainersInfo(@RequestHeader String reqHeaderStr) {
        LOGGER.debug("Request Get Container Info.");
        JSONObject reqHeader = JSONObject.parseObject(reqHeaderStr);

        JSONObject reqParam = new JSONObject();

        return null;
    }
}
