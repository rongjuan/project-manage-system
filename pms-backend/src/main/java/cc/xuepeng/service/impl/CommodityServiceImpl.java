package cc.xuepeng.service.impl;

import cc.xuepeng.dao.CommodityDao;
import cc.xuepeng.dao.FeeExtDao;
import cc.xuepeng.entity.Commodity;
import cc.xuepeng.entity.CommodityCondition;
import cc.xuepeng.entity.Fee;
import cc.xuepeng.service.CommodityService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品业务服务类。
 *
 * @author xuepeng
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    /**
     * 构造函数。
     *
     * @param commodityDao 商品持久化服务接口。
     * @param feeExtDao    费用类型服务接口。
     */
    @Autowired
    CommodityServiceImpl(CommodityDao commodityDao, FeeExtDao feeExtDao) {
        this.commodityDao = commodityDao;
        this.feeExtDao = feeExtDao;
    }

    /**
     * 创建商品。
     *
     * @param commodity 商品。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Commodity commodity) {
        commodity.setId(PKUtil.getRandomUUID());
        commodity.setCreateUser("1");
        commodity.setModifyUser("1");
        return commodityDao.insertSelective(commodity) > 0;
    }

    /**
     * 编辑商品。
     *
     * @param commodity 商品。
     * @return 是否编辑成功。
     */
    @Override
    public boolean update(final Commodity commodity) {
        commodity.setModifyUser("1");
        return commodityDao.updateByPrimaryKeySelective(commodity) > 0;
    }

    /**
     * 根据主键删除商品。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        Commodity commodity = new Commodity();
        commodity.setId(id);
        commodity.setModifyUser("1");
        commodity.setIsDelete(Boolean.TRUE);
        return commodityDao.updateByPrimaryKeySelective(commodity) > 0;
    }

    /**
     * 根据主键查询商品。
     *
     * @param id 主键。
     * @return 商品。
     */
    @Override
    public Commodity findById(final String id) {
        return commodityDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部商品，商品没有被逻辑删除。
     *
     * @return 商品集合。
     */
    @Override
    public List<Commodity> findAll() {
        CommodityCondition condition = new CommodityCondition();
        condition.createCriteria().andIsDeleteEqualTo(false);
        List<Commodity> result = commodityDao.selectByCondition(condition);
        setFeeName(result);
        return result;
    }

    /**
     * 分页查询商品。
     *
     * @param pageParam 分页参数。
     * @return 商品集合。
     */
    @Override
    public PageResult<Commodity> findByPage(final PageParam pageParam) {
        CommodityCondition condition = new CommodityCondition();
        condition.createCriteria().andIsDeleteEqualTo(false);
        PageResult<Commodity> result = commodityDao.selectByConditionAndPage(condition, pageParam);
        setFeeName(result.getRecord());
        return result;
    }

    /**
     * 根据商品名称判断类型是否存在。
     * 前提是商品没有被逻辑思删除。
     *
     * @param name 商品名称。
     * @return 商品是否存在。
     */
    @Override
    public boolean isExistsByName(final String name) {
        CommodityCondition condition = new CommodityCondition();
        condition.createCriteria()
                .andIsDeleteEqualTo(false)
                .andNameEqualTo(name);
        return commodityDao.countByCondition(condition) > 0;
    }

    private void setFeeName(List<Commodity> commodities) {
        // 设置费用类型名称
        Map<String, Fee> fees = feeExtDao.findAllToMap();
        commodities.forEach(c -> {
            Fee fee = fees.get(c.getFeeId());
            c.setFeeName(fee.getName());
        });
    }

    /**
     * 商品持久化服务接口。
     */
    private CommodityDao commodityDao;
    /**
     * 费用类型持久化服务接口。
     */
    private FeeExtDao feeExtDao;
}
