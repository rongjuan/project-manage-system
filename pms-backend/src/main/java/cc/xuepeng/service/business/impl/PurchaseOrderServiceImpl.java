package cc.xuepeng.service.business.impl;

import cc.xuepeng.dao.CommodityExtDao;
import cc.xuepeng.dao.ProjectExtDao;
import cc.xuepeng.dao.PurchaseOrderDao;
import cc.xuepeng.dao.SupplierExtDao;
import cc.xuepeng.entity.*;
import cc.xuepeng.service.business.PurchaseOrderService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 采购订单业务服务类。
 *
 * @author xuepeng
 */
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    /**
     * 构造函数。
     *
     * @param purchaseOrderDao 采购订单持久化服务接口。
     */
    @Autowired
    PurchaseOrderServiceImpl(PurchaseOrderDao purchaseOrderDao,
                             SupplierExtDao supplierExtDao,
                             CommodityExtDao commodityExtDao,
                             ProjectExtDao projectExtDao) {
        this.purchaseOrderDao = purchaseOrderDao;
        this.supplierExtDao = supplierExtDao;
        this.commodityExtDao = commodityExtDao;
        this.projectExtDao = projectExtDao;
    }

    /**
     * 创建采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(PKUtil.getRandomUUID());
        purchaseOrder.setCreateUser("1");
        purchaseOrder.setModifyUser("1");
        return purchaseOrderDao.insertSelective(purchaseOrder) > 0;
    }

    /**
     * 编辑采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否编辑成功。
     */
    @Override
    public boolean update(final PurchaseOrder purchaseOrder) {
        purchaseOrder.setModifyUser("1");
        return purchaseOrderDao.updateByPrimaryKeySelective(purchaseOrder) > 0;
    }

    /**
     * 根据主键删除采购订单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        return purchaseOrderDao.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 根据主键查询采购订单。
     *
     * @param id 主键。
     * @return 采购订单。
     */
    @Override
    public PurchaseOrder findById(final String id) {
        return purchaseOrderDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部采购订单，采购订单没有被逻辑删除。
     *
     * @return 采购订单集合。
     */
    @Override
    public List<PurchaseOrder> findAll() {
        PurchaseOrderCondition condition = new PurchaseOrderCondition();
        return purchaseOrderDao.selectByCondition(condition);
    }

    /**
     * 分页查询采购订单。
     *
     * @param pageParam 分页参数。
     * @return 采购订单集合。
     */
    @Override
    public PageResult<PurchaseOrder> findByPage(final PageParam pageParam) {
        PurchaseOrderCondition condition = new PurchaseOrderCondition();
        PageResult<PurchaseOrder> result = purchaseOrderDao.selectByConditionAndPage(condition, pageParam);
        setRelationInformation(result.getRecord());
        return result;
    }


    private void setRelationInformation(List<PurchaseOrder> orders) {
        Map<String, Supplier> suppliers = supplierExtDao.findAllToMap();
        Map<String, Commodity> commodities = commodityExtDao.findAllToMap();
        Map<String, Project> projects = projectExtDao.findAllToMap();
        orders.forEach(o -> {
            Supplier supplier = suppliers.get(o.getSupplierId());
            Commodity commodity = commodities.get(o.getCommodityId());
            Project project = projects.get(o.getProjectId());
            o.setSupplierName(supplier.getName());
            o.setCommodityName(commodity.getName());
            o.setProjectName(project.getName());
        });
    }

    /**
     * 采购订单持久化服务接口。
     */
    private PurchaseOrderDao purchaseOrderDao;
    /**
     * 经销商持久化服务接口。
     */
    private SupplierExtDao supplierExtDao;
    /**
     * 商品持久化服务接口。
     */
    private CommodityExtDao commodityExtDao;
    /**
     * 项目持久化服务接口。
     */
    private ProjectExtDao projectExtDao;

}
