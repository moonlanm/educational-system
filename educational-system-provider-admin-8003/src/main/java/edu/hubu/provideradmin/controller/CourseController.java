package edu.hubu.provideradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Course;
import edu.hubu.commons.service.admin.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author moonlan
 * date 2021/2/1 下午2:16
 */
@SuppressWarnings(value = "unused")
@RestController
@RequestMapping("/course")
@Api(tags = "课程 api")
public class CourseController {

    private final ICourseService service;

    public CourseController(ICourseService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, dataTypeClass = String.class)
    public CommonResult selectOne(@PathVariable("id") String id) {
        return new CommonResult().setCode(200).setCurrentPage(1).setData(service.selectOneById(id))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为课程ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "courseId") String orderBy) {
        List<Course> list = service.selectAllOrderBy(orderBy);
        return new CommonResult().setCode(200).setCurrentPage(1)
            .setData(list)
            .setMessage("SUCCESS")
            .setTotal(list.size());
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为课程ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "courseId") String orderBy
    ) {
        List<Course> list = service.selectAllPageOrderBy(currentPage, pageSize, orderBy);
        return new CommonResult().setCode(200).setCurrentPage(1)
            .setData(list)
            .setMessage("SUCCESS")
            .setTotal(list.size());
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为课程ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "course", value = "查询课程的条件", required = true, dataTypeClass = edu.hubu.commons.mybatis.model.Course.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "courseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Course course
    ) {
        List<edu.hubu.commons.mybatis.model.Course> list = service.selectLikePageOrderBy(currentPage, pageSize,
            orderBy, course);
        return new CommonResult().setCode(200).setCurrentPage(1)
            .setData(list)
            .setMessage("SUCCESS")
            .setTotal(list.size());
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "course", value = "需要保存的课程", required = true, dataTypeClass = Course.class)
    public CommonResult save(@RequestBody Course course) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(course)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "课程id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "course", value = "需要修改的课程", required = true, dataTypeClass = Course.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody Course course) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(course)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据Id逻辑删除")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, dataTypeClass = String.class)
    public CommonResult logicDeleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.logicalDeleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "根据Id封禁")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, dataTypeClass = String.class)
    public CommonResult forbidById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.forbidById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.deleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
}
