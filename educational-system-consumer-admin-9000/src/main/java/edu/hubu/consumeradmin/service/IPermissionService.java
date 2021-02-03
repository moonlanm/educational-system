package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IPermissionService {

    @GetMapping("/permission/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/permission/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "permissionId") String orderBy);

    @GetMapping("/permission/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "permissionId") String orderBy
    );

    @PostMapping("/permission/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "permissionId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Permission permission
    );

    @PostMapping("/permission/")
    CommonResult save(@RequestBody Permission permission);

    @PutMapping("/permission/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Permission permission);

    @DeleteMapping("/permission/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/permission/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/permission/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
