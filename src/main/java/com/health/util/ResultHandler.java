package com.health.util;
import com.health.dto.ActionResult;

/**
 * @Author wuyang
 * @Description Resultful工具类
 * @Param
 * @return
 **/
public class ResultHandler {

    public static ActionResult success(Object object) {
        ActionResult apiResult = new ActionResult();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMsg("请求成功");
        return apiResult;
    }

    public static ActionResult success() {
        return success(null);
    }

    public static <T> ActionResult buildActionResult(Integer code, String msg, T data) {
        ActionResult apiResult = new ActionResult();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        apiResult.setData(data);
        return apiResult;
    }
}
