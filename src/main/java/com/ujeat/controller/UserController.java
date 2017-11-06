package com.ujeat.controller;

import com.ujeat.utils.Response;
import com.ujeat.entity.User;
import com.ujeat.service.UserService;
import com.ujeat.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户控制器
 * Created by MetalSteel on 2017/11/6.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 用户业务层对象
     */
    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @param result
     * @return
     */
    @PostMapping("/register-user")
    public Response registerUser(@Valid User user, BindingResult result){
        // 创建返回体对象
        Response response = new Response();
        // 校验数据完整性
        if (result.hasErrors()){
            // 设置响应状态位
            response.setStatus(ResponseStatus.RESPONSE_ERROR);
            // 设置响应消息
            response.setMsg(result.getFieldError().getDefaultMessage());
            // 返回结果
            return response;
        }
        // 注册用户
        response = userService.registerUser(user);

        return response;
    }

    /**
     * 用户登录
     * @param user
     * @param result
     * @return
     */
    @PostMapping("/login-user")
    public Response loginUser(@Valid User user, BindingResult result){
        // 创建返回体对象
        Response response = new Response();
        // 校验数据完整性
        if (result.hasErrors()){
            // 设置响应状态位
            response.setStatus(ResponseStatus.RESPONSE_ERROR);
            // 设置响应消息
            response.setMsg(result.getFieldError().getDefaultMessage());
            // 返回结果
            return response;
        }
        // 登录用户
        response = userService.loginUser(user);

        return response;
    }

    /**
     * 查询所有用户根据击杀数
     * @return
     */
    @GetMapping("/kills-chart")
    public List<User> killsChart(){
        return userService.killsChart();
    }

    /**
     * 更新击杀人数
     * @return
     */
    @PostMapping("/update-kills")
    public Response updateKills(User user){
        return userService.updateKills(user);
    }
}

