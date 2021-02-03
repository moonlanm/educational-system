package edu.hubu.consumerstudent.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.student.Score;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "student-provider-service")
public interface IScoreService {

    @GetMapping("/score/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/score/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "scoreId") String orderBy);

    @GetMapping("/score/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "scoreId") String orderBy
    );

    @PostMapping("/score/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "scoreId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Score score
    );

    @PostMapping("/score/")
    CommonResult save(@RequestBody Score score);

    @PutMapping("/score/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Score score);

    @DeleteMapping("/score/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/score/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/score/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
