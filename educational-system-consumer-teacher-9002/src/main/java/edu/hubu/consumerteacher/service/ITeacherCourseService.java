package edu.hubu.consumerteacher.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.teacher.TeacherCourse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "teacher-provider-service")
public interface ITeacherCourseService {

    @GetMapping("/teacherCourse/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/teacherCourse/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "teacherCourseId") String orderBy);

    @GetMapping("/teacherCourse/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherCourseId") String orderBy
    );

    @PostMapping("/teacherCourse/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherCourseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.TeacherCourse teacherCourse
    );

    @PostMapping("/teacherCourse/")
    CommonResult save(@RequestBody TeacherCourse teacherCourse);

    @PutMapping("/teacherCourse/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody TeacherCourse teacherCourse);


    @DeleteMapping("/teacherCourse/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
