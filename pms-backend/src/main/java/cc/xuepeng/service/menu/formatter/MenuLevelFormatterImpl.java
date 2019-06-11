package cc.xuepeng.service.menu.formatter;

import cc.xuepeng.entity.Menu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("menuLevelFormatter")
public class MenuLevelFormatterImpl implements MenuLevelFormatter {

    /**
     * 格式化用户菜单。
     *
     * @param menus 菜单信息。
     * @return 菜单信息。
     */
    @Override
    public List<Menu> format(final List<Menu> menus) {
        List<Menu> roots = menus.stream()
                .filter(menu -> StringUtils.equals(menu.getPid(), "0"))
                .collect(Collectors.toList());
        roots.forEach(root -> createMenuTree(root, menus));
        return roots;
    }

    /**
     * 递归创建菜单层级。
     *
     * @param parent 父菜单。
     * @param nodes  菜单信息。
     */
    private void createMenuTree(final Menu parent, final List<Menu> nodes) {
        nodes.stream()
                .filter(node -> StringUtils.equals(node.getPid(), parent.getId()))
                .forEach(node -> {
                    parent.getChildren().add(node);
                    createMenuTree(node, nodes);
                });
    }

}
