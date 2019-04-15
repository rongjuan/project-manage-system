package cc.xuepeng.dao;

import cn.yesway.framework.data.mybatis.dao.BaseDao;
import cc.xuepeng.entity.User;
import cc.xuepeng.entity.UserCondition;

import java.util.Map;

/**
 * User的扩展数据访问接口。
 * 用于编写自定义的数据访问方法。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public interface UserExtDao extends BaseDao<User, UserCondition> {

    Map<String, User> findAllToMap();

}
