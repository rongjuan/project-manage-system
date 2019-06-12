package cc.xuepeng.config;

import cc.xuepeng.enums.CustomHttpResultStatus;
import cc.xuepeng.exception.CannotDeleteMenuException;
import cc.xuepeng.exception.UserAuthenticationException;
import cc.xuepeng.exception.UserSecretIncorrectException;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理配置。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {

    /**
     * 用户登录失败的异常。
     *
     * @param e ParameterInvalidException
     * @return 参数错误
     */
    @ExceptionHandler(value = UserAuthenticationException.class)
    @ResponseBody
    public HttpResult authenticationExceptionHandler(UserAuthenticationException e) {
        log.error(e.getMessage());
        return new HttpResult.Builder<String>(CustomHttpResultStatus.USER_AUTHENTICATION_FAILED)
                .msg(CustomHttpResultStatus.USER_AUTHENTICATION_FAILED.getDesc())
                .data(e.getMessage())
                .build();
    }

    /**
     * 用户修改密码时旧密码错误的异常。
     *
     * @param e ParameterInvalidException
     * @return 参数错误
     */
    @ExceptionHandler(value = UserSecretIncorrectException.class)
    @ResponseBody
    public HttpResult secretIncorrectExceptionHandler(UserSecretIncorrectException e) {
        log.error(e.getMessage());
        return new HttpResult.Builder<String>(CustomHttpResultStatus.USER_SECRET_INCORRECT)
                .msg(CustomHttpResultStatus.USER_SECRET_INCORRECT.getDesc())
                .data(e.getMessage())
                .build();
    }

    /**
     * 不能删除菜单的异常。
     *
     * @param e ParameterInvalidException
     * @return 参数错误
     */
    @ExceptionHandler(value = CannotDeleteMenuException.class)
    @ResponseBody
    public HttpResult cannotDeleteMenuExceptionHandler(CannotDeleteMenuException e) {
        log.error(e.getMessage());
        return DefaultHttpResultFactory.fail(e.getMessage());
    }

    /**
     * 所有异常都进行捕获。
     *
     * @param e Exception
     * @return 参数错误
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult cannotDeleteMenuExceptionHandler(Exception e) {
        log.error(e.getMessage());
        return DefaultHttpResultFactory.fail(e.getMessage());
    }

}
