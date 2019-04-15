package cc.xuepeng.dao;

import cn.yesway.framework.data.mybatis.dao.BaseDao;
import cc.xuepeng.entity.Commodity;
import cc.xuepeng.entity.CommodityCondition;

import java.util.Map;

/**
 * Commodity的扩展数据访问接口。
 * 用于编写自定义的数据访问方法。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public interface CommodityExtDao extends BaseDao<Commodity, CommodityCondition> {

    Map<String, Commodity> findAllToMap();

}
