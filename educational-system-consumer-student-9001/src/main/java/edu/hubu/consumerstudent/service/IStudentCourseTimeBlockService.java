package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.StudentCourseTimeBlock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IStudentCourseTimeBlockService {

    @GetMapping("/studentCourseTimeBlock/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/studentCourseTimeBlock/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "studentCourseTimeBlockId") String orderBy);

    @GetMapping("/studentCourseTimeBlock/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentCourseTimeBlockId") String orderBy
    );

    @PostMapping("/studentCourseTimeBlock/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentCourseTimeBlockId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.StudentCourseTimeBlock studentCourseTimeBlock
    );

    @PostMapping("/studentCourseTimeBlock/")
    CommonResult save(@RequestBody StudentCourseTimeBlock studentCourseTimeBlock);

    @PutMapping("/studentCourseTimeBlock/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody StudentCourseTimeBlock studentCourseTimeBlock);


    @DeleteMapping("/studentCourseTimeBlock/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
