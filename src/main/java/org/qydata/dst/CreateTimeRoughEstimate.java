package org.qydata.dst;

import java.io.Serializable;

/**
 * Created by jonhn on 2017/2/23.
 */
public class CreateTimeRoughEstimate implements Serializable {

    private String roughEstimateCreateTime;

    public String getRoughEstimateCreateTime() {
        return roughEstimateCreateTime;
    }

    public void setRoughEstimateCreateTime(String roughEstimateCreateTime) {
        this.roughEstimateCreateTime = roughEstimateCreateTime;
    }
}
