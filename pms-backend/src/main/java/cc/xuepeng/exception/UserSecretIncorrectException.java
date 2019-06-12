package cc.xuepeng.exception;

import cn.yesway.framework.common.exception.BaseException;

public class UserSecretIncorrectException extends BaseException {

    /**
     * 构造函数。
     */
    public UserSecretIncorrectException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public UserSecretIncorrectException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public UserSecretIncorrectException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public UserSecretIncorrectException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
