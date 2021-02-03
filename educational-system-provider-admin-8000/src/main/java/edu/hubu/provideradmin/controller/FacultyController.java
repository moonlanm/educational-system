package edu.hubu.provideradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Faculty;
import edu.hubu.commons.service.admin.IFacultyService;
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
@RequestMapping("/faculty")
@Api(tags = "学院 api")
public class FacultyController {

    private final IFacultyService service;

    public FacultyController(IFacultyService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "学院id", required = true, dataTypeClass = String.class)
    public CommonResult selectOne(@PathVariable("id") String id) {
        return new CommonResult().setCode(200).setCurrentPage(1).setData(service.selectOneById(id))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学院ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "facultyId") String orderBy) {
        List<Faculty> list = service.selectAllOrderBy(orderBy);
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
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学院ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "facultyId") String orderBy
    ) {
        List<Faculty> list = service.selectAllPageOrderBy(currentPage, pageSize, orderBy);
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
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为学院ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "faculty", value = "查询学院的条件", required = true, dataTypeClass = edu.hubu.commons.mybatis.model.Faculty.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "facultyId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Faculty faculty
    ) {
        List<edu.hubu.commons.mybatis.model.Faculty> list = service.selectLikePageOrderBy(currentPage, pageSize,
            orderBy, faculty);
        return new CommonResult().setCode(200).setCurrentPage(1)
            .setData(list)
            .setMessage("SUCCESS")
            .setTotal(list.size());
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "faculty", value = "需要保存的学院", required = true, dataTypeClass = Faculty.class)
    public CommonResult save(@RequestBody Faculty faculty) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(faculty)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "学院id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "faculty", value = "需要修改的学院", required = true, dataTypeClass = Faculty.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody Faculty faculty) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(faculty)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据Id逻辑删除")
    @ApiImplicitParam(name = "id", value = "学院id", required = true, dataTypeClass = String.class)
    public CommonResult logicDeleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.logicalDeleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "根据Id封禁")
    @ApiImplicitParam(name = "id", value = "学院id", required = true, dataTypeClass = String.class)
    public CommonResult forbidById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.forbidById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "学院id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.deleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
}
