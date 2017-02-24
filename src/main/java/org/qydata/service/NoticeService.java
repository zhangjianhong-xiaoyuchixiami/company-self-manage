package org.qydata.service;

import org.qydata.entity.UserNotice;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/23.
 */
public interface NoticeService {

    /**
     * 统计用户系统未读消息数
     * @param map
     * @return
     */
    public int getCountUnReadNotice(Map<String,Object> map);

    /**
     * 查询用户-系统未读消息
     * @param map
     * @return
     */
    public List<UserNotice> queryUserUnReadNotice(Map<String,Object> map);

    /**
     * 根据Id查询用户-系统消息
     * @param map
     * @return
     */
    public UserNotice queryUserNoticeById(Map<String,Object> map);

    /**
     * 设置消息为已读状态
     * @param id
     * @return
     */
    public boolean updateActive(Integer id,Integer isActive);

    /**
     * 查询用户-系统未读消息
     * @param map
     * @return
     */
    public List<UserNotice> queryUserNotice(Map<String,Object> map);

}
