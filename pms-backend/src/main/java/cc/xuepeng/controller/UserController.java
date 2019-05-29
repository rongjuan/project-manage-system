package cc.xuepeng.controller;

import cc.xuepeng.entity.User;
import cc.xuepeng.service.user.UserService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/users")
public class UserController {

    /**
     * 用户登录。
     *
     * @param user 要登录的用户。
     * @return 登录成功后返回用户信息。
     */
    @PostMapping("/v1/user/login")
    HttpResult login(@RequestBody final User user) {
        final String token = userService.login(user.getAccount(), user.getSecret());
        return DefaultHttpResultFactory.success("登录成功", token);
    }

    /**
     * 根据用户令牌查询用户信息。
     *
     * @param token 用户令牌。
     * @return 用户信息。
     */
    @GetMapping("/v1/user/{token}")
    HttpResult findByToken(@PathVariable(value = "token") final String token) {
        final User result = userService.findUserByToken(token);
        return DefaultHttpResultFactory.success("根据主键查询用户成功。", result);
    }

    /**
     * 设置用户管理服务接口。
     *
     * @param userService 用户管理服务接口。
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户管理服务接口。
     */
    private UserService userService;

}
