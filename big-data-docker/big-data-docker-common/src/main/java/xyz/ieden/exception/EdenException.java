package xyz.ieden.exception;


import xyz.ieden.util.ResultConstant;

/**
 * 自定义异常
 *
 * @author ThinkPad
 */
public class EdenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code = ResultConstant.RET_UNKNOWN_ERROR_CODE;
    private String msg = ResultConstant.RET_UNKNOWN_ERROR_MSG;

    public EdenException() {
        new EdenException(this.code, this.msg);
    }

    public EdenException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public EdenException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;

    }

    public EdenException(String code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
