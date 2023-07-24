package com.health.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Classification;
import com.health.service.ClassificationService;
import com.health.util.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ClassificationController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/findhealthwaringscore/{current}/{size}")
    @ResponseBody
    public ActionResult findHealthWaringScore(@PathVariable("current") Integer current, @PathVariable("size") Integer size){
        PageHelper.startPage(current,size);
        List<Classification> list=classificationService.findHealthWaringScore();
        PageInfo<Classification> pageInfo=new PageInfo<>(list);
        if (list!=null&&list.size()!=0){
            return ResultHandler.buildActionResult(200,"查询成功!!!",pageInfo);
        }else {
            return ResultHandler.buildActionResult(404,"查询失败!!!",null);
        }
    }
}
