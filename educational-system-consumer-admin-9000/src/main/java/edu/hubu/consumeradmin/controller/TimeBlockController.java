package edu.hubu.consumeradmin.controller;

import edu.hubu.commons.model.CommonResult;
import edu.hubu.commons.model.admin.TimeBlock;
import edu.hubu.consumeradmin.service.ITimeBlockService;
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
@RequestMapping("/consumer/timeBlock")
@Api(tags = "一天分得的时间块api")
public class TimeBlockController {

    private final ITimeBlockService service;

    public TimeBlockController(ITimeBlockService service) {this.service = service;}

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id精确查询")
    @ApiImplicitParam(name = "id", value = "一天分得的时间块id", required = true, dataTypeClass = String.class)
    public CommonResult selectOneById(@PathVariable("id") String id) {
        return service.selectOne(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有，不带分页")
    @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为一天分得的时间块ID，非必须参数", dataTypeClass = String.class)
    public CommonResult selectAll(@RequestParam(defaultValue = "timeBlockId") String orderBy) {
        return service.selectAll(orderBy);
    }

    @GetMapping("/")
    @ApiOperation(value = "查询所有，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为一天分得的时间块ID，非必须参数", dataTypeClass = String.class)
    })
    public CommonResult selectAllPage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "timeBlockId") String orderBy
    ) {
        return service.selectAllPage(currentPage, pageSize, orderBy);
    }

    @PostMapping("/select-like")
    @ApiOperation(value = "模糊查询，带分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页，从1开始，默认大小为1,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "页面大小，默认为5,非必须参数", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "orderBy", value = "排序字段，默认为一天分得的时间块ID，非必须参数", dataTypeClass = String.class),
            @ApiImplicitParam(name = "timeBlock", value = "查询一天分得的时间块的条件", required = true, dataTypeClass =
                    edu.hubu.commons.mybatis.model.TimeBlock.class)
    })
    public CommonResult selectLikePage(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "timeBlockId") String orderBy,
            @RequestBody edu.hubu.commons.mybatis.model.TimeBlock timeBlock
    ) {
        return service.selectLikePage(currentPage, pageSize, orderBy, timeBlock);
    }

    @PostMapping("/")
    @ApiOperation(value = "保存")
    @ApiImplicitParam(name = "timeBlock", value = "需要保存的一天分得的时间块", required = true, dataTypeClass = TimeBlock.class)
    public CommonResult save(@RequestBody TimeBlock timeBlock) {
        return service.save(timeBlock);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据Id修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "一天分得的时间块id", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "timeBlock", value = "需要修改的一天分得的时间块", required = true, dataTypeClass = TimeBlock.class),
    })
    public CommonResult update(@PathVariable("id") String id, @RequestBody TimeBlock timeBlock) {
        return service.update(id, timeBlock);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据Id删除")
    @ApiImplicitParam(name = "id", value = "一天分得的时间块id", required = true, dataTypeClass = String.class)
    public CommonResult deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }
}