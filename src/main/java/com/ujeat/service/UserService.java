package com.ujeat.service;

import com.ujeat.utils.Response;
import com.ujeat.entity.User;
import com.ujeat.repository.UserRepository;
import com.ujeat.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户类业务接口
 * Created by MetalSteel on 2017/11/6.
 */
@Service
public class UserService {
    /**
     * 注入用户持久层操作接口
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Response registerUser(User user){
        // 创建返回对象
        Response response = new Response();
        // 用户名重复
        User result = userRepository.findAllByNickname(user.getNickname());
        if(result!=null){
            // 设置返回状态位
            response.setStatus(ResponseStatus.RESPONSE_ERROR);
            // 设置返回错误提示信息
            response.setMsg(ResponseStatus.REGISTER_ERROR_NICKNAME_REPEAT);
            return response;
        }
        // 用户注册
        userRepository.save(user);
        // 用户注册成功
        response.setStatus(ResponseStatus.RESPONSE_OK);
        // 设置注册成功提示信息
        response.setMsg(ResponseStatus.REGISTER_OK);

        return response;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    public Response<User> loginUser(User user){
        // 创建返回体对象
        Response<User> response = new Response();
        // 根据用户名和密码查询用户
        User result = userRepository.findAllByNicknameAndAndPassword(user.getNickname(), user.getPassword());
        // 判断是否查询成功
        if (result != null){
            // 响应成功
            response.setStatus(ResponseStatus.RESPONSE_OK);
            // 响应信息
            response.setMsg(ResponseStatus.LOGIN_OK);
            // 响应数据
            response.setData(result);
        }else {
            // 响应失败
            response.setStatus(ResponseStatus.RESPONSE_ERROR);
            // 响应信息
            response.setMsg(ResponseStatus.LOGIN_ERROR);
        }
        return response;
    }

    /**
     * 查询所有用户根据击杀数
     * @return
     */
    public List<User> killsChart(){
        // 根据kills降序排列
        Sort sort = new Sort(Sort.Direction.DESC, "kills");
        return userRepository.findAll(sort);
    }

    /**
     * 更新击杀人数
     * @param user
     * @return
     */
    public Response updateKills(User user){
        // 创建返回体对象
        Response<User> response = new Response();
        // 根据Id查询用户
        User one = userRepository.findOne(user.getId());
        // 设置用户最新的kills
        one.setKills(user.getKills());
        // 保存
        userRepository.save(one);
        // 设置响应体
        response.setStatus(ResponseStatus.RESPONSE_OK);
        response.setMsg(ResponseStatus.KILLS_UPDATE_OK);

        return response;
    }
}
