package cc.xuepeng.service.menu;

import cc.xuepeng.dao.MenuDao;
import cc.xuepeng.entity.Menu;
import cc.xuepeng.entity.MenuCondition;
import cc.xuepeng.exception.CannotDeleteMenuException;
import cc.xuepeng.service.menu.formatter.MenuLevelFormatter;
import cn.yesway.framework.common.util.PKUtil;
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
     * 查找全部菜单。
     *
     * @return 菜单信息。
     */
    @Override
    public List<Menu> findAll() {
        MenuCondition condition = new MenuCondition();
        condition.createCriteria().andDeletedEqualTo(Boolean.FALSE);
        condition.setOrderBy("sort asc");
        List<Menu> menus = menuDao.selectByCondition(condition);
        return menuLevelFormatter.format(menus);
    }

    /**
     * 根据主键查询菜单。
     *
     * @param id 主键。
     * @return 菜单信息。
     */
    @Override
    public Menu findById(final String id) {
        return menuDao.selectByPrimaryKey(id);
    }

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
     * 创建菜单。
     *
     * @param menu 菜单信息。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Menu menu) {
        menu.setId(PKUtil.getRandomUUID());
        menu.setDeleted(Boolean.FALSE);
        return menuDao.insertSelective(menu) > 0;
    }

    /**
     * 修改菜单。
     *
     * @param menu 菜单信息。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final Menu menu) {
        return menuDao.updateByPrimaryKeySelective(menu) > 0;
    }

    /**
     * 删除菜单。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        if (hasChildren(id)) {
            throw new CannotDeleteMenuException("该菜单下存在子菜单，不能删除。");
        }
        Menu menu = new Menu();
        menu.setId(id);
        menu.setDeleted(Boolean.TRUE);
        return menuDao.updateByPrimaryKeySelective(menu) > 0;
    }

    /**
     * 判断是否有子菜单。
     *
     * @param id 主键。
     * @return 是否有子菜单。
     */
    private boolean hasChildren(final String id) {
        MenuCondition condition = new MenuCondition();
        condition.createCriteria()
                .andPidEqualTo(id)
                .andDeletedEqualTo(Boolean.FALSE);
        return menuDao.countByCondition(condition) > 0;
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
     * 设置菜单层级格式化接口。
     *
     * @param menuLevelFormatter 菜单层级格式化接口。
     */
    @Autowired
    public void setMenuLevelFormatter(MenuLevelFormatter menuLevelFormatter) {
        this.menuLevelFormatter = menuLevelFormatter;
    }

    /**
     * 菜单持久化接口。
     */
    private MenuDao menuDao;
    /**
     * 菜单层级格式化接口。
     */
    private MenuLevelFormatter menuLevelFormatter;

}
