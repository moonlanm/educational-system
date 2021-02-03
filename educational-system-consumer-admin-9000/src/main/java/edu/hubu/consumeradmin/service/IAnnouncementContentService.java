package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.AnnouncementContent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IAnnouncementContentService {

    @GetMapping("/announcementContent/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/announcementContent/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "announcementContentId") String orderBy);

    @GetMapping("/announcementContent/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementContentId") String orderBy
    );

    @PostMapping("/announcementContent/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementContentId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.AnnouncementContent announcementContent
    );

    @PostMapping("/announcementContent/")
    CommonResult save(@RequestBody AnnouncementContent announcementContent);

    @PutMapping("/announcementContent/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody AnnouncementContent announcementContent);


    @DeleteMapping("/announcementContent/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
