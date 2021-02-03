package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.Announcement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IAnnouncementService {

    @GetMapping("/announcement/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/announcement/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "announcementId") String orderBy);

    @GetMapping("/announcement/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementId") String orderBy
    );

    @PostMapping("/announcement/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.Announcement announcement
    );

    @PostMapping("/announcement/")
    CommonResult save(@RequestBody Announcement announcement);

    @PutMapping("/announcement/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody Announcement announcement);

    @DeleteMapping("/announcement/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/announcement/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/announcement/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
