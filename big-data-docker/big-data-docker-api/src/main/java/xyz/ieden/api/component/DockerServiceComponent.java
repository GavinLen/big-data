package xyz.ieden.api.component;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import xyz.ieden.entity.EdenRequest;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;
import xyz.ieden.util.ResultConstant;
import xyz.ieden.util.ResultUtils;

/**
 * @author ThinkPad
 * @date Created by 2018/4/18 13:43
 */
@Component
public class DockerServiceComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerServiceComponent.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 请求 Docker 服务
     *
     * @param reqJson
     * @param request
     * @return
     */
    public Result<JSONObject> reqDockerService(JSONObject reqJson, EdenRequest request) {
        LOGGER.info("Request Docker Service Param:{}", reqJson);
        Result<JSONObject> result = ResultUtils.createResult();

        try {
            JSONObject body = reqJson.getJSONObject("reqData");
            String reqPath = reqJson.getString("reqPath");
            HttpMethod method = (HttpMethod) reqJson.get("reqMethod");

            HttpHeaders httpHeaders = request.getHeaders();
            httpHeaders = httpHeaders == null ? new HttpHeaders() : httpHeaders;
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

            // 4. Request
            HttpEntity<JSONObject> requestEntity = new HttpEntity<>(body, httpHeaders);
            LOGGER.debug("Request Entity-Body:[{}]", requestEntity.getBody());
            LOGGER.debug("Request Entity-Headers:[{}]", requestEntity.getHeaders());
            String reqUrl = reqPath;

            LOGGER.info("Send Request: >>>>>>>>>>");
            ResponseEntity<JSONObject> resEntity = restTemplate.exchange(reqUrl, method, requestEntity, JSONObject.class);
            LOGGER.info("<<<<<<<<<<:Request End");

            // 5. analysis Response

            JSONObject resBody = resEntity.getBody();

            // 分析请求结果
            LOGGER.info("Response Result: Status [{}], Msg [{}]", resBody.getString("Status"), resBody.getString("Msg"));

            LOGGER.debug("Response Body:[{}]", resBody.toString());
            result.setData(resBody);

            return result;
        } catch (EdenException e) {
            LOGGER.error("Meg:", e.getMsg());
            e.printStackTrace();
            throw e;
        } catch (ResourceAccessException e) {
            e.printStackTrace();
            LOGGER.error("Meg:", e.getMessage());
            throw new EdenException(ResultConstant.RET_REST_RESOURCE_ACCESS_EXCEPTION_CODE, ResultConstant.RET_REST_RESOURCE_ACCESS_EXCEPTION_MSG);
        } catch (HttpServerErrorException e) {
            int statusCode = e.getStatusCode().value();
            String msg = e.getStatusText();
            LOGGER.error("Code: [{}], Meg:[{}]", statusCode, msg);
            throw new EdenException(ResultConstant.RET_REST_HTTP_SERVER_ERROR_CODE, msg);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Meg:", e.getMessage());
            throw new EdenException(e.getMessage(), e);
        }
    }

}
