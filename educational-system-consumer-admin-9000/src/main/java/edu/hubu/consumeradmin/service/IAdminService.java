package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IAdminService {

    @GetMapping("/admin/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/admin/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "adminId") String orderBy);

    @GetMapping("/admin/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "adminId") String orderBy
    );

    @PostMapping("/admin/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "adminId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Admin admin
    );

    @PostMapping("/admin/")
    CommonResult save(@RequestBody Admin admin);

    @PutMapping("/admin/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Admin admin);

    @DeleteMapping("/admin/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/admin/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/admin/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
