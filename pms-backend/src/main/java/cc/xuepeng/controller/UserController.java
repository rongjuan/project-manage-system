package cc.xuepeng.controller;

import cc.xuepeng.entity.User;
import cc.xuepeng.service.user.UserService;
import cc.xuepeng.vo.UserQueryVO;
import cc.xuepeng.vo.UserSecretVO;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/users")
public class UserController extends BaseController {

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
     * 查询用户信息。
     *
     * @param userQueryVO 查询条件。
     * @param request     HttpRequest对象。
     * @return 用户信息。
     */
    @PostMapping("/v1/user/list")
    HttpResult findByConditionAndPage(@RequestBody final UserQueryVO userQueryVO, HttpServletRequest request) {
        userQueryVO.setLicenseId(request.getAttribute("license").toString());
        PageResult<User> result = userService.findByConditionAndPage(
                BeanUtil.objToObj(userQueryVO, User.class),
                userQueryVO.getPage());
        return DefaultHttpResultFactory.success("查询用户成功。", result);
    }

    /**
     * 查询用户信息。
     *
     * @param request HttpRequest对象。
     * @return 用户信息。
     */
    @GetMapping("/v1/user")
    HttpResult findAll(HttpServletRequest request) {
        return DefaultHttpResultFactory.success("查询用户成功。", userService.findByLicense(getLicense(request)));
    }

    /**
     * 创建用户。
     *
     * @param user    用户信息。
     * @param request HttpRequest对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/user")
    HttpResult create(@RequestBody final User user, final HttpServletRequest request) {
        user.setLicenseId(getLicense(request));
        String userId = getUser(request);
        user.setCreateUser(userId);
        user.setModifyUser(userId);
        if (userService.create(user)) {
            return DefaultHttpResultFactory.success("创建用户成功。");
        }
        return DefaultHttpResultFactory.fail("创建用户失败");
    }

    /**
     * 编辑用户。
     *
     * @param user    用户信息。
     * @param request HttpRequest对象。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/user")
    HttpResult update(@RequestBody final User user, final HttpServletRequest request) {
        user.setModifyUser(getUser(request));
        if (userService.update(user)) {
            return DefaultHttpResultFactory.success("修改用户成功。");
        }
        return DefaultHttpResultFactory.fail("修改用户失败");
    }

    /**
     * 删除用户。
     *
     * @param id 用户主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/user/{id}")
    HttpResult delete(@PathVariable final String id) {
        if (userService.delete(id)) {
            return DefaultHttpResultFactory.success("删除用户成功。");
        }
        return DefaultHttpResultFactory.fail("删除用户失败");
    }

    /**
     * 批量删除用户。
     *
     * @param ids 用户主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/user/batch")
    HttpResult deleteBatch(@RequestBody final List<String> ids) {
        if (userService.deleteBatch(ids)) {
            return DefaultHttpResultFactory.success("删除用户成功。");
        }
        return DefaultHttpResultFactory.fail("删除用户失败");
    }

    /**
     * 判断用户是否存在。
     *
     * @param account 账号。
     * @return 用户是否存在。
     */
    @GetMapping("/v1/user/{account}/existed")
    HttpResult existed(@PathVariable final String account) {
        return DefaultHttpResultFactory.success("查询用户是否存在。", userService.existed(account));
    }

    @PutMapping("/v1/user/secret")
    HttpResult updateSecret(@RequestBody final UserSecretVO userSecretVO, final HttpServletRequest request) {
        if (userService.updateSecret(
                getUser(request),
                userSecretVO.getOldSecret(),
                userSecretVO.getNewSecret()
        )) {
            return DefaultHttpResultFactory.success("修改密码成功。");
        }
        return DefaultHttpResultFactory.fail("修改密码失败。");
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
