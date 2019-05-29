package cc.xuepeng.exception;

import cn.yesway.framework.common.exception.BaseException;

/**
 * 用户认证失败异常类。
 *
 * @author xuepeng
 */
public class UserAuthenticationException extends BaseException {

    /**
     * 构造函数。
     */
    public UserAuthenticationException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public UserAuthenticationException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public UserAuthenticationException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public UserAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
