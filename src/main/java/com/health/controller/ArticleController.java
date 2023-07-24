package com.health.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.dto.ActionResult;
import com.health.po.Announcement;
import com.health.po.Article;
import com.health.service.ArticleService;
import com.health.util.ResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ArticleController
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/health")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @Author wuyang
     * @Description 分页查询文章
     * @Param [page, size]
     * @return com.health.dto.ActionResult
     **/
    @GetMapping("/findartice/{current}/{size}")
    @ResponseBody
    public ActionResult findArticleByPage(@PathVariable("current") Integer current,@PathVariable("size") Integer size){
        PageHelper.startPage(current,size);
        List<Article> list=articleService.findArticleByPage();
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        if (list!=null&&list.size()!=0){
            return ResultHandler.buildActionResult(200,"查询成功!!!",pageInfo);
        }else {
            return ResultHandler.buildActionResult(404,"查询失败!!!",null);
        }

    }
    /**
     * @Author wuyang
     * @Description 根据id查询文章
     * @Param [et_id]
     * @return com.health.dto.ActionResult
     **/
    @GetMapping("/findarticleinfo/{et_id}")
    @ResponseBody
    public ActionResult findArticleById(@PathVariable("et_id") Integer et_id ){
        List<Article> list=articleService.findArticleById(et_id);
        if (list!=null&&list.size()!=0){
            return ResultHandler.buildActionResult(200,"查询成功!!!",list);
        }else {
            return ResultHandler.buildActionResult(404,"查询失败!!!",null);
        }
    }

    @PutMapping("/updataarticle")
    @ResponseBody
    public ActionResult updataArticle(@RequestBody Article article){
        int count = articleService.updataArticle(article);
        if (count>0) {
            return ResultHandler.buildActionResult(200, "更新成功!!!", null);
        } else {
            return ResultHandler.buildActionResult(404, "更新失败!!!", null);
        }
    }

    @PostMapping("/addarticle")
    @ResponseBody
    public ActionResult addArticle(@RequestBody Article article) {
        int count = articleService.addArticle(article);
        if (count > 0) {
            return ResultHandler.buildActionResult(200, "添加成功!!", null);
        } else {
            return ResultHandler.buildActionResult(403, "添加失败!!", null);
        }
    }

    @DeleteMapping("/delarticle/{et_id}")
    @ResponseBody
    public ActionResult deleteArticleById(@PathVariable("et_id") Integer et_id) {
        int count = articleService.deleteArticleById(et_id);
        if (count > 0) {
            return ResultHandler.buildActionResult(200, "删除成功!!", null);
        } else {
            return ResultHandler.buildActionResult(200, "删除失败!!", null);
        }
    }



}
