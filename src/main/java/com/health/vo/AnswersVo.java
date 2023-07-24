package com.health.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName AnswersVo
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersVo {
    private Integer q_id;             //量表id
    private String q_name;            //量表题目
    private Integer c_id;             //分类id
    private Integer e_id;             //评测表id
    private String e_time;            //评测表作答时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_starte;                //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_ends;                  //结束时间
    private String e_title;               //测评表标题
    private String e_descripte;           //简单介绍
    private String e_toke;                //扩展知识
}
