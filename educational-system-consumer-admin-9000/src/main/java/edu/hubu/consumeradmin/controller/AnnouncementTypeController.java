package edu.hubu.consumeradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.AnnouncementType;
import edu.hubu.consumeradmin.service.IAnnouncementTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author moonlan
 * date 2021/2/1 下午5:01
 */
@SuppressWarnings(value = "unused")
@RestController
@RequestMapping("/consumer/announcementType")
@Api(tags = "公告类型api")
public class AnnouncementTypeController {

    private final IAnnouncementTypeService service;

    public AnnouncementTypeController(IAnnouncementTypeService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "公告类型id", required = true, dataTypeClass = String.class)
    public CommonResult selectOneById(@PathVariable("id") String id) {
        return service.selectOne(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为公告类型ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "announcementTypeId") String orderBy) {
        return service.selectAll(orderBy);
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为公告类型ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "announcementTypeId") String orderBy
    ) {
        return service.selectAllPage(currentPage, pageSize, orderBy);
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为公告类型ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "announcementType", value = "查询公告类型的条件", required = true, dataTypeClass =
                    edu.hubu.commons.mybatis.model.AnnouncementType.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "announcementTypeId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.AnnouncementType announcementType
    ) {
        return service.selectLikePage(currentPage, pageSize, orderBy, announcementType);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "announcementType", value = "需要保存的公告类型", required = true, dataTypeClass = AnnouncementType.class)
    public CommonResult save(@RequestBody AnnouncementType announcementType) {
        return service.save(announcementType);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "公告类型id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "announcementType", value = "需要修改的公告类型", required = true, dataTypeClass = AnnouncementType.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody AnnouncementType announcementType) {
        return service.update(id, announcementType);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据Id逻辑删除")
    @ApiImplicitParam(name = "id", value = "公告类型id", required = true, dataTypeClass = String.class)
    public CommonResult logicDeleteById(@PathVariable("id") String id) {
        return service.logicDeleteById(id);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "根据Id封禁")
    @ApiImplicitParam(name = "id", value = "公告类型id", required = true, dataTypeClass = String.class)
    public CommonResult forbidById(@PathVariable("id") String id) {
        return service.forbidById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "公告类型id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }
}
