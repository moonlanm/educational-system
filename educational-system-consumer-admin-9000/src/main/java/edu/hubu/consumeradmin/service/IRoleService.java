package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IRoleService {

    @GetMapping("/role/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/role/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "roleId") String orderBy);

    @GetMapping("/role/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "roleId") String orderBy
    );

    @PostMapping("/role/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "roleId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Role role
    );

    @PostMapping("/role/")
    CommonResult save(@RequestBody Role role);

    @PutMapping("/role/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Role role);

    @DeleteMapping("/role/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/role/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/role/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
