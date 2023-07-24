package com.health.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName StudentVo
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private Integer e_id;                 //测评表id
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_starte;                //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_ends;                  //结束时间
    private String e_title;               //测评表标题
    private String e_descripte;           //简单介绍
    private String e_time;                //作答时间限制
    private String state;                 //评测表状态
    private Integer s_id;                 //学号
    private String s_name;                //姓名
    private String s_college;             //二级学院
}
