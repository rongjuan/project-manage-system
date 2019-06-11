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
     * 查找全部菜单。
     *
     * @return 菜单信息。
     */
    List<Menu> findAll();

    /**
     * 根据主键查询菜单。
     *
     * @param id 主键。
     * @return 菜单信息。
     */
    Menu findById(final String id);

    /**
     * 根据主键查询菜单。
     *
     * @param ids 主键。
     * @return 菜单信息。
     */
    List<Menu> findByIds(final List<String> ids);

    /**
     * 创建菜单。
     *
     * @param menu 菜单信息。
     * @return 是否创建成功。
     */
    boolean create(final Menu menu);

    /**
     * 修改菜单。
     *
     * @param menu 菜单信息。
     * @return 是否修改成功。
     */
    boolean update(final Menu menu);

    /**
     * 删除菜单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

}
