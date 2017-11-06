package com.ujeat.utils;

/**
 * 响应类
 * Created by MetalSteel on 2017/11/6.
 */
public class Response<T> {
    // 响应状态
    private String status;
    // 响应提示信息
    private String msg;
    // 响应数据
    private T data;

    public Response() {
    }

    public Response(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
