package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.StudentScore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IStudentScoreService {

    @GetMapping("/studentscore/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/studentscore/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "studentscoreId") String orderBy);

    @GetMapping("/studentscore/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentscoreId") String orderBy
    );

    @PostMapping("/studentscore/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "studentscoreId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.StudentScore studentscore
    );

    @PostMapping("/studentscore/")
    CommonResult save(@RequestBody StudentScore studentscore);

    @PutMapping("/studentscore/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody StudentScore studentscore);


    @DeleteMapping("/studentscore/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
