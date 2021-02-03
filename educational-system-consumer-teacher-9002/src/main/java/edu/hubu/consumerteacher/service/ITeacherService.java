package edu.hubu.consumerteacher.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.teacher.Teacher;
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
public interface ITeacherService {

    @GetMapping("/teacher/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/teacher/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "teacherId") String orderBy);

    @GetMapping("/teacher/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherId") String orderBy
    );

    @PostMapping("/teacher/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "teacherId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Teacher teacher
    );

    @PostMapping("/teacher/")
    CommonResult save(@RequestBody Teacher teacher);

    @PutMapping("/teacher/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Teacher teacher);

    @DeleteMapping("/teacher/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/teacher/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/teacher/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
