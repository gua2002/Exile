package com.health.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuyang
 * @ClassName Esitem
 * @Description 学生评测表状态
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Esitem {
    private Integer e_id;      //评测表id
    private Integer s_id;      //学生id
    private String state;      //评测表状态
}
