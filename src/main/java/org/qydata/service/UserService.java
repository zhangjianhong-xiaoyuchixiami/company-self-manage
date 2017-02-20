package org.qydata.service;

import org.qydata.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by jonhn on 2017/2/15.
 */
public interface UserService {

    /**
     * 此方法是留给Realm进行用户认证使用的，目的是根据用户名取得密码数据
     * @param username
     * @return
     * @throws Exception
     */
    public User get(String username) throws Exception ;
    /**
     * 此方法是留给Realm实现授权处理的，主要要根据用户ID查询出所有的角色以及所有对应权限
     * @param username
     * @return 返回的数据包含有两个内容：<br>
     * <li>key = allRoles、value = 所有的用户角色；</li>
     * <li>key = allActions、value = 所有的用户权限。</li>
     * @throws Exception
     */
    public Map<String,Object> listAuthByUser(String username) throws Exception ;

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @return 是否注册成功
     */
    @Transactional
    public Boolean register(String username,String password,String email);

    /**
     * 激活用户
     * @param code 用户激活码
     * @return 是否激活成功
     */
    @Transactional
    public Boolean active(String code);

    /**
     * 根据激活码删除未激活的用户
     * @param code
     * @return
     */
    @Transactional
    public Boolean deleteUserByCode(String code);

    /**
     * 用户找回密码
     * @param email
     * @param password
     * @return
     */
    public boolean forgot(String email,String password);

    /**
     * 用户找回密码
     * @param email
     * @param password
     * @return
     */
    public boolean updatePassword(String email,String password);

    /**
     * 根据用户名或邮箱查找用户
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

}
