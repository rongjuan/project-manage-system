package cc.xuepeng.enums;

import cn.yesway.framework.common.entity.http.HttpResultStatus;

/**
 * 自定义Http返回值错误码。
 *
 * @author xuepeng
 */
public enum CustomHttpResultStatus implements HttpResultStatus {

    USER_AUTHENTICATION_FAILED(60001, "用户认证失败。");

    /**
     * 构造函数。
     *
     * @param code 状态编码。
     * @param desc 状态描述。
     */
    CustomHttpResultStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @return 获得状态编码。
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * @return 获得状态描述。
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 状态编码。
     */
    private final int code;
    /**
     * 状态描述。
     */
    private final String desc;

}
