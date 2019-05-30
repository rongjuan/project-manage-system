package cc.xuepeng.controller;

import cc.xuepeng.entity.User;
import cc.xuepeng.service.user.UserService;
import cc.xuepeng.vo.UserQueryVO;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
     * @param headers HttpHeader对象。
     * @return 用户信息。
     */
    @GetMapping("/v1/user/info")
    HttpResult findByToken(@RequestHeader HttpHeaders headers) {
        final User result = userService.findUserByToken(headers.getFirst("X-Access-Token"));
        return DefaultHttpResultFactory.success("根据主键查询用户成功。", result);
    }

    /**
     * @return 查询用户信息。
     */
    @PostMapping("/v1/user")
    HttpResult findUsers(@RequestBody final UserQueryVO userQueryVO, HttpServletRequest request) {
        userQueryVO.setLicenseId(request.getAttribute("license").toString());
        PageResult<User> result = userService.findByConditionAndPage(
                BeanUtil.objToObj(userQueryVO, User.class),
                userQueryVO.getPage());
        return DefaultHttpResultFactory.success("查询用户成功。", result);
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
