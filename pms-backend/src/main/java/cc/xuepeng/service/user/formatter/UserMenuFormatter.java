package cc.xuepeng.service.user.formatter;

import cc.xuepeng.entity.Menu;

import java.util.List;

/**
 * 用户菜单格式化器。
 *
 * @author xuepeng
 */
public interface UserMenuFormatter {

    /**
     * 格式化用户菜单。
     *
     * @param menus 菜单信息。
     * @return 菜单信息。
     */
    List<Menu> format(List<Menu> menus);

}
