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
}
