package edu.hubu.provideradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.RolePermissionMap;
import edu.hubu.commons.service.admin.IRolePermissionMapService;
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
@RequestMapping("/rolePermissionMap")
@Api(tags = "角色权限映射 api")
public class RolePermissionMapController {

    private final IRolePermissionMapService service;

    public RolePermissionMapController(IRolePermissionMapService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "角色权限映射id", required = true, dataTypeClass = String.class)
    public CommonResult selectOne(@PathVariable("id") String id) {
        return new CommonResult().setCode(200).setCurrentPage(1).setData(service.selectOneById(id))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色权限映射ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "rolePermissionMapId") String orderBy) {
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
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色权限映射ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "rolePermissionMapId") String orderBy
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
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为角色权限映射ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "rolePermissionMap", value = "查询角色权限映射的条件", required = true, dataTypeClass = edu.hubu.commons.mybatis.model.RolePermissionMap.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "rolePermissionMapId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.RolePermissionMap rolePermissionMap
    ) {
        return new CommonResult().setCode(200).setCurrentPage(1)
                .setData(service.selectLikePageOrderBy(currentPage, pageSize, orderBy, rolePermissionMap))
                .setMessage("SUCCESS")
                .setTotal(1);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "rolePermissionMap", value = "需要保存的角色权限映射", required = true, dataTypeClass = RolePermissionMap.class)
    public CommonResult save(@RequestBody RolePermissionMap rolePermissionMap) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(rolePermissionMap)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "角色权限映射id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "rolePermissionMap", value = "需要修改的角色权限映射", required = true, dataTypeClass = RolePermissionMap.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody RolePermissionMap rolePermissionMap) {
        return new CommonResult().setMessage("SUCCESS").setData(service.save(rolePermissionMap)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "角色权限映射id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return new CommonResult().setMessage("SUCCESS").setData(service.deleteById(id)).setMessage("SUCCESS")
                .setCurrentPage(1).setTotal(1);
    }
}
