package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.UserDao;
import cc.xuepeng.entity.User;
import cc.xuepeng.entity.UserCondition;
import org.springframework.stereotype.Repository;

/**
 * User的数据访问类。
 * 由Code Generator动态生成。
 *
 * @author Code Generator
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, UserCondition> implements UserDao {
}
