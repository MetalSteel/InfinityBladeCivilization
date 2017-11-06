package com.ujeat.repository;

import com.ujeat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户持久层操作接口
 * Created by MetalSteel on 2017/11/6.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据昵称查询用户
     * @param nickname
     * @return
     */
    User findAllByNickname(String nickname);

    /**
     * 根据昵称和用户名查询用户
     * @param nickname
     * @param password
     * @return
     */
    User findAllByNicknameAndAndPassword(String nickname,String password);

}
