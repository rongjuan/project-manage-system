package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.FeeExtDao;
import cc.xuepeng.entity.Fee;
import cc.xuepeng.entity.FeeCondition;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Fee的数据访问类。
 * 用于编写自定义的数据访问方法。
 * 用来编写
 *
 * @author Code Generator
 */
@Repository("feeExtDao")
public class FeeExtDaoImpl extends BaseDaoImpl<Fee, FeeCondition> implements FeeExtDao {

    @Override
    public Map<String, Fee> findAllToMap() {
        return getSessionTemplate().selectMap(getStatement("findAllToMap"), "id");
    }

}
