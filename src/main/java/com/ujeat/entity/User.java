package com.ujeat.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * 用户类
 * Created by MetalSteel on 2017/11/6.
 */
@Entity
@Table(name = "user")
public class User {
    // 主键编号
    @Id
    @GeneratedValue
    private Integer id;
    // 用户昵称
    @Column(name = "nickname",unique = true,nullable = false,length = 64)
    @NotEmpty(message = "用户昵称不能为空")
    @Length(min = 2,max = 8,message = "用户昵称长度为2-8位")
    private String nickname;
    // 用户密码
    @Column(name = "password",nullable = false,length = 64)
    @NotEmpty(message = "用户密码不能为空")
    @Length(min = 6,max = 15,message = "用户密码长度为2-8位")
    private String password;
    // 用户击杀人数
    @Column(name = "kills")
    private Integer kills = 0;

    public User() {
    }

    public User(String nickname, String password, Integer kills) {
        this.nickname = nickname;
        this.password = password;
        this.kills = kills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }
}
