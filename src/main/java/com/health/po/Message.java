package com.health.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author wuyang
 * @ClassName Message
 * @Description 心里悄悄话实体类
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer m_id;                //id
    private String m_title;              //标题
    private String m_content;            //内容
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date m_time;                 //时间
    private List<Replay> list;
}
