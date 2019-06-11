package cc.xuepeng.controller;

import cc.xuepeng.entity.Menu;
import cc.xuepeng.service.menu.MenuService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/menus")
public class MenuController extends BaseController {

    /**
     * @return 查询全部菜单。
     */
    @GetMapping("/v1/menu")
    HttpResult findAll() {
        return DefaultHttpResultFactory.success("查询菜单成功。", menuService.findAll());
    }

    /**
     * 根据主键查询菜单。
     *
     * @param id 主键。
     * @return 菜单信息。
     */
    @GetMapping("/v1/menu/{id}")
    HttpResult findById(@PathVariable final String id) {
        return DefaultHttpResultFactory.success("查询菜单成功。", menuService.findById(id));
    }

    /**
     * 创建菜单。
     *
     * @param menu    菜单。
     * @param request HttpRequest对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/menu")
    HttpResult create(@RequestBody final Menu menu, final HttpServletRequest request) {
        menu.setCreateUser(getUser(request));
        if (menuService.create(menu)) {
            return DefaultHttpResultFactory.success("创建菜单成功。");
        }
        return DefaultHttpResultFactory.fail("创建菜单失败。");
    }

    /**
     * 修改菜单。
     *
     * @param menu    菜单。
     * @param request HttpRequest对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/menu")
    HttpResult update(@RequestBody final Menu menu, final HttpServletRequest request) {
        menu.setModifyUser(getUser(request));
        if (menuService.update(menu)) {
            return DefaultHttpResultFactory.success("修改菜单成功。");
        }
        return DefaultHttpResultFactory.fail("修改菜单失败。");
    }

    /**
     * 根据主键删除菜单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/menu/{id}")
    HttpResult delete(@PathVariable final String id) {
        if (menuService.delete(id)) {
            return DefaultHttpResultFactory.success("删除菜单成功。");
        }
        return DefaultHttpResultFactory.fail("删除菜单失败。");
    }

    /**
     * 设置菜单管理服务接口。
     *
     * @param menuService 菜单管理服务接口。
     */
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 菜单管理服务接口。
     */
    private MenuService menuService;

}
