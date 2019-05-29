package cc.xuepeng.service.business;

import cc.xuepeng.entity.PurchaseOrder;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 采购订单业务服务接口。
 *
 * @author xuepeng
 */
public interface PurchaseOrderService {

    /**
     * 创建采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否创建成功。
     */
    boolean create(final PurchaseOrder purchaseOrder);

    /**
     * 编辑采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否编辑成功。
     */
    boolean update(final PurchaseOrder purchaseOrder);

    /**
     * 根据主键删除采购订单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 根据主键查询采购订单。
     *
     * @param id 主键。
     * @return 采购订单。
     */
    PurchaseOrder findById(final String id);

    /**
     * 查询全部采购订单，采购订单没有被逻辑删除。
     *
     * @return 采购订单集合。
     */
    List<PurchaseOrder> findAll();

    /**
     * 分页查询采购订单。
     *
     * @param pageParam 分页参数。
     * @return 采购订单集合。
     */
    PageResult<PurchaseOrder> findByPage(final PageParam pageParam);

}
