package cc.xuepeng.dao.impl;

import cn.yesway.framework.data.mybatis.dao.impl.BaseDaoImpl;
import cc.xuepeng.dao.ProjectExtDao;
import cc.xuepeng.entity.Project;
import cc.xuepeng.entity.ProjectCondition;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Project的数据访问类。
 * 用于编写自定义的数据访问方法。
 * 用来编写
 *
 * @author Code Generator
 */
@Repository("projectExtDao")
public class ProjectExtDaoImpl extends BaseDaoImpl<Project, ProjectCondition> implements ProjectExtDao {

    @Override
    public Map<String, Project> findAllToMap() {
        return getSessionTemplate().selectMap(getStatement("findAllToMap"), "id");
    }

}
