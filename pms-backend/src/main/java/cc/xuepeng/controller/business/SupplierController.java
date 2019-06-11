package cc.xuepeng.controller.business;

import cc.xuepeng.entity.Supplier;
import cc.xuepeng.service.business.SupplierService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/suppliers")
public class SupplierController {

    /**
     * 构造函数。
     *
     * @param supplierService 供应商业务服务接口。
     */
    @Autowired
    SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * 创建供应商。
     *
     * @param supplier 供应商。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/supplier")
    HttpResult create(@RequestBody final Supplier supplier) {
        if(supplierService.create(supplier)) {
            return DefaultHttpResultFactory.success("创建供应商成功。");
        }
        return DefaultHttpResultFactory.fail("创建供应商失败。");
    }

    /**
     * 编辑供应商。
     *
     * @param supplier 供应商。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/supplier")
    HttpResult update(@RequestBody final Supplier supplier) {
        if(supplierService.update(supplier)) {
            return DefaultHttpResultFactory.success("编辑供应商成功。");
        }
        return DefaultHttpResultFactory.fail("编辑供应商失败。");
    }

    /**
     * 根据主键删除供应商。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/supplier/{id}")
    HttpResult delete(@PathVariable(value = "id") final String id) {
        if(supplierService.delete(id)) {
            return DefaultHttpResultFactory.success("删除供应商成功。");
        }
        return DefaultHttpResultFactory.fail("删除供应商失败。");
    }

    /**
     * 根据主键查询供应商。
     *
     * @param id 主键。
     * @return 供应商。
     */
    @GetMapping("/v1/supplier/{id}")
    HttpResult findById(@PathVariable(value = "id") final String id) {
        Supplier result = supplierService.findById(id);
        return DefaultHttpResultFactory.success("根据主键查询供应商成功。", result);
    }

    /**
     * 查询全部供应商，费用没有被逻辑删除。
     *
     * @return 供应商集合。
     */
    @GetMapping("/v1/supplier")
    HttpResult findAll() {
        List<Supplier> result = supplierService.findAll();
        return DefaultHttpResultFactory.success("查询全部供应商成功。", result);
    }

    /**
     * 分页查询供应商。
     *
     * @param pageParam 分页参数。
     * @return 供应商集合。
     */
    @PostMapping("/v1/supplier/page")
    HttpResult findByPage(@RequestBody final PageParam pageParam) {
        PageResult<Supplier> result = supplierService.findByPage(pageParam);
        return DefaultHttpResultFactory.success("分页查询供应商成功。", result);
    }

    /**
     * 根据供应商名称判断类型是否存在。
     * 前提是费用没有被逻辑思删除。
     *
     * @param name 供应商名称。
     * @return 供应商是否存在。
     */
    @GetMapping("/v1/supplier/{name}/exist")
    HttpResult isExistsByName(@PathVariable(value = "name") final String name) {
        boolean result = supplierService.isExistsByName(name);
        return DefaultHttpResultFactory.success("根据供应商名称判断类型是否存在成功。", result);
    }

    /**
     * 供应商业务服务接口。
     */
    private SupplierService supplierService;

}
