package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.RolePermissionMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IRolePermissionMapService {

    @GetMapping("/rolePermissionMap/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/rolePermissionMap/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "rolePermissionMapId") String orderBy);

    @GetMapping("/rolePermissionMap/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "rolePermissionMapId") String orderBy
    );

    @PostMapping("/rolePermissionMap/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "rolePermissionMapId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.RolePermissionMap rolePermissionMap
    );

    @PostMapping("/rolePermissionMap/")
    CommonResult save(@RequestBody RolePermissionMap rolePermissionMap);

    @PutMapping("/rolePermissionMap/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody RolePermissionMap rolePermissionMap);


    @DeleteMapping("/rolePermissionMap/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
