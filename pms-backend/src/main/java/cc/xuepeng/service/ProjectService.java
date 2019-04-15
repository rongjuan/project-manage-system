package cc.xuepeng.service;

import cc.xuepeng.entity.Project;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;

import java.util.List;

/**
 * 工程项目业务服务接口。
 *
 * @author xuepeng
 */
public interface ProjectService {

    /**
     * 创建工程项目。
     *
     * @param project 工程项目。
     * @return 是否创建成功。
     */
    boolean create(final Project project);

    /**
     * 编辑工程项目。
     *
     * @param project 工程项目。
     * @return 是否编辑成功。
     */
    boolean update(final Project project);

    /**
     * 根据主键启动项目。
     *
     * @param id 主键。
     * @return 是否启动成功。
     */
    boolean start(final String id);

    /**
     * 根据主键暂停项目。
     *
     * @param id 主键。
     * @return 是否暂停成功。
     */
    boolean pause(final String id);

    /**
     * 给项目指派一名项目经理。
     *
     * @param id     主键。
     * @param userId 部门经理主键。
     * @return 是否指派成功。
     */
    boolean appointManager(final String id, final String userId);

    /**
     * 根据主键关闭项目。
     *
     * @param id 主键。
     * @return 是否关闭成功。
     */
    boolean close(final String id);

    /**
     * 根据主键删除工程项目。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    boolean delete(final String id);

    /**
     * 根据主键查询工程项目。
     *
     * @param id 主键。
     * @return 工程项目。
     */
    Project findById(final String id);

    /**
     * 查询全部工程项目，工程项目没有被逻辑删除。
     *
     * @return 工程项目集合。
     */
    List<Project> findAll();

    /**
     * 分页查询工程项目。
     *
     * @param pageParam 分页参数。
     * @return 工程项目集合。
     */
    PageResult<Project> findByPage(final PageParam pageParam);

    /**
     * 根据工程项目名称判断类型是否存在。
     * 前提是工程项目没有被逻辑思删除。
     *
     * @param name 工程项目名称。
     * @return 工程项目是否存在。
     */
    boolean isExistsByName(final String name);

}
