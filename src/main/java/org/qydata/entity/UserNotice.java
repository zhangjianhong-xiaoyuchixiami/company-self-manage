package org.qydata.entity;

import org.qydata.dst.CreateTimeRoughEstimate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jonhn on 2017/2/23.
 */
public class UserNotice implements Serializable {

    private Integer id;
    private Integer noticeId;
    private Integer userId;
    private Integer isActive;
    private Timestamp createTime;
    private Timestamp timestamp;
    private PublicNotice notice;
    private NoticeStatus noticeStatus;
    private CreateTimeRoughEstimate estimate;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public PublicNotice getNotice() {
        return notice;
    }

    public void setNotice(PublicNotice notice) {
        this.notice = notice;
    }

    public CreateTimeRoughEstimate getEstimate() {
        return estimate;
    }

    public void setEstimate(CreateTimeRoughEstimate estimate) {
        this.estimate = estimate;
    }

    public NoticeStatus getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(NoticeStatus noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}
