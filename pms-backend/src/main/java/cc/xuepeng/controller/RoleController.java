package cc.xuepeng.controller;

import cc.xuepeng.entity.Role;
import cc.xuepeng.service.role.RoleService;
import cc.xuepeng.vo.RoleQueryVO;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 角色的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/roles")
public class RoleController extends BaseController {

    /**
     * 分页查询角色。
     *
     * @param roleQueryVO 角色查询对象。
     * @param request     HttpRequest对象。
     * @return 角色信息。
     */
    @PostMapping("/v1/role/list")
    public HttpResult findByPage(@RequestBody final RoleQueryVO roleQueryVO, HttpServletRequest request) {
        roleQueryVO.setLicenseId(getLicense(request));
        PageResult<Role> result = roleService.findByConditionAndPage(
                BeanUtil.objToObj(roleQueryVO, Role.class),
                roleQueryVO.getPage()
        );
        return DefaultHttpResultFactory.success("查询角色成功。", result);
    }

    /**
     * 根据主键查询该角色下的用户主键。
     *
     * @param id 角色主键。
     * @return 用户主键。
     */
    @GetMapping("/v1/role/{id}/user")
    public HttpResult findUserIdsById(@PathVariable final String id) {
        return DefaultHttpResultFactory.success("查询角色下的用户成功。", roleService.findUsersIdsById(id));
    }

    /**
     * 根据主键查询该角色下的菜单主键。
     *
     * @param id 角色主键。
     * @return 菜单主键。
     */
    @GetMapping("/v1/role/{id}/menu")
    public HttpResult findMenuIdsById(@PathVariable final String id) {
        return DefaultHttpResultFactory.success("查询角色下的菜单成功。", roleService.findMenuIdsById(id));
    }

    /**
     * 创建角色。
     *
     * @param role    角色信息。
     * @param request HttpRequest对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/role")
    public HttpResult create(@RequestBody final Role role, final HttpServletRequest request) {
        role.setLicenseId(getLicense(request));
        String userId = getUser(request);
        role.setCreateUser(userId);
        role.setModifyUser(userId);
        if (roleService.create(role)) {
            return DefaultHttpResultFactory.success("创建角色成功。");
        }
        return DefaultHttpResultFactory.fail("创建角色失败");
    }

    /**
     * 修改角色。
     *
     * @param role    角色信息。
     * @param request HttpRequest对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/role")
    public HttpResult update(@RequestBody final Role role, final HttpServletRequest request) {
        role.setModifyUser(getUser(request));
        if (roleService.update(role)) {
            return DefaultHttpResultFactory.success("修改角色成功。");
        }
        return DefaultHttpResultFactory.fail("修改角色失败");
    }

    /**
     * 删除角色。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/role/{id}")
    public HttpResult delete(@PathVariable final String id) {
        if (roleService.delete(id)) {
            return DefaultHttpResultFactory.success("删除角色成功。");
        }
        return DefaultHttpResultFactory.fail("删除角色失败");
    }

    /**
     * 批量删除角色。
     *
     * @param ids 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/role/batch")
    public HttpResult deleteBatch(@RequestBody final List<String> ids) {
        if (roleService.deleteBatch(ids)) {
            return DefaultHttpResultFactory.success("删除角色成功。");
        }
        return DefaultHttpResultFactory.fail("删除角色失败");
    }

    /**
     * 设置角色与人员的关系。
     *
     * @param role 角色信息。
     * @return 是否设置成功。
     */
    @PutMapping("/v1/role/user")
    public HttpResult saveRoleUser(@RequestBody final Role role) {
        roleService.saveRoleUser(role);
        return DefaultHttpResultFactory.success("设置角色与人员的关系成功。");
    }

    /**
     * 设置角色与菜单的关系。
     *
     * @param role 角色信息。
     * @return 是否设置成功。
     */
    @PutMapping("/v1/role/menu")
    public HttpResult saveRoleMenu(@RequestBody final Role role) {
        roleService.saveRoleMenu(role);
        return DefaultHttpResultFactory.success("设置角色与菜单的关系成功。");
    }

    /**
     * 设置角色管理服务接口。
     *
     * @param roleService 角色管理服务接口。
     */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 角色管理服务接口。
     */
    private RoleService roleService;

}
