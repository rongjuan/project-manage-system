package cc.xuepeng.service.role;

import cc.xuepeng.entity.Role;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 角色管理服务接口。
 *
 * @author xuepeng
 */
public interface RoleService {

    /**
     * 分页查询角色。
     *
     * @return 角色信息。
     */
    PageResult<Role> findByConditionAndPage(final Role role, final PageParam pageParam);

    /**
     * 根据主键查询该角色下的用户。
     *
     * @param id 角色主键。
     * @return 用户信息。
     */
    List<String> findUsersIdsById(final String id);

    /**
     * 根据主键查询该角色用户的菜单的主键。
     *
     * @param id 角色主键。
     * @return 菜单信息。
     */
    List<String> findMenuIdsById(final String id);

    /**
     * 根据主键查询该角色用户的菜单的主键。
     *
     * @param ids 角色主键。
     * @return 菜单信息。
     */
    List<String> findMenuIdsByIds(final List<String> ids);

    /**
     * 创建角色。
     *
     * @param role 角色信息。
     * @return 是否创建成功。
     */
    boolean create(final Role role);

    /**
     * 修改角色。
     *
     * @param role 角色信息。
     * @return 是否修改成功。
     */
    boolean update(final Role role);

    /**
     * 删除角色。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 批量删除角色。
     *
     * @param ids 主键。
     * @return 是否删除成功。
     */
    boolean deleteBatch(final List<String> ids);

    /**
     * 保存角色与用户的关系。
     *
     * @param role 角色信息。
     */
    void saveRoleUser(final Role role);

    /**
     * 保存角色与菜单的关系。
     *
     * @param role 角色信息。
     */
    void saveRoleMenu(final Role role);


}
