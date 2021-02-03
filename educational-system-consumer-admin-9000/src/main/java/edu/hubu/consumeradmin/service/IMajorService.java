package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Major;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IMajorService {

    @GetMapping("/major/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/major/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "majorId") String orderBy);

    @GetMapping("/major/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "majorId") String orderBy
    );

    @PostMapping("/major/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "majorId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Major major
    );

    @PostMapping("/major/")
    CommonResult save(@RequestBody Major major);

    @PutMapping("/major/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Major major);

    @DeleteMapping("/major/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/major/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/major/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
