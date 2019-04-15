package cc.xuepeng.service.impl;

import cc.xuepeng.dao.SupplierDao;
import cc.xuepeng.entity.Supplier;
import cc.xuepeng.entity.SupplierCondition;
import cc.xuepeng.service.SupplierService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商业务服务类。
 *
 * @author xuepeng
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    /**
     * 构造函数。
     *
     * @param supplierDao 供应商持久化服务接口。
     */
    @Autowired
    SupplierServiceImpl(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    /**
     * 创建供应商。
     *
     * @param supplier 供应商。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Supplier supplier) {
        supplier.setId(PKUtil.getRandomUUID());
        supplier.setCreateUser("1");
        supplier.setModifyUser("1");
        return supplierDao.insertSelective(supplier) > 0;
    }

    /**
     * 编辑供应商。
     *
     * @param supplier 供应商。
     * @return 是否编辑成功。
     */
    @Override
    public boolean update(final Supplier supplier) {
        supplier.setModifyUser("1");
        return supplierDao.updateByPrimaryKeySelective(supplier) > 0;
    }

    /**
     * 根据主键删除供应商。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setModifyUser("1");
        supplier.setIsDelete(Boolean.TRUE);
        return supplierDao.updateByPrimaryKeySelective(supplier) > 0;
    }

    /**
     * 根据主键查询供应商。
     *
     * @param id 主键。
     * @return 供应商。
     */
    @Override
    public Supplier findById(final String id) {
        return supplierDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部供应商，供应商没有被逻辑删除。
     *
     * @return 供应商集合。
     */
    @Override
    public List<Supplier> findAll() {
        SupplierCondition condition = new SupplierCondition();
        condition.createCriteria().andIsDeleteEqualTo(false);
        return supplierDao.selectByCondition(condition);
    }

    /**
     * 分页查询供应商。
     *
     * @param pageParam 分页参数。
     * @return 供应商集合。
     */
    @Override
    public PageResult<Supplier> findByPage(final PageParam pageParam) {
        SupplierCondition condition = new SupplierCondition();
        condition.createCriteria().andIsDeleteEqualTo(false);
        return supplierDao.selectByConditionAndPage(condition, pageParam);
    }

    /**
     * 根据供应商名称判断类型是否存在。
     * 前提是供应商没有被逻辑思删除。
     *
     * @param name 供应商名称。
     * @return 供应商是否存在。
     */
    @Override
    public boolean isExistsByName(final String name) {
        SupplierCondition condition = new SupplierCondition();
        condition.createCriteria()
                .andIsDeleteEqualTo(false)
                .andNameEqualTo(name);
        return supplierDao.countByCondition(condition) > 0;
    }

    /**
     * 供应商持久化服务接口。
     */
    private SupplierDao supplierDao;

}
