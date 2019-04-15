package cc.xuepeng.dao;

import cn.yesway.framework.data.mybatis.dao.BaseDao;
import cc.xuepeng.entity.Project;
import cc.xuepeng.entity.ProjectCondition;

import java.util.Map;

/**
 * Project的扩展数据访问接口。
 * 用于编写自定义的数据访问方法。
 * 由Code Generator生成。
 *
 * @author Code Generator
 */
public interface ProjectExtDao extends BaseDao<Project, ProjectCondition> {

    Map<String, Project> findAllToMap();

}
