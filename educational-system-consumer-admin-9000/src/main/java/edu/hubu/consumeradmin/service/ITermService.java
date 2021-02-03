package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Term;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface ITermService {

    @GetMapping("/term/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/term/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "termId") String orderBy);

    @GetMapping("/term/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "termId") String orderBy
    );

    @PostMapping("/term/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "termId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Term term
    );

    @PostMapping("/term/")
    CommonResult save(@RequestBody Term term);

    @PutMapping("/term/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Term term);


    @DeleteMapping("/term/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
