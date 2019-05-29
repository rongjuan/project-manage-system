package cc.xuepeng.service.menu;

import cc.xuepeng.dao.MenuDao;
import cc.xuepeng.entity.Menu;
import cc.xuepeng.entity.MenuCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理服务类。
 *
 * @author xuepeng
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    /**
     * 根据主键查询菜单。
     *
     * @param ids 主键。
     * @return 菜单信息。
     */
    @Override
    public List<Menu> findByIds(final List<String> ids) {
        MenuCondition condition = new MenuCondition();
        condition.createCriteria()
                .andIdIn(ids)
                .andDeletedEqualTo(Boolean.FALSE);
        condition.setOrderBy("sort asc");
        return menuDao.selectByCondition(condition);
    }

    /**
     * 设置菜单持久化接口。
     *
     * @param menuDao 菜单持久化接口。
     */
    @Autowired
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    /**
     * 菜单持久化接口。
     */
    private MenuDao menuDao;

}
