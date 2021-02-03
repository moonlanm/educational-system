package edu.hubu.provideradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Role;
import edu.hubu.commons.service.admin.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午2:16
 */
@SuppressWarnings(value = "unused")
@RestController
@RequestMapping("/role")
@Api(tags = "角色 api")
public class RoleController {

    private final IRoleService service;

    public RoleController(IRoleService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataTypeClass = String.class)
    public CommonResult selectOne(@PathVariable("id") String id) {
        return new CommonResult().setCode(200).setCurrentPage(1).setData(service.selectOneById(id))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "roleId") String orderBy) {
        return new CommonResult().setCode(200).setCurrentPage(1)
                .setData(service.selectAllOrderBy(orderBy))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "roleId") String orderBy
    ) {
        return new CommonResult().setCode(200).setCurrentPage(1)
                .setData(service.selectAllPageOrderBy(currentPage, pageSize, orderBy))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "role", value = "查询角色的条件", required = true, dataTypeClass = edu.hubu.commons.mybatis.model.Role.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "roleId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Role role
    ) {
        return new CommonResult().setCode(200).setCurrentPage(1)
                .setData(service.selectLikePageOrderBy(currentPage, pageSize, orderBy, role))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "role", value = "需要保存的角色", required = true, dataTypeClass = Role.class)
    public CommonResult save(@RequestBody Role role) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(role)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "角色id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "role", value = "需要修改的角色", required = true, dataTypeClass = Role.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody Role role) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(role)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据Id逻辑删除")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataTypeClass = String.class)
    public CommonResult logicDeleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.logicalDeleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "根据Id封禁")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataTypeClass = String.class)
    public CommonResult forbidById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.forbidById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.deleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
}
