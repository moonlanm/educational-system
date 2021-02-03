package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.StudentCourse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IStudentCourseService {

    @GetMapping("/studentCourse/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/studentCourse/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "studentCourseId") String orderBy);

    @GetMapping("/studentCourse/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentCourseId") String orderBy
    );

    @PostMapping("/studentCourse/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentCourseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.StudentCourse studentCourse
    );

    @PostMapping("/studentCourse/")
    CommonResult save(@RequestBody StudentCourse studentCourse);

    @PutMapping("/studentCourse/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody StudentCourse studentCourse);


    @DeleteMapping("/studentCourse/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
