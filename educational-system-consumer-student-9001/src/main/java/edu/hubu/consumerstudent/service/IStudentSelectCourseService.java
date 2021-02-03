package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.StudentSelectCourse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IStudentSelectCourseService {

    @GetMapping("/studentselectCourse/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/studentselectCourse/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "studentselectCourseId") String orderBy);

    @GetMapping("/studentselectCourse/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentselectCourseId") String orderBy
    );

    @PostMapping("/studentselectCourse/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentselectCourseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.StudentSelectCourse studentselectCourse
    );

    @PostMapping("/studentselectCourse/")
    CommonResult save(@RequestBody StudentSelectCourse studentselectCourse);

    @PutMapping("/studentselectCourse/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody StudentSelectCourse studentselectCourse);


    @DeleteMapping("/studentselectCourse/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
