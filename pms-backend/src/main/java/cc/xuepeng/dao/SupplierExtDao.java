package cc.xuepeng.dao;

import cn.yesway.framework.data.mybatis.dao.BaseDao;
import cc.xuepeng.entity.Supplier;
import cc.xuepeng.entity.SupplierCondition;

import java.util.Map;

/**
 * Supplier的扩展数据访问接口。
 * 用于编写自定义的数据访问方法。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public interface SupplierExtDao extends BaseDao<Supplier, SupplierCondition> {

    Map<String, Supplier> findAllToMap();

}
