package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IStudentService {

    @GetMapping("/student/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/student/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "studentId") String orderBy);

    @GetMapping("/student/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentId") String orderBy
    );

    @PostMapping("/student/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Student student
    );

    @PostMapping("/student/")
    CommonResult save(@RequestBody Student student);

    @PutMapping("/student/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Student student);

    @DeleteMapping("/student/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/student/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/student/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
