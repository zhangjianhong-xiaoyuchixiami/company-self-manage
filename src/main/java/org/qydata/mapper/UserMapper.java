package org.qydata.mapper;

import org.qydata.entity.User;

import java.util.Set;

/**
 * Created by jonhn on 2017/2/15.
 */
public interface UserMapper {

    /**
     * 根据登录用户名查找是否有指定用户
     * @param username
     * @return
     */
    public User findById(String username) throws Exception;

    /**
     * 根据登录用户名匹配角色
     * @param id
     * @return
     */
    public Set<String> findAllRoleByUser(Integer id) throws Exception;

    /**
     * 根据登录用户名匹配权限
     * @param id
     * @return
     */
    public Set<String> findAllActionByUser(Integer id)throws Exception ;

    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    public Boolean addUser(User user)throws Exception;

    /**
     *根据激活码查找用户
     * @param code
     * @return
     * @throws Exception
     */
    public String findUsernameByCode(String code)throws Exception;

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     * @throws Exception
     */
    public User findUserByCode(String code)throws Exception;

    /**
     * 激活用户
     * @param username
     * @return
     * @throws Exception
     */
    public Boolean updateState(String username)throws Exception;

    /**
     * 根据激活码删除未激活的用户
     * @param code
     * @return
     * @throws Exception
     */
    public Boolean deleteUserByCode(String code)throws Exception;

    /**
     * 用户找回密码
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    public boolean updatePassword(String email,String password)throws Exception;

    /**
     * 根据用户名或邮箱查找用户
     * @param username
     * @return
     */
    public User queryUserByUsername(String username)throws Exception;

    /**
     * 修改登录密码
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean updateLoginPassword(String username,String password)throws Exception;

    /**
     * 分配角色
     * @param id
     * @return
     * @throws Exception
     */
    public boolean addUserRole(Integer id)throws Exception;


}
