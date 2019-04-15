package cc.xuepeng.dao;

import cn.yesway.framework.data.mybatis.dao.BaseDao;
import cc.xuepeng.entity.Fee;
import cc.xuepeng.entity.FeeCondition;

import java.util.Map;

/**
 * Fee的扩展数据访问接口。
 * 用于编写自定义的数据访问方法。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public interface FeeExtDao extends BaseDao<Fee, FeeCondition> {

    Map<String, Fee> findAllToMap();

}
