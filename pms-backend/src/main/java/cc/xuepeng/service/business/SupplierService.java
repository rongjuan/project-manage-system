package cc.xuepeng.service.business;

import cc.xuepeng.entity.Supplier;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 供应商业务服务接口。
 *
 * @author xuepeng
 */
public interface SupplierService {

    /**
     * 创建供应商。
     *
     * @param supplier 供应商。
     * @return 是否创建成功。
     */
    boolean create(final Supplier supplier);

    /**
     * 编辑供应商。
     *
     * @param supplier 供应商。
     * @return 是否编辑成功。
     */
    boolean update(final Supplier supplier);

    /**
     * 根据主键删除供应商。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 根据主键查询供应商。
     *
     * @param id 主键。
     * @return 供应商。
     */
    Supplier findById(final String id);

    /**
     * 查询全部供应商，供应商没有被逻辑删除。
     *
     * @return 供应商集合。
     */
    List<Supplier> findAll();

    /**
     * 分页查询供应商。
     *
     * @param pageParam 分页参数。
     * @return 供应商集合。
     */
    PageResult<Supplier> findByPage(final PageParam pageParam);

    /**
     * 根据供应商名称判断类型是否存在。
     * 前提是供应商没有被逻辑思删除。
     *
     * @param name 供应商名称。
     * @return 供应商是否存在。
     */
    boolean isExistsByName(final String name);

}
