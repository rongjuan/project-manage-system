package cc.xuepeng.service.role;

import java.util.List;

/**
 * 角色管理服务接口。
 *
 * @author xuepeng
 */
public interface RoleService {

    /**
     * 根据主键查询该角色用户的菜单的主键。
     *
     * @param ids 角色主键。
     * @return 菜单信息。
     */
    List<String> findMenuIdsByIds(List<String> ids);

}
