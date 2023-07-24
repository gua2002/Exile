package com.health.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Message;
import com.health.po.Replay;
import com.health.service.MessageService;
import com.health.util.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName MessageController
 * @Description 匿名留言板控制类
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
public class MessageController {
    @Autowired(required = false)
    private MessageService messageService;

    @GetMapping("/messages/{current}/{size}")
    @ResponseBody
    public ActionResult getMessages(@PathVariable("current") Integer current, @PathVariable("size") Integer size){
        PageHelper.startPage(current,size);
        List<Message> list=messageService.findMessage();
        PageInfo<Message> pageInfo = new PageInfo<>(list);
        if (list != null && list.size() != 0) {
            return ResultHandler.buildActionResult(200, "查询成功!!!", pageInfo);
        } else {
            return ResultHandler.buildActionResult(404, "查询失败!!!", null);
        }
    }

    @PostMapping("/insertmessage")
    @ResponseBody
    public ActionResult insertMessage(@RequestBody Message message){
         int count=messageService.insertMessage(message);
         if (count>0){
             return new ActionResult(200,"添加成功!!!",null);
         }else {
             return new ActionResult(403,"添加失败!!!",null);
         }
    }

    @PostMapping("/replay")
    @ResponseBody
    public ActionResult insertMessageCount(@RequestBody Replay replay){
        int count=messageService.insertMessageCount(replay);
        if (count>0){
            return new ActionResult(200,"添加成功!!!",null);
        }else {
            return new ActionResult(403,"添加失败!!!",null);
        }
    }
}
