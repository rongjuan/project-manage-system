package cc.xuepeng.interceptor;

import cc.xuepeng.consts.JWTConst;
import cc.xuepeng.enums.CustomHttpResultStatus;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Http安全拦截器。
 *
 * @author xuepeng
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    /**
     * 请求拦截器。
     *
     * @param request  HttpRequest对象。
     * @param response HttpResponse对象。
     * @param handler  处理器。
     * @return 是否通过拦截器。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        return validateHeaderInfo(request, response);
    }

    /**
     * 验证HttpHeader是否正确。
     *
     * @param request  HttpRequest对象。
     * @param response HttpResponse对象。
     * @return 是否正确。
     */
    private boolean validateHeaderInfo(HttpServletRequest request, HttpServletResponse response) {
        final String token = request.getHeader("X-Access-Token");
        final String userId = request.getHeader("X-User-Id");
        if (StringUtils.isBlank(token)
                || StringUtils.isBlank(userId)
                || !JWTUtil.verify(token, JWTConst.SECRET, "id", userId)) {
            HttpResult httpResult = new HttpResult.Builder<String>(CustomHttpResultStatus.USER_IDENTITY_ILLEGAL)
                    .msg(CustomHttpResultStatus.USER_IDENTITY_ILLEGAL.getDesc())
                    .data(CustomHttpResultStatus.USER_IDENTITY_ILLEGAL.getDesc())
                    .build();
            print(response, httpResult);
            return false;
        }
        // 从HttpHeader中获取License，放到Request中
        // TODO 后续修改成放到body中
        request.setAttribute("license", JWTUtil.get(token, JWTConst.SECRET, "license"));
        request.setAttribute("user", JWTUtil.get(token, JWTConst.SECRET, "id"));
        return true;
    }

    /**
     * 向客户端输出。
     *
     * @param response   HttpResponse对象。
     * @param httpResult HttpResult对象。
     */
    private void print(HttpServletResponse response, HttpResult httpResult) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("text/html;charset=utf-8");
        try {
            log.error(httpResult.getDesc());
            response.getWriter().append(objectMapper.writeValueAsString(httpResult));
            response.flushBuffer();
        } catch (IOException e) {
            log.error("拦截器异常：", e);
        }
    }

}
