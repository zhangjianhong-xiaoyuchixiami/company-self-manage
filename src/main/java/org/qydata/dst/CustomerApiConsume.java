package org.qydata.dst;

import java.io.Serializable;

/**
 * Created by jonhn on 2017/2/21.
 */
public class CustomerApiConsume implements Serializable {

    private Integer apiTypeId;
    private String apiTypeName;
    private Integer totleAmount;
    private Integer feeAmount;
    private Integer mobileOperatorId;
    private String mobileOperatorName;

    public Integer getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Integer apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public String getApiTypeName() {
        return apiTypeName;
    }

    public void setApiTypeName(String apiTypeName) {
        this.apiTypeName = apiTypeName;
    }

    public Integer getTotleAmount() {
        return totleAmount;
    }

    public void setTotleAmount(Integer totleAmount) {
        this.totleAmount = totleAmount;
    }

    public Integer getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Integer getMobileOperatorId() {
        return mobileOperatorId;
    }

    public void setMobileOperatorId(Integer mobileOperatorId) {
        this.mobileOperatorId = mobileOperatorId;
    }

    public String getMobileOperatorName() {
        return mobileOperatorName;
    }

    public void setMobileOperatorName(String mobileOperatorName) {
        this.mobileOperatorName = mobileOperatorName;
    }
}
