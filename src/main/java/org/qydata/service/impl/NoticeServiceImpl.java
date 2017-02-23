package org.qydata.service.impl;

import org.qydata.entity.UserNotice;
import org.qydata.mapper.NoticeMapper;
import org.qydata.service.NoticeService;
import org.qydata.tools.CalendarTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/23.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired  private NoticeMapper noticeMapper;

    @Override
    public int getCountUnReadNotice(Map<String, Object> map) {
        try {
            return noticeMapper.getCountUnReadNotice(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<UserNotice> queryUserUnReadNotice(Map<String, Object> map) {
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");
            List<UserNotice> userNoticeList = noticeMapper.queryUserUnReadNotice(map);
            List<UserNotice> userNoticeRoughList = new ArrayList<>();
            if (userNoticeList != null) {
                UserNotice userNoticeRough = new UserNotice();
                for (int i = 0; i < userNoticeList.size(); i++) {
                    UserNotice userNotice = userNoticeList.get(i);
                    userNoticeRough.setId(userNotice.getId());
                    userNoticeRough.getNotice().setTitle(userNotice.getNotice().getTitle());
                    userNoticeRough.getNotice().setTitle(userNotice.getNotice().getContent());
                    if(CalendarTools.daysBetween(sdf.format(new Date()),sdf.format(userNotice.getCreateTime())) <=0){
                        userNoticeRough.getEstimate().setRoughEstimateCreateTime("刚刚");
                    }
                    if(CalendarTools.daysBetween(sdf.format(new Date()),sdf.format(userNotice.getCreateTime())) <=2){
                        userNoticeRough.getEstimate().setRoughEstimateCreateTime("两小时以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(new Date()),sdf.format(userNotice.getCreateTime())) <=24){
                        userNoticeRough.getEstimate().setRoughEstimateCreateTime("两天以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(new Date()),sdf.format(userNotice.getCreateTime())) <=168){
                        userNoticeRough.getEstimate().setRoughEstimateCreateTime("一周以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(new Date()),sdf.format(userNotice.getCreateTime())) <=720){
                        userNoticeRough.getEstimate().setRoughEstimateCreateTime("一月以前");
                    }
                    userNoticeRoughList.add(userNoticeRough);
                }
                return userNoticeRoughList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
