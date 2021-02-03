package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Faculty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IFacultyService {

    @GetMapping("/faculty/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/faculty/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "facultyId") String orderBy);

    @GetMapping("/faculty/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "facultyId") String orderBy
    );

    @PostMapping("/faculty/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "facultyId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Faculty faculty
    );

    @PostMapping("/faculty/")
    CommonResult save(@RequestBody Faculty faculty);

    @PutMapping("/faculty/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Faculty faculty);

    @DeleteMapping("/faculty/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/faculty/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/faculty/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
