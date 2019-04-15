package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.SupplierExtDao;
import cc.xuepeng.entity.Supplier;
import cc.xuepeng.entity.SupplierCondition;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Supplier的数据访问类。
 * 用于编写自定义的数据访问方法。
 * 用来编写
 *
 * @author Code Generator
 */
@Repository("supplierExtDao")
public class SupplierExtDaoImpl extends BaseDaoImpl<Supplier, SupplierCondition> implements SupplierExtDao {

    @Override
    public Map<String, Supplier> findAllToMap() {
        return getSessionTemplate().selectMap(getStatement("findAllToMap"), "id");
    }

}
