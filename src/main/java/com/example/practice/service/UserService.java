package com.example.practice.service;

import com.example.practice.bean.Result;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.practice.bean.Result;

import com.example.practice.bean.User;

import com.example.practice.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired

    private UserMapper userMapper;
    public Result regist(User user) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {

            User existUser = userMapper.findUserByName(user.getUsername());

            if(existUser != null){

                //如果用户名已存在

                result.setMsg("用户名已存在");



            }else{

                userMapper.regist(user);

                //System.out.println(user.getId());

                result.setMsg("注册成功");

                result.setSuccess(true);

                result.setDetail(user);

            }

        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }

    /**

     * 登录

     * @param user 用户名和密码

     * @return Result

     */

    public Result login(User user) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {

            Long userId= userMapper.login(user);

            if(userId == null){

                result.setMsg("用户名或密码错误");

            }else{

                result.setMsg("登录成功");

                result.setSuccess(true);

                user.setId(userId);

                result.setDetail(user);

            }

        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }
}
