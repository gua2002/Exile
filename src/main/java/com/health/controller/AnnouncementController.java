package com.health.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.aop.MyLog;
import com.health.dto.ActionResult;
import com.health.po.Announcement;
import com.health.service.AnnounceService;
import com.health.util.ResultHandler;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName AnnouncementController
 * @Description 公告控制类
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class AnnouncementController {
    @Autowired(required = false)
    private AnnounceService announceService;

    /**
     * @return com.health.dto.ActionResult
     * @Author wuyang
     * @Description 分页查询通知
     * @Param [current, size]
     **/
    @ApiOperation(value = "分页查询通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "查询的页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页显示的条数", required = true)
    })
    @MyLog(name = "分页查询通知")
    @GetMapping("/findannounce/{current}/{size}")
    @ResponseBody
    public ActionResult findAnnounceByPage(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageHelper.startPage(current, size);
        List<Announcement> list = announceService.findAnnounce();
        PageInfo<Announcement> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }
    /**
     * @Author wuyang
     * @Description 查询通知（按时间降序）
     * @Date 2022/2/17 12:54
     * @Param []
     * @return com.health.dto.ActionResult
     **/
    @ApiOperation(value = "查询通知（按时间降序）")
    @MyLog(name = "查询通知（按时间降序）")
    @GetMapping("/checkAllAnnouncement")
    @ResponseBody
    public ActionResult findAnnounce() {
        List<Announcement> list = announceService.findAnnounceByTime();
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", list);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    /**
     * @return com.exam.dto.ActionResult
     * @Author wuyang
     * @Description 添加通知
     * @Param [announcement]
     **/
    @ApiOperation(value = "添加通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "announcementname", value = "通告的标题", required = true),
            @ApiImplicitParam(name = "description", value = "通告内容", required = true),
            @ApiImplicitParam(name = "time", value = "添加时间", required = true)
    })
    @MyLog(name = "添加通知")
    @PostMapping("/addannounce")
    @ResponseBody
    public ActionResult addAnnounce(@RequestBody Announcement announcement) {
        int i = announceService.addAnnounce(announcement);
        if (i > 0) {
            return ResultHandler.buildActionResult(200, "添加成功!!", null);
        } else {
            return ResultHandler.buildActionResult(403, "添加失败!!", null);
        }
    }

    /**
     * @return com.exam.dto.ActionResult
     * @Author wuyang
     * @Description 按照id删除通知
     * @Param [announcementid]
     **/
    @ApiOperation(value = "按照id删除通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "announcementid", value = "通告的主键", required = true),
    })
    @MyLog(name = "按照id删除通知")
    @DeleteMapping("/deleteannouce/{announcementid}")
    @ResponseBody
    public ActionResult deleteAnnounceById(@PathVariable Integer announcementid) {
        int i = announceService.deleteAnnounceById(announcementid);
        if (i > 0) {
            return ResultHandler.buildActionResult(200, "删除成功!!", null);
        } else {
            return ResultHandler.buildActionResult(200, "删除失败!!", null);
        }
    }
}
