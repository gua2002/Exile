package com.health.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName Replay
 * @Description TODO
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Replay {
    private Integer r_id;
    private String r_replay;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_time;
    private Integer m_id;
}
