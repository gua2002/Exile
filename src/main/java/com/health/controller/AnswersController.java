package com.health.controller;

import com.health.dto.ActionResult;
import com.health.po.Answers;
import com.health.po.Esitem;
import com.health.service.AnswersService;
import com.health.service.EsService;
import com.health.util.ResultHandler;
import com.health.vo.AnswersVo;
import com.health.vo.AnswersVo2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author wuyang
 * @ClassName AnswersController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class AnswersController {
    @Autowired
    private AnswersService answersService;
    @Autowired
    private EsService esService;
    @GetMapping("/findanswers/{e_id}")
    @ResponseBody
    public ActionResult findAnswers(@PathVariable("e_id") Integer e_id) {
        List<AnswersVo> list = answersService.findAnswers(e_id);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", list);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }
    /**
     * @Author wuyang
     * @Description 学生添加测评
     * @Param [answersVo2]
     * @return com.health.dto.ActionResult
     **/
    @PostMapping(value = "/inseranswers")
    @ResponseBody
    public ActionResult insertAnswers(@RequestBody AnswersVo2 answersVo2){
        Answers answers=new Answers();
        Esitem esitem=new Esitem();
        esitem.setE_id(answersVo2.getE_id());
        esitem.setS_id(answersVo2.getS_id());
        int count=0;
        int lenths = answersVo2.getQ_id().length;
        if (lenths==20){
            for (int i = 0; i <answersVo2.getQ_id().length ; i++) {
                answers.setS_id(answersVo2.getS_id());
                answers.setE_id(answersVo2.getE_id());
                answers.setQ_id(answersVo2.getQ_id()[i]);
                answers.setQ_grade(answersVo2.getQ_grade()[i]);
                count+= answersService.insertAnswers(answers);
            }
            count+=esService.updataState(esitem);
            if (count>0) {
                return ResultHandler.buildActionResult(200, "添加成功!!!", null);
            } else {
                return ResultHandler.buildActionResult(400, "添加失败!!!", null);
            }
        }else {
            return ResultHandler.buildActionResult(400, "题目未答完!!!", null);
        }

    }
}
