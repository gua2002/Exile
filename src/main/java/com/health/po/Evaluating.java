package com.health.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName Evaluating  实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluating {
    private Integer e_id;                 //测评表id
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_starte;                //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_ends;                  //结束时间
    private String e_title;               //测评表标题
    private String e_descripte;           //简单介绍
    private String e_toke;                //扩展知识
    private String e_time;                //作答时间限制
    private String state;                 //评测表状态
}
