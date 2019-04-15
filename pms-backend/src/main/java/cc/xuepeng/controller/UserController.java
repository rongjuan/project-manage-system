package cc.xuepeng.controller;

import cc.xuepeng.entity.User;
import cc.xuepeng.service.UserService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/users")
public class UserController {

    /**
     * 构造函数。
     *
     * @param userService 用户业务服务接口。
     */
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录。
     *
     * @param user 要登录的用户。
     * @return 登录成功后返回用户信息。
     */
    @PostMapping("/v1/user/login")
    HttpResult login(@RequestBody final User user) {
        User result = userService.login(user.getAccount(), user.getPassword());
        if (result == null) {
            return DefaultHttpResultFactory.fail("登录失败，用户名或密码不正确。");
        }
        return DefaultHttpResultFactory.success("登录成功", result);
    }

    /**
     * 根据主键查询用户信息。
     *
     * @param id 主键。
     * @return 用户信息。
     */
    @GetMapping("/v1/user/{id}")
    HttpResult findById(@PathVariable(value = "id") final String id) {
        User result = userService.findUserById(id);
        return DefaultHttpResultFactory.success("根据主键查询用户成功。", result);
    }

    /**
     * 查询全部用户，用户没有被逻辑删除。
     *
     * @return 用户集合。
     */
    @GetMapping("/v1/user")
    HttpResult findAll() {
        List<User> users = userService.findAll();
        return DefaultHttpResultFactory.success("查询全部用户成功。", users);
    }

    /**
     * 用户业务服务接口。
     */
    private UserService userService;

}
