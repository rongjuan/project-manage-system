package cc.xuepeng.service.impl;

import cc.xuepeng.dao.UserDao;
import cc.xuepeng.entity.User;
import cc.xuepeng.entity.UserCondition;
import cc.xuepeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户业务服务类。
 *
 * @author xuepeng
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 构造函数。
     *
     * @param userDao 用户持久化服务接口
     */
    @Autowired
    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 根据账号和密码登录系统。
     *
     * @param account  账号。
     * @param password 密码。
     * @return 登录成功后返回用户信息。
     */
    @Override
    public User login(final String account, final String password) {
        UserCondition condition = new UserCondition();
        condition.createCriteria()
                .andAccountEqualTo(account)
                .andPasswordEqualTo(password);
        List<User> users = userDao.selectByCondition(condition);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

    /**
     * 根据主键查询用户信息。
     *
     * @param id 主键。
     * @return 用户信息。
     */
    @Override
    public User findUserById(final String id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部用户，用户没有被逻辑删除。
     *
     * @return 用户集合。
     */
    @Override
    public List<User> findAll() {
        UserCondition condition = new UserCondition();
        condition.createCriteria().andIsDeleteEqualTo(Boolean.FALSE);
        return userDao.selectByCondition(condition);
    }

    /**
     * 用户持久化服务接口。
     */
    private UserDao userDao;

}
