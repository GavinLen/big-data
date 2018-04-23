package xyz.ieden.util;

/**
 *
 * @author Gavin
 * @date 2018.04.14
 */
public interface ResultConstant {

    /** RestTemplate ResourceAccessException Code */
    String RET_REST_RESOURCE_ACCESS_EXCEPTION_CODE = "600100";
    /** RestTemplate ResourceAccessException Msg */
    String RET_REST_RESOURCE_ACCESS_EXCEPTION_MSG = "Resource Access Exception";

    /** RestTemplate HttpServerErrorException Code */
    String RET_REST_HTTP_SERVER_ERROR_CODE = "600200";
    /** RestTemplate HttpServerErrorException Msg */
    String RET_REST_HTTP_SERVER_ERROR_MSG = "Server ERROR";

    /** Result-Success Code */
    String RET_SUCCESS_CODE = "000000";
    /** Result-Success Msg */
    String RET_SUCCESS_MSG = "success";
    /** Result-参数错误 Code */
    String RET_PARAM_ERROR_CODE = "100000";
    /** Result-参数错误 Msg */
    String RET_PARAM_ERROR_MSG = "Param Error";
    /** Result-服务异常 Code */
    String RET_SERVICE_EXCEPTION_CODE = "300000";
    /** Result-服务异常 Msg */
    String RET_SERVICE_EXCEPTION_MSG = "Service Exception";
    /** Result-服务错误 Code */
    String RET_SYSTEM_ERROR_CODE = "600000";
    /** Result-服务错误 Msg */
    String RET_SYSTEM_ERROR_MSG = "system Error";
    /** Result-未知错误 Code */
    String RET_UNKNOWN_ERROR_CODE = "900000";
    /** Result-未知错误 Msg */
    String RET_UNKNOWN_ERROR_MSG = "unknown error";
}
