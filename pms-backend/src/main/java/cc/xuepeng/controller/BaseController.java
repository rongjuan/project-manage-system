package cc.xuepeng.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用的Controller。
 *
 * @author xuepeng
 */
public class BaseController {

    /**
     * 获取许可证。
     *
     * @param request HttpRequest对象。
     * @return 许可证信息。
     */
    protected String getLicense(final HttpServletRequest request) {
        return request.getAttribute("license").toString();
    }

    /**
     * 获取用户信息。
     *
     * @param request HttpRequest对象。
     * @return 用户信息。
     */
    protected String getUser(final HttpServletRequest request) {
        return request.getAttribute("license").toString();
    }

}
