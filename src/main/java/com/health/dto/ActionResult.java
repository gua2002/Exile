package com.health.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 提供web对外接口的统一响应对象的封装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionResult implements Serializable {
    private Integer  code; //响应码
    private String msg;//短消息
    private Object data;//响应携带的对象
}
