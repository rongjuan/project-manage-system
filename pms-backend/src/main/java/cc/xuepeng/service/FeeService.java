package cc.xuepeng.service;

import cc.xuepeng.entity.Fee;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 费用类型业务服务接口。
 *
 * @author xuepeng
 */
public interface FeeService {

    /**
     * 创建费用类型。
     *
     * @param fee 费用类型。
     * @return 是否创建成功。
     */
    boolean create(final Fee fee);

    /**
     * 编辑费用类型。
     *
     * @param fee 费用类型。
     * @return 是否编辑成功。
     */
    boolean update(final Fee fee);

    /**
     * 根据主键删除费用类型。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 根据主键查询费用类型。
     *
     * @param id 主键。
     * @return 费用类型。
     */
    Fee findById(final String id);

    /**
     * 查询全部费用类型，费用没有被逻辑删除。
     *
     * @return 费用类型集合。
     */
    List<Fee> findAll();

    /**
     * 分页查询费用类型。
     *
     * @param pageParam 分页参数。
     * @return 费用类型集合。
     */
    PageResult<Fee> findByPage(final PageParam pageParam);

    /**
     * 根据费用类型名称判断类型是否存在。
     * 前提是费用没有被逻辑思删除。
     *
     * @param name 费用类型名称。
     * @return 费用类型是否存在。
     */
    boolean isExistsByName(final String name);

}
