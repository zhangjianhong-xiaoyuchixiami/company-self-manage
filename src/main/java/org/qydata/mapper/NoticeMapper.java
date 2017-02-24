package org.qydata.mapper;

import org.qydata.entity.UserNotice;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/23.
 */
public interface NoticeMapper {

    /**
     * 统计用户-系统未读消息数
     * @return
     * @throws Exception
     */
    public int getCountUnReadNotice(Map<String,Object> map)throws Exception;

    /**
     * 查询用户-系统未读消息
     * @param map
     * @return
     * @throws Exception
     */
    public List<UserNotice> queryUserUnReadNotice(Map<String,Object> map) throws Exception;

    /**
     * 根据Id查询用户-系统消息
     * @param map
     * @return
     * @throws Exception
     */
    public UserNotice queryUserNoticeById(Map<String,Object> map) throws Exception;

    /**
     * 设置消息为已读状态
     * @param id
     * @return
     * @throws Exception
     */
    public boolean updateActive(Integer id,Integer isActive)throws Exception;

    /**
     * 查询用户-系统消息
     * @param map
     * @return
     * @throws Exception
     */
    public List<UserNotice> queryUserNotice(Map<String,Object> map) throws Exception;

}
