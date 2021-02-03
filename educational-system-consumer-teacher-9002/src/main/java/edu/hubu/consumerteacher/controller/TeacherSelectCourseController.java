package edu.hubu.consumerteacher.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.teacher.TeacherSelectCourse;
import edu.hubu.consumerteacher.service.ITeacherSelectCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午5:01
 */
@SuppressWarnings(value = "unused")
@RestController
@RequestMapping("/consumer/teacherSelectCourse")
@Api(tags = "老师选课api")
public class TeacherSelectCourseController {

    private final ITeacherSelectCourseService service;

    public TeacherSelectCourseController(ITeacherSelectCourseService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "老师选课id", required = true, dataTypeClass = String.class)
    public CommonResult selectOneById(@PathVariable("id") String id) {
        return service.selectOne(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为老师选课ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "teacherSelectCourseId") String orderBy) {
        return service.selectAll(orderBy);
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为老师选课ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "teacherSelectCourseId") String orderBy
    ) {
        return service.selectAllPage(currentPage, pageSize, orderBy);
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为老师选课ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "teacherSelectCourse", value = "查询老师选课的条件", required = true, dataTypeClass =
                    edu.hubu.commons.mybatis.model.TeacherSelectCourse.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "teacherSelectCourseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.TeacherSelectCourse teacherSelectCourse
    ) {
        return service.selectLikePage(currentPage, pageSize, orderBy, teacherSelectCourse);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "teacherSelectCourse", value = "需要保存的老师选课", required = true, dataTypeClass = TeacherSelectCourse.class)
    public CommonResult save(@RequestBody TeacherSelectCourse teacherSelectCourse) {
        return service.save(teacherSelectCourse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "老师选课id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "teacherSelectCourse", value = "需要修改的老师选课", required = true, dataTypeClass = TeacherSelectCourse.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody TeacherSelectCourse teacherSelectCourse) {
        return service.update(id, teacherSelectCourse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据Id逻辑删除")
    @ApiImplicitParam(name = "id", value = "老师选课id", required = true, dataTypeClass = String.class)
    public CommonResult logicDeleteById(@PathVariable("id") String id) {
        return service.logicDeleteById(id);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "根据Id封禁")
    @ApiImplicitParam(name = "id", value = "老师选课id", required = true, dataTypeClass = String.class)
    public CommonResult forbidById(@PathVariable("id") String id) {
        return service.forbidById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "老师选课id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }
}
