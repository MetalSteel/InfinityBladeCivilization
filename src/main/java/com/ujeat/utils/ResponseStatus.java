package com.ujeat.utils;

/**
 * 响应状态
 * Created by MetalSteel on 2017/11/6.
 */
public interface ResponseStatus {
    // 响应成功
    String RESPONSE_OK = "RESPONSE_OK";
    // 响应失败
    String RESPONSE_ERROR = "RESPONSE_ERROR";
    // 注册成功信息
    String REGISTER_OK = "用户注册成功!";
    // 注册失败信息-用户昵称已经存在
    String REGISTER_ERROR_NICKNAME_REPEAT = "用户昵称已经存在";
    // 用户登录成功
    String LOGIN_OK = "用户登录成功";
    // 用户登录失败
    String LOGIN_ERROR = "用户名或者密码错误";
    // 更新击杀人数成功
    String KILLS_UPDATE_OK = "更新击杀人数成功";
}
