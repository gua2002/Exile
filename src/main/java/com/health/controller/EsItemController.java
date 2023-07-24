package com.health.controller;

import com.health.dto.ActionResult;
import com.health.po.Esitem;
import com.health.service.EsService;
import com.health.util.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuyang
 * @ClassName EsItemController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class EsItemController {
    @Autowired
    private EsService esService;

    @PutMapping("/insertesc")
    @ResponseBody
     public ActionResult insertEsc(@RequestBody Esitem esitem){
        int count= esService.insertEsc(esitem);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "添加成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(400, "添加失败!!!", null);
        }
     }
}
