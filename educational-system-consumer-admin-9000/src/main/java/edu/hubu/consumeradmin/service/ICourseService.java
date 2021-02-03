package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface ICourseService {

    @GetMapping("/course/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/course/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "courseId") String orderBy);

    @GetMapping("/course/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "courseId") String orderBy
    );

    @PostMapping("/course/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "courseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Course course
    );

    @PostMapping("/course/")
    CommonResult save(@RequestBody Course course);

    @PutMapping("/course/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Course course);

    @DeleteMapping("/course/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/course/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/course/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
