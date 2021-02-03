package edu.hubu.consumeradmin.service;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.AnnouncementType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午4:54
 */
@SuppressWarnings(value = "unused")
@FeignClient(name = "admin-provider-service")
public interface IAnnouncementTypeService {

    @GetMapping("/announcementType/{id}")
    CommonResult selectOne(@PathVariable("id") String id);

    @GetMapping("/announcementType/all")
    CommonResult selectAll(@RequestParam(value = "orderBy", defaultValue = "announcementTypeId") String orderBy);

    @GetMapping("/announcementType/")
    CommonResult selectAllPage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementTypeId") String orderBy
    );

    @PostMapping("/announcementType/select-like")
    CommonResult selectLikePage(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "orderBy", defaultValue = "announcementTypeId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.AnnouncementType announcementType
    );

    @PostMapping("/announcementType/")
    CommonResult save(@RequestBody AnnouncementType announcementType);

    @PutMapping("/announcementType/{id}")
    CommonResult update(@PathVariable("id") String id, @RequestBody AnnouncementType announcementType);

    @DeleteMapping("/announcementType/{id}")
    CommonResult logicDeleteById(@PathVariable("id") String id);

    @PatchMapping("/announcementType/{id}")
    CommonResult forbidById(@PathVariable("id") String id);

    @DeleteMapping("/announcementType/delete/{id}")
    CommonResult deleteById(@PathVariable("id") String id);
}
