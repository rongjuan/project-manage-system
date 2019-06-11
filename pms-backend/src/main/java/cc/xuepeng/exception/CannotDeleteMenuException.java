package cc.xuepeng.exception;

import cn.yesway.framework.common.exception.BaseException;

public class CannotDeleteMenuException extends BaseException {

    /**
     * 构造函数。
     */
    public CannotDeleteMenuException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public CannotDeleteMenuException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public CannotDeleteMenuException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public CannotDeleteMenuException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
