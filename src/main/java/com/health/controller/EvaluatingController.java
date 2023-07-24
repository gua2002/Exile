package com.health.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Evaluating;
import com.health.po.Teacher;
import com.health.service.EsService;
import com.health.service.EvaluatingService;
import com.health.util.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName EvaluatingController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class EvaluatingController {
    @Autowired
    private EvaluatingService evaluatingService;
    @Autowired
    private EsService esService;

    @GetMapping("/findevaiting/{current}/{size}")
    @ResponseBody
    public ActionResult findEvaluating(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageHelper.startPage(current, size);
        List<Evaluating> list = evaluatingService.findEvaluating();
        PageInfo<Evaluating> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @GetMapping("/findallevaiting/{current}/{size}")
    @ResponseBody
    public ActionResult findAllEvaluating(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        PageHelper.startPage(current, size);
        List<Evaluating> list = evaluatingService.findAllEvaluating();
        PageInfo<Evaluating> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @GetMapping("/findevalutinfo/{e_id}")
    @ResponseBody
    public ActionResult findEvaluatInfo(@PathVariable("e_id") Integer e_id) {
        Evaluating evaluating = evaluatingService.findEvaluatInfo(e_id);
        if (evaluating != null) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", evaluating);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @PutMapping("/updataevating")
    @ResponseBody
    public ActionResult updataEvaluatingByid(@RequestBody Evaluating evaluating) {
        int count = evaluatingService.updataEvaluatingByid(evaluating);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "更新成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "更新失败!!!", null);
        }
    }

    @DeleteMapping("/delevating/{e_id}")
    @ResponseBody
    public ActionResult deleteEvaluatingById(@PathVariable("e_id") Integer e_id){
        int count=0;
        count+=evaluatingService.deleteEvaluatingById(e_id);
        count+=esService.deleteEsceid(e_id);//关联表删除
        if (count>0) {
            return ResultHandler.buildActionResult(200, "删除成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "删除失败!!!", null);
        }
    }

    @PostMapping("/addevating")
    @ResponseBody
    public ActionResult addEvaluating(@RequestBody Evaluating evaluating){
        int count=0;
        count+= evaluatingService.addEvaluating(evaluating);//主键回填
        count+=esService.insertEsceid(evaluating.getE_id());
        if (count>0) {
            return ResultHandler.buildActionResult(200, "添加成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "添加失败!!!", null);
        }
    }

}
