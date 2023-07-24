package com.health.controller;

import com.health.dto.ActionResult;
import com.health.po.QECitem;
import com.health.service.QecitemService;
import com.health.util.ResultHandler;
import com.health.vo.QecitemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author wuyang
 * @ClassName QecItemController
 * @Description 学生评测表控制类
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class QecItemController {
    @Autowired(required = false)
    private QecitemService qecitemService;
    /**
     * @Author wuyang
     * @Description 自动生成学生的评测表
     * @Param [qecitem]
     * @return com.health.dto.ActionResult
     **/
    @PostMapping(value = "/insertqec")
    @ResponseBody
    public ActionResult insertQecitem(@RequestBody QECitem qecitem){
        Integer e_id = qecitem.getE_id();
        Integer s_id = qecitem.getS_id();
        int count=0;
        QecitemVo qecitemVo;
        qecitemService.deleteQecitem(e_id,s_id);//开始之前，先删除
        for (int i = 1; i <=10; i++) {//共10类题目，按照类别查询
            List<Integer> list=qecitemService.getQuestion(i);//查询数据库
            Set<Integer> set = getRandomSet(2, 7);//随机生成2个不重复的下标
            Iterator<Integer> it = set.iterator();//迭代遍历set集合
            while (it.hasNext()) {
                Integer str = it.next();
                qecitemVo =new QecitemVo();
                qecitemVo.setQ_id(list.get(str));
                qecitemVo.setE_id(e_id);
                qecitemVo.setC_id(i);
                qecitemVo.setS_id(s_id);
                count+= qecitemService.inertQec(qecitemVo);
            }
        }
        if (count>0) {
            return ResultHandler.buildActionResult(200, "添加成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(400, "添加失败!!!", null);
        }
    }

    /**
     *生成随机数
     *@param size 目标数组大小
     *@param max 目标数最大值
     */
    public Set<Integer> getRandomSet(int size,int max) {
        Random random = new Random();
        Set<Integer> result = new LinkedHashSet<>();
        while (result.size() < size) {
            Integer next = random.nextInt(max) + 1;
            result.add(next);
        }
        return result;
    }
}
