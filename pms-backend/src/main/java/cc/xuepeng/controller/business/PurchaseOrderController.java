package cc.xuepeng.controller.business;

import cc.xuepeng.entity.PurchaseOrder;
import cc.xuepeng.service.business.PurchaseOrderService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 采购订单的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/purchase/orders")
public class PurchaseOrderController {

    /**
     * 构造函数。
     *
     * @param purchaseOrderService 采购订单业务服务接口。
     */
    @Autowired
    PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * 创建采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/order")
    HttpResult create(@RequestBody final PurchaseOrder purchaseOrder) {
        if(purchaseOrderService.create(purchaseOrder)) {
            return DefaultHttpResultFactory.success("创建采购订单成功。");
        }
        return DefaultHttpResultFactory.fail("创建采购订单失败。");
    }

    /**
     * 编辑采购订单。
     *
     * @param purchaseOrder 采购订单。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/order")
    HttpResult update(@RequestBody final PurchaseOrder purchaseOrder) {
        if(purchaseOrderService.update(purchaseOrder)) {
            return DefaultHttpResultFactory.success("编辑采购订单成功。");
        }
        return DefaultHttpResultFactory.fail("编辑采购订单失败。");
    }

    /**
     * 根据主键删除采购订单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/order/{id}")
    HttpResult delete(@PathVariable(value = "id") final String id) {
        if(purchaseOrderService.delete(id)) {
            return DefaultHttpResultFactory.success("删除采购订单成功。");
        }
        return DefaultHttpResultFactory.fail("删除采购订单失败。");
    }

    /**
     * 根据主键查询采购订单。
     *
     * @param id 主键。
     * @return 采购订单。
     */
    @GetMapping("/v1/order/{id}")
    HttpResult findById(@PathVariable(value = "id") final String id) {
        PurchaseOrder result = purchaseOrderService.findById(id);
        return DefaultHttpResultFactory.success("根据主键查询采购订单成功。", result);
    }

    /**
     * 查询全部采购订单，费用没有被逻辑删除。
     *
     * @return 采购订单集合。
     */
    @GetMapping("/v1/order")
    HttpResult findAll() {
        List<PurchaseOrder> result = purchaseOrderService.findAll();
        return DefaultHttpResultFactory.success("查询全部采购订单成功。", result);
    }

    /**
     * 分页查询采购订单。
     *
     * @param pageParam 分页参数。
     * @return 采购订单集合。
     */
    @PostMapping("/v1/order/page")
    HttpResult findByPage(@RequestBody final PageParam pageParam) {
        PageResult<PurchaseOrder> result = purchaseOrderService.findByPage(pageParam);
        return DefaultHttpResultFactory.success("分页查询采购订单成功。", result);
    }

    /**
     * 采购订单业务服务接口。
     */
    private PurchaseOrderService purchaseOrderService;
    
}
