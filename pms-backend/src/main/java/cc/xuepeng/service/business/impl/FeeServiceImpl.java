package cc.xuepeng.service.business.impl;

import cc.xuepeng.dao.FeeDao;
import cc.xuepeng.entity.Fee;
import cc.xuepeng.entity.FeeCondition;
import cc.xuepeng.service.business.FeeService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 费用类型业务服务类。
 *
 * @author xuepeng
 */
@Service("feeService")
public class FeeServiceImpl implements FeeService {

    /**
     * 父级主键默认值。
     */
    private static final String PARENT_ID = "0";

    /**
     * 构造函数。
     *
     * @param feeDao 费用类型持久化服务接口。
     */
    @Autowired
    FeeServiceImpl(FeeDao feeDao) {
        this.feeDao = feeDao;
    }

    /**
     * 创建费用类型。
     *
     * @param fee 费用类型。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Fee fee) {
        fee.setId(PKUtil.getRandomUUID());
        fee.setCreateUser("1");
        fee.setModifyUser("1");
        return feeDao.insertSelective(fee) > 0;
    }

    /**
     * 编辑费用类型。
     *
     * @param fee 费用类型。
     * @return 是否编辑成功。
     */
    @Override
    public boolean update(final Fee fee) {
        fee.setModifyUser("1");
        return feeDao.updateByPrimaryKeySelective(fee) > 0;
    }

    /**
     * 根据主键删除费用类型。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        Fee fee = new Fee();
        fee.setId(id);
        fee.setModifyUser("1");
        fee.setIsDelete(Boolean.TRUE);
        return feeDao.updateByPrimaryKeySelective(fee) > 0;
    }

    /**
     * 根据主键查询费用类型。
     *
     * @param id 主键。
     * @return 费用类型。
     */
    @Override
    public Fee findById(final String id) {
        return feeDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部费用类型，费用没有被逻辑删除。
     *
     * @return 费用类型集合。
     */
    @Override
    public List<Fee> findAll() {
        FeeCondition condition = new FeeCondition();
        condition.createCriteria().andIsDeleteEqualTo(Boolean.FALSE);
        return feeDao.selectByCondition(condition);
    }

    /**
     * 分页查询费用类型。
     *
     * @param pageParam 分页参数。
     * @return 费用类型集合。
     */
    @Override
    public PageResult<Fee> findByPage(final PageParam pageParam) {
        FeeCondition condition = new FeeCondition();
        condition.createCriteria().andIsDeleteEqualTo(Boolean.FALSE);
        return feeDao.selectByConditionAndPage(condition, pageParam);
    }

    /**
     * 根据费用类型名称判断类型是否存在。
     * 前提是费用没有被逻辑思删除。
     *
     * @param name 费用类型名称。
     * @return 费用类型是否存在。
     */
    @Override
    public boolean isExistsByName(final String name) {
        FeeCondition condition = new FeeCondition();
        condition.createCriteria()
                .andIsDeleteEqualTo(Boolean.FALSE)
                .andNameEqualTo(name);
        return feeDao.countByCondition(condition) > 0;
    }

    /**
     * 查询父级费用类型。
     *
     * @return 费用类型集合。
     */
    @Override
    public List<Fee> findParent() {
        FeeCondition condition = new FeeCondition();
        condition.createCriteria()
                .andPidEqualTo(PARENT_ID)
                .andIsDeleteEqualTo(Boolean.FALSE);
        return feeDao.selectByCondition(condition);
    }

    /**
     * 查询子级费用类型。
     *
     * @param id 主键。
     * @return 费用类型集合。
     */
    @Override
    public List<Fee> findChildren(final String id) {
        FeeCondition condition = new FeeCondition();
        condition.createCriteria()
                .andPidEqualTo(id)
                .andIsDeleteEqualTo(Boolean.FALSE);
        return feeDao.selectByCondition(condition);
    }

    /**
     * 费用类型持久化服务接口。
     */
    private FeeDao feeDao;

}
