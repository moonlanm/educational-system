package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.TimeBlock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface ITimeBlockService {

    @GetMapping("/timeBlock/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/timeBlock/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "timeBlockId") String orderBy);

    @GetMapping("/timeBlock/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "timeBlockId") String orderBy
    );

    @PostMapping("/timeBlock/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "timeBlockId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.TimeBlock timeBlock
    );

    @PostMapping("/timeBlock/")
    CommonResult save(@RequestBody TimeBlock timeBlock);

    @PutMapping("/timeBlock/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody TimeBlock timeBlock);


    @DeleteMapping("/timeBlock/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
