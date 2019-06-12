package cc.xuepeng.service.user;

import cc.xuepeng.entity.User;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

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

    /**
     * 根据许可证查询用户信息。
     *
     * @param license 许可证。
     * @return 用户信息。
     */
    List<User> findByLicense(final String license);

    /**
     * 根据主键查询用户。
     *
     * @param ids 主键。
     * @return 用户信息。
     */
    List<User> findByIds(final List<String> ids);

    /**
     * 创建用户。
     *
     * @param user 用户信息。
     * @return 是否创建成功。
     */
    boolean create(final User user);

    /**
     * 修改用户
     *
     * @param user 用户信息。
     * @return 是否修改成功。
     */
    boolean update(final User user);

    /**
     * 删除用户。
     *
     * @param id 用户主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 删除用户。
     *
     * @param ids 用户主键。
     * @return 是否删除成功。
     */
    boolean deleteBatch(final List<String> ids);

    /**
     * 判断账号是否存在。
     * 存在：True，不存在：False；
     *
     * @param account 账号。
     * @return 是否存在。
     */
    boolean existed(final String account);

    /**
     * 修改密码。
     *
     * @param id        主键。
     * @param oldSecret 旧密码。
     * @param newSecret 新密码。
     * @return 是否更新成功。
     */
    boolean updateSecret(final String id, final String oldSecret, final String newSecret);

}
