package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.UserExtDao;
import cc.xuepeng.entity.User;
import cc.xuepeng.entity.UserCondition;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * User的数据访问类。
 * 用于编写自定义的数据访问方法。
 * 用来编写
 *
 * @author Code Generator
 */
@Repository("userExtDao")
public class UserExtDaoImpl extends BaseDaoImpl<User, UserCondition> implements UserExtDao {

    @Override
    public Map<String, User> findAllToMap() {
        return getSessionTemplate().selectMap(getStatement("findAllToMap"), "id");
    }

}
