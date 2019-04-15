package cc.xuepeng.service;

import cc.xuepeng.entity.User;

import java.util.List;

/**
 * 用户业务服务接口。
 *
 * @author xuepeng
 */
public interface UserService {

    /**
     * 根据账号和密码登录系统。
     *
     * @param account  账号。
     * @param password 密码。
     * @return 登录成功后返回用户信息。
     */
    User login(final String account, final String password);

    /**
     * 根据主键查询用户信息。
     *
     * @param id 主键。
     * @return 用户信息。
     */
    User findUserById(final String id);

    /**
     * 查询全部用户，用户没有被逻辑删除。
     *
     * @return 用户集合。
     */
    List<User> findAll();
}
