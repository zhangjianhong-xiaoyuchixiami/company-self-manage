package org.qydata.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonhn on 2017/5/8.
 */
public class CompanyApiTypeConsumeDayCount implements Serializable {

    private Integer id;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer customerId;
    private Integer apiTypeId;
    private Integer stid;
    private Integer sumAmount;
    private Integer countTotle;
    private Integer countSuccess;
    private Date consuTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Integer apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Integer sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Integer getCountTotle() {
        return countTotle;
    }

    public void setCountTotle(Integer countTotle) {
        this.countTotle = countTotle;
    }

    public Integer getCountSuccess() {
        return countSuccess;
    }

    public void setCountSuccess(Integer countSuccess) {
        this.countSuccess = countSuccess;
    }

    public Date getConsuTime() {
        return consuTime;
    }

    public void setConsuTime(Date consuTime) {
        this.consuTime = consuTime;
    }
}
