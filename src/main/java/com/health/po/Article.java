package com.health.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author wuyang
 * @ClassName Article 文章实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer et_id;                  //文章id
    private String et_name;                 //文章标题
    private String et_description;          //文章介绍
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date et_ctime;                  //文章发表时间
    private String et_author;               //文章作者
    private String et_root;                 //文章来源
    private String et_content;              //文章内容
}
