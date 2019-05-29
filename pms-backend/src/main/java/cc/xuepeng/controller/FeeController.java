package cc.xuepeng.controller;

import cc.xuepeng.entity.Fee;
import cc.xuepeng.service.business.FeeService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 费用类型的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/fees")
public class FeeController {

    /**
     * 构造函数。
     *
     * @param feeService 费用类型业务服务接口。
     */
    @Autowired
    FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    /**
     * 创建费用类型。
     *
     * @param fee 费用类型。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/fee")
    public HttpResult create(@RequestBody final Fee fee) {
        if (feeService.create(fee)) {
            return DefaultHttpResultFactory.success("创建费用类型成功。");
        }
        return DefaultHttpResultFactory.fail("创建费用类型失败。");
    }

    /**
     * 编辑费用类型。
     *
     * @param fee 费用类型。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/fee")
    public HttpResult update(@RequestBody final Fee fee) {
        if (feeService.update(fee)) {
            return DefaultHttpResultFactory.success("编辑费用类型成功。");
        }
        return DefaultHttpResultFactory.fail("编辑费用类型失败。");
    }

    /**
     * 根据主键删除费用类型。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/fee/{id}")
    public HttpResult delete(@PathVariable(value = "id") final String id) {
        if (feeService.delete(id)) {
            return DefaultHttpResultFactory.success("删除费用类型成功。");
        }
        return DefaultHttpResultFactory.fail("删除费用类型失败。");
    }

    /**
     * 根据主键查询费用类型。
     *
     * @param id 主键。
     * @return 费用类型。
     */
    @GetMapping("/v1/fee/{id}")
    public HttpResult findById(@PathVariable(value = "id") final String id) {
        Fee result = feeService.findById(id);
        return DefaultHttpResultFactory.success("根据主键查询费用类型成功。", result);
    }

    /**
     * 查询全部费用类型，费用没有被逻辑删除。
     *
     * @return 费用类型集合。
     */
    @GetMapping("/v1/fee")
    public HttpResult findAll() {
        List<Fee> result = feeService.findAll();
        return DefaultHttpResultFactory.success("查询全部费用类型成功。", result);
    }

    /**
     * 分页查询费用类型。
     *
     * @param pageParam 分页参数。
     * @return 费用类型集合。
     */
    @PostMapping("/v1/fee/page")
    public HttpResult findByPage(@RequestBody final PageParam pageParam) {
        PageResult<Fee> result = feeService.findByPage(pageParam);
        return DefaultHttpResultFactory.success("分页查询费用类型成功。", result);
    }

    /**
     * 根据费用类型名称判断类型是否存在。
     * 前提是费用没有被逻辑删除。
     *
     * @param name 费用类型名称。
     * @return 费用类型是否存在。
     */
    @GetMapping("/v1/fee/{name}/exist")
    public HttpResult isExistsByName(@PathVariable(value = "name") final String name) {
        boolean result = feeService.isExistsByName(name);
        return DefaultHttpResultFactory.success("根据费用类型名称判断类型是否存在成功。", result);
    }

    /**
     * 查询所有的顶级费用类型。
     *
     * @return 费用类型集合。
     */
    @GetMapping("/v1/fee/parent")
    public HttpResult findParent() {
        List<Fee> fees = feeService.findParent();
        return DefaultHttpResultFactory.success("查询父级费用类型成功。", fees);
    }

    /**
     * 查询子费用类型。
     *
     * @param id 主键。
     * @return 费用类型集合。
     */
    @GetMapping("/v1/fee/children/{id}")
    public HttpResult findChildren(@PathVariable(value = "id") final String id) {
        List<Fee> fees = feeService.findChildren(id);
        return DefaultHttpResultFactory.success("根据父主键查询费用类型成功。", fees);
    }

    /**
     * 费用类型业务服务接口。
     */
    private FeeService feeService;

}
