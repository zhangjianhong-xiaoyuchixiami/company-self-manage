package org.qydata.service.impl;

import org.qydata.entity.User;
import org.qydata.mapper.UserMapper;
import org.qydata.service.UserService;
import org.qydata.tools.RegexUtil;
import org.qydata.tools.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Boolean register(String password,String email, String companyName, String busPerson, String busTel,
                            String techPerson, String techTel, String product, String content,String [] companyUrl,
                            String [] officialIp, String [] testIp){
        try {
            //生成用户code
            String code= UUID.randomUUID().toString().replace("-", "");
            //添加用户
            User user = new User();
            user.setPassword(password);
            user.setEmail(email);
            user.setCode(code);
            if (!RegexUtil.isNull(content)){
                user.setContent(content);
            }
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
    public Map<String,Object> active(String code) {
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userMapper.findUserByCode(code);
            if (user != null) {
                if (user.getStatus() == 1){
                    Date newTime = new Date();
                    long interval = ((newTime.getTime() - user.getCreateTime().getTime())/1000);
                    System.out.println(interval);
                    if (interval <= 600){
                        if (user.getClicks() == 0){
                            userMapper.updateState(user.getId());
                            userMapper.addUserRole(user.getId());
                            map.put("success","激活成功，欢迎登录使用！");
                        }else {
                            map.put("outCancel","激活链接已作废，请重新注册！");
                        }
                    }else {
                     map.put("outDate","激活链接已过期，请重新注册！");
                    }
                }else{
                    map.put("isActive","邮箱已经激活，请登录！");
                }
            }else {
                map.put("noRegister","该邮箱未注册（邮箱地址不存在）！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
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
