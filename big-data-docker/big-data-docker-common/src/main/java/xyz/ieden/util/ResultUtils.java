package xyz.ieden.util;

import xyz.ieden.entity.Result;

import java.util.Objects;

/**
 *
 * @author Gavin
 * @date 2018.04.14
 */
public class ResultUtils {

    public static <T> Boolean isSuccess(Result<T> result) {
        String code = result.getCode();
        String msg = result.getMsg();

        Boolean flag = false;
        if (Objects.equals(ResultConstant.RET_SUCCESS_CODE, code) &&Objects.equals(ResultConstant.RET_SUCCESS_MSG, msg)) {
            flag = true;
        }
        return flag;
    }

    public static <T> Result<T> createResult() {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.RET_SUCCESS_CODE);
        result.setMsg(ResultConstant.RET_SUCCESS_MSG);
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setCode(ResultConstant.RET_UNKNOWN_ERROR_CODE);
        result.setMsg(ResultConstant.RET_UNKNOWN_ERROR_MSG);
        return result;
    }

    public static <T> Result<T> error(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
