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
    public User get(String email) throws Exception {
        return this.userMapper.findById(email);
    }
    @Override
    public Map<String, Object> listAuthByUser(Integer id) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("allRoles", this.userMapper.findAllRoleByUser(id)) ;
        map.put("allActions", this.userMapper.findAllActionByUser(id)) ;
        return map ;
    }

    @Override
    public Boolean register(String password, String email){
        try {
            //生成用户code
            String code= UUID.randomUUID().toString().replace("-", "");
            //添加用户
            User user = new User();
            user.setPassword(password);
            user.setEmail(email);
            user.setCode(code);
            userMapper.addUser(user);
            //向用户发送激活邮件
            if (SendEmail.sendMail(email,code)){
                return true;
            }
            userMapper.deleteUserById(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean active(String code) {
        try {
            User user = userMapper.findUserByCode(code);
            if (user != null) {
                //如果存在用户，将此用户状态设为可用
                userMapper.updateState(user.getId());
                userMapper.addUserRole(user.getId());
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
    public User queryUserByUsername(String email) {
        try {
            return userMapper.queryUserByUsername(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateLoginPassword(String email, String password) {
        try {
            return userMapper.updateLoginPassword(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUserRole(Integer id) {
        try {
            return userMapper.addUserRole(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
