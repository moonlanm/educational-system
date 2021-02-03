package edu.hubu.consumerstudent.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.StudentScore;
import edu.hubu.consumerstudent.service.IStudentScoreService;
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
@RequestMapping("/consumer/studentscore")
@Api(tags = "学生成绩api")
public class StudentScoreController {

    private final IStudentScoreService service;

    public StudentScoreController(IStudentScoreService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "学生成绩id", required = true, dataTypeClass = String.class)
    public CommonResult selectOneById(@PathVariable("id") String id) {
        return service.selectOne(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学生成绩ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "studentscoreId") String orderBy) {
        return service.selectAll(orderBy);
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学生成绩ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "studentscoreId") String orderBy
    ) {
        return service.selectAllPage(currentPage, pageSize, orderBy);
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学生成绩ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "studentscore", value = "查询学生成绩的条件", required = true, dataTypeClass =
                    edu.hubu.commons.mybatis.model.StudentScore.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "studentscoreId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.StudentScore studentscore
    ) {
        return service.selectLikePage(currentPage, pageSize, orderBy, studentscore);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "studentscore", value = "需要保存的学生成绩", required = true, dataTypeClass = StudentScore.class)
    public CommonResult save(@RequestBody StudentScore studentscore) {
        return service.save(studentscore);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "学生成绩id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "studentscore", value = "需要修改的学生成绩", required = true, dataTypeClass = StudentScore.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody StudentScore studentscore) {
        return service.update(id, studentscore);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "学生成绩id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }
}
