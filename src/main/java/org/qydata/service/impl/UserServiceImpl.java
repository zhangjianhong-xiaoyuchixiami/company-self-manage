package org.qydata.service.impl;

import org.qydata.entity.User;
import org.qydata.mapper.UserMapper;
import org.qydata.service.UserService;
import org.qydata.tools.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jonhn on 2017/2/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserMapper userMapper;

    @Override
    public User get(String username) throws Exception {
        return this.userMapper.findById(username);
    }
    @Override
    public Map<String, Object> listAuthByUser(String username) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("allRoles", this.userMapper.findAllRoleByUser(username)) ;
        map.put("allActions", this.userMapper.findAllActionByUser(username)) ;
        return map ;
    }

    @Override
    public Boolean register(String username, String password, String email) {
        try {
            Boolean result = false;
            //生成用户code
            String code= UUID.randomUUID().toString().replace("-", "");
            //添加用户
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setCode(code);
            result=userMapper.addUser(user);
            //向用户发送激活邮件
            SendEmail.sendMail(email,code);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean active(String code) {
        try {
            String username = userMapper.findUserByCode(code);
            if (username != null && username != "") {
                //如果存在用户，将此用户状态设为可用
                userMapper.updateState(username);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteUserByCode(String code) {
        try {
            return userMapper.deleteUserByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean forgot(String email, String password) {
        return SendEmail.sendForgotMail(email,password);
    }

    @Override
    public boolean updatePassword(String email, String password) {
        try {
            return userMapper.updatePassword(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User queryUserByUsername(String username) {
        try {
            return userMapper.queryUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
