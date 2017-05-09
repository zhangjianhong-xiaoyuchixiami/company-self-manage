package org.qydata.service;

import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
public interface CustomerService {

    /**
     * 根据账号Id查找账号
     * @param map
     * @return
     */
    public List<Customer> queryCustomerByAuthId(Map<String,Object> map);

    /**
     * 根据authId查找客户信息
     * @param authId 要查找客户的authId
     * @return 如果有数据，则数据以Customer对象的形式返回，如果没有返回空；
     */
    public Customer findCustomerByAuthId(String authId);

    /**
     * 根据用户名和密码查找账号
     * @param authId
     * @param authPass
     * @return
     */
    public Customer findCustomerByAuthIdAndAuthPass(String authId,String authPass);

    /**
     * 添加账号和用户映射
     * @param map
     * @return
     */
    @Transactional
    public boolean addUserCustomer(Map<String,Object> map);

    /**
     * 根据用户Id查找公司Id
     * @param userId
     * @return
     * @throws
     */
    public Integer queryCompanyIdByUserId(Integer userId);

    /**
     * 指定账号余额变动记录
     * @param map
     * @return
     */
    public List<CustomerBalanceLog> queryCustomerRechargeRecordByCustomerId(Map<String,Object> map);

    /**
     * 查询客户的消费记录
     * @param map
     * @return
     */
    public List<CustomerApiConsume> queryCustomerConsumeRecordByCustomerId(Map<String,Object> map);

    /**
     * 查询客户的消费明细记录
     * @param map
     * @return
     */
    public Map<String,Object> queryCustomerConsumeDetailRecordByCustomerId(Map<String,Object> map);

    /**
     * 查询客户的月记录月级联菜单
     * @param map
     * @return
     */
    public List<Integer> queryCustomerMonthsByCustomerId(Map<String,Object> map);

    /**
     * 查询客户的月记录年级联菜单
     * @param map
     * @return
     */
    public List<Integer> queryCustomerYearsByCustomerId(Map<String,Object> map);

    /**
     * 查询客户的周月记录
     * @param map
     * @return
     */
    public List<WeekMonthAmount> queryCustomerWeekMonthRecordByCustomerId(Map<String,Object> map);

    /**
     * 月账单走势
     * @param map
     * @return
     */
    public Map<String,List> monthChargeConsumeToward(Map<String,Object> map);

    /**
     * 根据账号Id查找Ip
     * @param customerId
     * @return
     */
    public List<CustomerIp> queryCustomerIpById(Integer customerId);

    /**
     * 根据userId查找客户账号Id用于财务账单
     * @param userId
     * @return
     */
    public List<Customer> findCustomerIdByUserId(Integer userId);

    /**
     * 根据条件查询客户apiType按天消费情况
     * @param map
     * @return
     */
    public List<CompanyApiTypeConsumeDayCount> queryCustomerApiTypeConsumeDayCount(Map<String,Object> map);

}
