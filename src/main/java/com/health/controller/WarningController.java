package com.health.controller;

import com.health.dto.ActionResult;
import com.health.service.WarningService;
import com.health.util.ResultHandler;
import com.health.vo.WarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyang
 * @ClassName 错误页面控制
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class WarningController {
    @Autowired
    private WarningService warningService;

    @GetMapping("/warningscore/{s_id}/{e_id}")
    @ResponseBody
    public ActionResult getWarningByid(@PathVariable("s_id") Integer s_id,@PathVariable("e_id") Integer e_id){
        List<WarningVo> list = new ArrayList<>();
        WarningVo vo;
        List<Integer> list1;
        list1=warningService.getSumQgradeByCid(s_id,e_id);
        for (int i = 0; i <10 ; i++) {
            Integer q_grade = list1.get(i);
            Integer c_id=i+1;
            vo = warningService.getWarningByid(s_id, e_id, q_grade, c_id);
            if(vo!=null){
                list.add(vo);
            }

        }
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", list);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

}
