package cc.xuepeng.service.menu;

import cc.xuepeng.entity.Menu;

import java.util.List;

/**
 * 菜单管理服务接口。
 *
 * @author xuepeng
 */
public interface MenuService {

    /**
     * 根据主键查询菜单。
     *
     * @param ids 主键。
     * @return 菜单信息。
     */
    List<Menu> findByIds(final List<String> ids);

}
