package edu.hubu.consumerteacher.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.teacher.TeacherSelectCourse;
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
public interface ITeacherSelectCourseService {

    @GetMapping("/teacherSelectCourse/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/teacherSelectCourse/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "teacherSelectCourseId") String orderBy);

    @GetMapping("/teacherSelectCourse/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherSelectCourseId") String orderBy
    );

    @PostMapping("/teacherSelectCourse/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherSelectCourseId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.TeacherSelectCourse teacherSelectCourse
    );

    @PostMapping("/teacherSelectCourse/")
    CommonResult save(@RequestBody TeacherSelectCourse teacherSelectCourse);

    @PutMapping("/teacherSelectCourse/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody TeacherSelectCourse teacherSelectCourse);


    @DeleteMapping("/teacherSelectCourse/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
