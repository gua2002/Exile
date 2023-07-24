package com.health.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName Announcement
 * @Description 公告实体类
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    private Integer announcementid;            //公告id
    private String announcementname;           //公告标题
    private String description;                //公告内容
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;                         //公告时间
}
