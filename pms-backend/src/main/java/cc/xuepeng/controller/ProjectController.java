package cc.xuepeng.controller;

import cc.xuepeng.entity.Project;
import cc.xuepeng.service.business.ProjectService;
import cn.yesway.framework.common.entity.http.DefaultHttpResultFactory;
import cn.yesway.framework.common.entity.http.HttpResult;
import cn.yesway.framework.common.entity.page.PageParam;
import cn.yesway.framework.common.entity.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工程项目的控制器。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/pms/v1/projects")
public class ProjectController {

    /**
     * 构造函数。
     *
     * @param projectService 工程项目业务服务接口。
     */
    @Autowired
    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 创建工程项目。
     *
     * @param project 工程项目。
     * @return 是否创建成功。
     */
    @PostMapping("/v1/project")
    HttpResult create(@RequestBody final Project project) {
        if (projectService.create(project)) {
            return DefaultHttpResultFactory.success("创建工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("创建工程项目失败。");
    }

    /**
     * 编辑工程项目。
     *
     * @param project 工程项目。
     * @return 是否编辑成功。
     */
    @PutMapping("/v1/project")
    HttpResult update(@RequestBody final Project project) {
        if (projectService.update(project)) {
            return DefaultHttpResultFactory.success("编辑工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("编辑工程项目失败。");
    }

    /**
     * 启动工程项目。
     *
     * @param id 主键。
     * @return 是否启动成功。
     */
    @PutMapping("/v1/project/{id}/start")
    HttpResult start(@PathVariable(value = "id") final String id) {
        if (projectService.start(id)) {
            return DefaultHttpResultFactory.success("启动工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("启动工程项目失败。");
    }

    /**
     * 暂停工程项目。
     *
     * @param id 主键。
     * @return 是否暂停成功。
     */
    @PutMapping("/v1/project/{id}/pause")
    HttpResult pause(@PathVariable(value = "id") final String id) {
        if (projectService.pause(id)) {
            return DefaultHttpResultFactory.success("暂停工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("暂停工程项目失败。");
    }

    /**
     * 关闭工程项目。
     *
     * @param id 主键。
     * @return 是否关闭成功。
     */
    @PutMapping("/v1/project/{id}/close")
    HttpResult close(@PathVariable(value = "id") final String id) {
        if (projectService.close(id)) {
            return DefaultHttpResultFactory.success("暂停工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("暂停工程项目失败。");
    }

    /**
     * 给项目指派一名项目经理。
     *
     * @param id     主键。
     * @param userId 部门经理主键。
     * @return 是否指派成功。
     */
    @PutMapping("/v1/project/{id}/appoint/{userId}")
    HttpResult appointManager(@PathVariable(value = "id") final String id,
                              @PathVariable(value = "userId") final String userId) {
        if (projectService.appointManager(id, userId)) {
            return DefaultHttpResultFactory.success("指派项目经理成功。");
        }
        return DefaultHttpResultFactory.fail("指派项目经理失败。");
    }

    /**
     * 根据主键删除工程项目。
     *
     * @param id 主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/project/{id}")
    HttpResult delete(@PathVariable(value = "id") final String id) {
        if (projectService.delete(id)) {
            return DefaultHttpResultFactory.success("删除工程项目成功。");
        }
        return DefaultHttpResultFactory.fail("删除工程项目失败。");
    }

    /**
     * 根据主键查询工程项目。
     *
     * @param id 主键。
     * @return 工程项目。
     */
    @GetMapping("/v1/project/{id}")
    HttpResult findById(@PathVariable(value = "id") final String id) {
        Project result = projectService.findById(id);
        return DefaultHttpResultFactory.success("根据主键查询工程项目成功。", result);
    }

    /**
     * 查询全部工程项目，费用没有被逻辑删除。
     *
     * @return 工程项目集合。
     */
    @GetMapping("/v1/project")
    HttpResult findAll() {
        List<Project> result = projectService.findAll();
        return DefaultHttpResultFactory.success("查询全部工程项目成功。", result);
    }

    /**
     * 分页查询工程项目。
     *
     * @param pageParam 分页参数。
     * @return 工程项目集合。
     */
    @PostMapping("/v1/project/page")
    HttpResult findByPage(@RequestBody final PageParam pageParam) {
        PageResult<Project> result = projectService.findByPage(pageParam);
        return DefaultHttpResultFactory.success("分页查询工程项目成功。", result);
    }

    /**
     * 根据工程项目名称判断类型是否存在。
     * 前提是费用没有被逻辑思删除。
     *
     * @param name 工程项目名称。
     * @return 工程项目是否存在。
     */
    @GetMapping("/v1/project/{name}/exist")
    HttpResult isExistsByName(@PathVariable(value = "name") final String name) {
        boolean result = projectService.isExistsByName(name);
        return DefaultHttpResultFactory.success("根据工程项目名称判断类型是否存在成功。", result);
    }

    /**
     * 工程项目业务服务接口。
     */
    private ProjectService projectService;

}
