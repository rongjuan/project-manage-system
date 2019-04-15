package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.CommodityExtDao;
import cc.xuepeng.entity.Commodity;
import cc.xuepeng.entity.CommodityCondition;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Commodity的数据访问类。
 * 用于编写自定义的数据访问方法。
 * 用来编写
 *
 * @author Code Generator
 */
@Repository("commodityExtDao")
public class CommodityExtDaoImpl extends BaseDaoImpl<Commodity, CommodityCondition> implements CommodityExtDao {

    @Override
    public Map<String, Commodity> findAllToMap() {
        return getSessionTemplate().selectMap(getStatement("findAllToMap"), "id");
    }

}
