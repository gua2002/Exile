package com.health.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuyang
 * @ClassName Question  实体类
 * @Description TODO
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer q_id;             //题目id
    private String q_name;            //题目
    private Integer c_id;             //分类id
}
