package cc.xuepeng.service.business.impl;

import cc.xuepeng.dao.ProjectDao;
import cc.xuepeng.dao.UserExtDao;
import cc.xuepeng.entity.Project;
import cc.xuepeng.entity.ProjectCondition;
import cc.xuepeng.entity.User;
import cc.xuepeng.enums.ProjectStatus;
import cc.xuepeng.service.business.ProjectService;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import cn.yesway.framework.common.util.PKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 工程项目业务服务类。
 *
 * @author xuepeng
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    /**
     * 构造函数。
     *
     * @param projectDao 供工程项目久化服务接口。
     * @param userExtDao 用户持久化服务接口。
     */
    @Autowired
    ProjectServiceImpl(ProjectDao projectDao, UserExtDao userExtDao) {
        this.projectDao = projectDao;
        this.userExtDao = userExtDao;
    }

    /**
     * 创建工程项目。
     *
     * @param project 工程项目。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final Project project) {
        project.setId(PKUtil.getRandomUUID());
        project.setCreateUser("1");
        project.setModifyUser("1");
        project.setStatus(ProjectStatus.INIT.ordinal());
        return projectDao.insertSelective(project) > 0;
    }

    /**
     * 编辑工程项目。
     *
     * @param project 工程项目。
     * @return 是否编辑成功。
     */
    @Override
    public boolean update(final Project project) {
        project.setModifyUser("1");
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 根据主键启动项目。
     *
     * @param id 主键。
     * @return 是否启动成功。
     */
    @Override
    public boolean start(final String id) {
        Project project = new Project();
        project.setId(id);
        project.setModifyUser("1");
        project.setStatus(ProjectStatus.START.ordinal());
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 根据主键暂停项目。
     *
     * @param id 主键。
     * @return 是否暂停成功。
     */
    @Override
    public boolean pause(final String id) {
        Project project = new Project();
        project.setId(id);
        project.setModifyUser("1");
        project.setStatus(ProjectStatus.PAUSE.ordinal());
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 根据主键关闭项目。
     *
     * @param id 主键。
     * @return 是否关闭成功。
     */
    @Override
    public boolean close(final String id) {
        Project project = new Project();
        project.setId(id);
        project.setModifyUser("1");
        project.setStatus(ProjectStatus.CLOSE.ordinal());
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 给项目指派一名项目经理。
     *
     * @param id     主键。
     * @param userId 部门经理主键。
     * @return 是否指派成功。
     */
    @Override
    public boolean appointManager(final String id, final String userId) {
        Project project = new Project();
        project.setId(id);
        project.setUserId(userId);
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 根据主键删除工程项目。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final String id) {
        Project project = new Project();
        project.setId(id);
        project.setModifyUser("1");
        project.setIsDelete(Boolean.TRUE);
        return projectDao.updateByPrimaryKeySelective(project) > 0;
    }

    /**
     * 根据主键查询工程项目。
     *
     * @param id 主键。
     * @return 工程项目。
     */
    @Override
    public Project findById(final String id) {
        return projectDao.selectByPrimaryKey(id);
    }

    /**
     * 查询全部工程项目，工程项目没有被逻辑删除。
     *
     * @return 工程项目集合。
     */
    @Override
    public List<Project> findAll() {
        ProjectCondition condition = new ProjectCondition();
        condition.createCriteria().andIsDeleteEqualTo(Boolean.FALSE);
        List<Project> result = projectDao.selectByCondition(condition);
        setUser(result);
        return result;
    }

    /**
     * 分页查询工程项目。
     *
     * @param pageParam 分页参数。
     * @return 工程项目集合。
     */
    @Override
    public PageResult<Project> findByPage(final PageParam pageParam) {
        ProjectCondition condition = new ProjectCondition();
        condition.createCriteria().andIsDeleteEqualTo(Boolean.FALSE);
        PageResult<Project> result = projectDao.selectByConditionAndPage(condition, pageParam);
        setUser(result.getRecord());
        return result;
    }

    /**
     * 根据工程项目名称判断类型是否存在。
     * 前提是工程项目没有被逻辑思删除。
     *
     * @param name 工程项目名称。
     * @return 工程项目是否存在。
     */
    @Override
    public boolean isExistsByName(final String name) {
        ProjectCondition condition = new ProjectCondition();
        condition.createCriteria()
                .andIsDeleteEqualTo(Boolean.FALSE)
                .andNameEqualTo(name);
        return projectDao.countByCondition(condition) > 0;
    }

    public void setUser(List<Project> projects) {
        Map<String, User> users = userExtDao.findAllToMap();
        projects.forEach(p -> {
            User user = users.get(p.getUserId());
            p.setUserName(user.getName());
        });
    }

    /**
     * 供工程项目久化服务接口。
     */
    private ProjectDao projectDao;
    /**
     * 用户持久化服务接口。
     */
    private UserExtDao userExtDao;

}
