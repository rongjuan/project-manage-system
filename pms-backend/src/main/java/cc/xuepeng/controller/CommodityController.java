package cc.xuepeng.controller;

import cc.xuepeng.entity.Commodity;
import cc.xuepeng.service.CommodityService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/commodities")
public class CommodityController {

    /**
     * 构造函数。
     *
     * @param commodityService 商品业务服务接口。
     */
    @Autowired
    CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    /**
     * 创建商品。
     *
     * @param commodity 商品。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/commodity")
    HttpResult create(@RequestBody final Commodity commodity) {
        if(commodityService.create(commodity)) {
            return DefaultHttpResultFactory.success("创建商品成功。");
        }
        return DefaultHttpResultFactory.fail("创建商品失败。");
    }

    /**
     * 编辑商品。
     *
     * @param commodity 商品。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/commodity")
    HttpResult update(@RequestBody final Commodity commodity) {
        if(commodityService.update(commodity)) {
            return DefaultHttpResultFactory.success("编辑商品成功。");
        }
        return DefaultHttpResultFactory.fail("编辑商品失败。");
    }

    /**
     * 根据主键删除商品。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/commodity/{id}")
    HttpResult delete(@PathVariable(value = "id") final String id) {
        if(commodityService.delete(id)) {
            return DefaultHttpResultFactory.success("删除商品成功。");
        }
        return DefaultHttpResultFactory.fail("删除商品失败。");
    }

    /**
     * 根据主键查询商品。
     *
     * @param id 主键。
     * @return 商品。
     */
    @GetMapping("/v1/commodity/{id}")
    HttpResult findById(@PathVariable(value = "id") final String id) {
        Commodity result = commodityService.findById(id);
        return DefaultHttpResultFactory.success("根据主键查询商品成功。", result);
    }

    /**
     * 查询全部商品，费用没有被逻辑删除。
     *
     * @return 商品集合。
     */
    @GetMapping("/v1/commodity")
    HttpResult findAll() {
        List<Commodity> result = commodityService.findAll();
        return DefaultHttpResultFactory.success("查询全部商品成功。", result);
    }

    /**
     * 分页查询商品。
     *
     * @param pageParam 分页参数。
     * @return 商品集合。
     */
    @PostMapping("/v1/commodity/page")
    HttpResult findByPage(@RequestBody final PageParam pageParam) {
        PageResult<Commodity> result = commodityService.findByPage(pageParam);
        return DefaultHttpResultFactory.success("分页查询商品成功。", result);
    }

    /**
     * 根据商品名称判断类型是否存在。
     * 前提是费用没有被逻辑思删除。
     *
     * @param name 商品名称。
     * @return 商品是否存在。
     */
    @GetMapping("/v1/commodity/{name}/exist")
    HttpResult isExistsByName(@PathVariable(value = "name") final String name) {
        boolean result = commodityService.isExistsByName(name);
        return DefaultHttpResultFactory.success("根据商品名称判断类型是否存在成功。", result);
    }

    /**
     * 商品业务服务接口。
     */
    private CommodityService commodityService;
    
}
