package xyz.ieden.build.resource;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/4/23 11:33
 */
@RestController
@RequestMapping(value = "home")
public class HomeResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeResource.class);

    @GetMapping(value = "")
    public JSONObject getHome() {
        LOGGER.info("Request Get Home.");
        JSONObject obj = new JSONObject();
        obj.put("id", 1);
        obj.put("createTime", new Date());
        return obj;
    }

}
