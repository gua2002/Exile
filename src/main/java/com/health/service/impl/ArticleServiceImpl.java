package com.health.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.mapper.ArticleMapper;
import com.health.po.Article;
import com.health.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyang
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
   private ArticleMapper articleMapper;
    @Override
    public List<Article> findArticleByPage() {
        return articleMapper.findArticleByPage();
    }

    @Override
    public List<Article> findArticleById(Integer et_id) {
        return articleMapper.findArticleById(et_id);
    }

    @Override
    public int updataArticle(Article article) {
        return articleMapper.updataArticle(article);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticleById(Integer et_id) {
        return articleMapper.deleteArticleById(et_id);
    }
}
