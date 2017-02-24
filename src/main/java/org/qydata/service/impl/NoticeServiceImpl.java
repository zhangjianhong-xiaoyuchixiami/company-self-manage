package org.qydata.service.impl;

import org.qydata.dst.CreateTimeRoughEstimate;
import org.qydata.entity.PublicNotice;
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
            if (userNoticeList != null) {
                List<UserNotice> userNoticeRoughList = new ArrayList<>();
                for (int i = 0; i < userNoticeList.size(); i++) {
                    UserNotice userNoticeRough = new UserNotice();
                    PublicNotice notice = new PublicNotice();
                    CreateTimeRoughEstimate estimate = new CreateTimeRoughEstimate();
                    UserNotice userNotice = userNoticeList.get(i);
                    userNoticeRough.setId(userNotice.getId());
                    notice.setTitle(userNotice.getNotice().getTitle());
                    notice.setContent(userNotice.getNotice().getContent());
                    userNoticeRough.setNotice(notice);
                    if(CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) <=2){
                        estimate.setRoughEstimateCreateTime("刚刚");
                    }
                    if(CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) >2 && CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) <=24){
                        estimate.setRoughEstimateCreateTime("两小时以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) >24 && CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) <=168){
                        estimate.setRoughEstimateCreateTime("一天以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) >168 && CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) <=720){
                        estimate.setRoughEstimateCreateTime("一周以前");
                    }
                    if(CalendarTools.daysBetween(sdf.format(userNotice.getCreateTime()),sdf.format(new Date())) >720){
                        estimate.setRoughEstimateCreateTime("一月以前");
                    }
                    userNoticeRough.setEstimate(estimate);
                    userNoticeRoughList.add(userNoticeRough);
                }
                return userNoticeRoughList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserNotice queryUserNoticeById(Map<String, Object> map) {
        try {
            return noticeMapper.queryUserNoticeById(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateActive(Integer id,Integer isActive) {
        try {
            return noticeMapper.updateActive(id,isActive);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserNotice> queryUserNotice(Map<String, Object> map) {
        try {
            return noticeMapper.queryUserNotice(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
