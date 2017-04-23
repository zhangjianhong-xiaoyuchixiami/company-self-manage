package org.qydata.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by jonhn on 2017/2/20.
 */
public class Customer implements Serializable {

    private Integer id;
    private Integer typeId;
    private Integer marketId;
    private String name;
    private String authId;
    private String authPass;
    private Integer balance;
    private Integer floor;         //信用额度
    private Integer usableFloor;   //可用信用额度
    private Integer surplusFloor;  //剩余信用额度
    private Timestamp createTime;
    private Timestamp timestamp;
    private Integer status;
    private Integer companyId;
    private CustomerStatus customerStatus;
    private CustomerType customerType;
    private CustomerCompany customerCompany;
    private User user;
    private List<CustomerIp> customerIpList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthPass() {
        return authPass;
    }

    public void setAuthPass(String authPass) {
        this.authPass = authPass;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getUsableFloor() {
        return usableFloor;
    }

    public void setUsableFloor(Integer usableFloor) {
        this.usableFloor = usableFloor;
    }

    public Integer getSurplusFloor() {
        return surplusFloor;
    }

    public void setSurplusFloor(Integer surplusFloor) {
        this.surplusFloor = surplusFloor;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerCompany getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(CustomerCompany customerCompany) {
        this.customerCompany = customerCompany;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CustomerIp> getCustomerIpList() {
        return customerIpList;
    }

    public void setCustomerIpList(List<CustomerIp> customerIpList) {
        this.customerIpList = customerIpList;
    }
}
