package cc.xuepeng.service.user;

import cc.xuepeng.entity.User;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

/**
 * 用户管理服务接口。
 *
 * @author xuepeng
 */
public interface UserService {

    /**
     * 登录。
     *
     * @param account 账号。
     * @param secret  密码。
     * @return 登录成功后返回用户令牌。
     */
    String login(final String account, final String secret);

    /**
     * 根据令牌查询用户信息。
     *
     * @param token 用户令牌。
     * @return 用户信息。
     */
    User findUserByToken(final String token);

    /**
     * 查询用户信息。
     *
     * @param user      查询信息。
     * @param pageParam 分页信息。
     * @return 用户信息。
     */
    PageResult<User> findByConditionAndPage(final User user, final PageParam pageParam);

}
