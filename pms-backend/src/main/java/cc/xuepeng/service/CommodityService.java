package cc.xuepeng.service;

import cc.xuepeng.entity.Commodity;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 商品业务服务接口。
 *
 * @author xuepeng
 */
public interface CommodityService {

    /**
     * 创建商品。
     *
     * @param commodity 商品。
     * @return 是否创建成功。
     */
    boolean create(final Commodity commodity);

    /**
     * 编辑商品。
     *
     * @param commodity 商品。
     * @return 是否编辑成功。
     */
    boolean update(final Commodity commodity);

    /**
     * 根据主键删除商品。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 根据主键查询商品。
     *
     * @param id 主键。
     * @return 商品。
     */
    Commodity findById(final String id);

    /**
     * 查询全部商品，商品没有被逻辑删除。
     *
     * @return 商品集合。
     */
    List<Commodity> findAll();

    /**
     * 分页查询商品。
     *
     * @param pageParam 分页参数。
     * @return 商品集合。
     */
    PageResult<Commodity> findByPage(final PageParam pageParam);

    /**
     * 根据商品名称判断类型是否存在。
     * 前提是商品没有被逻辑思删除。
     *
     * @param name 商品名称。
     * @return 商品是否存在。
     */
    boolean isExistsByName(final String name);

}
