package org.qydata.mapper;

import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceLog;
import org.qydata.entity.CustomerIp;
import org.qydata.entity.WeekMonthAmount;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
public interface CustomerMapper {

    /**
     * 根据账号Id查找账号
     * @param map
     * @return
     * @throws Exception
     */
    public List<Customer> queryCustomerByAuthId(Map<String,Object> map)throws Exception;

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
    public Customer  findCustomerByAuthIdAndAuthPass(String authId,String authPass);

    /**
     * 添加账号和用户映射
     * @param map
     * @return
     * @throws Exception
     */
    public boolean addUserCustomer(Map<String,Object> map)throws Exception;

    /**
     * 根据用户Id查找公司Id
     * @param userId
     * @return
     * @throws Exception
     */
    public Integer queryCompanyIdByUserId(Integer userId)throws Exception;

    /**
     * 查询客户的充值记录
     * @param map
     * @return
     * @throws Exception
     */
    public List<CustomerBalanceLog> queryCustomerRechargeRecordByCustomerId(Map<String,Object> map)throws Exception;


    /**
     * 查询客户的消费记录
     * @param map
     * @return
     * @throws Exception
     */
    public List<CustomerApiConsume> queryCustomerConsumeRecordByCustomerId(Map<String,Object> map)throws Exception;

    /**
     * 查询客户的消费明细记录
     * @param map
     * @return
     * @throws Exception
     */
    public List<CustomerBalanceLog> queryCustomerConsumeDetailRecordByCustomerId(Map<String,Object> map)throws Exception;

    /**
     * 查询客户的周月记录
     * @param map
     * @return
     * @throws Exception
     */
    public List<WeekMonthAmount> queryCustomerWeekMonthRecordByCustomerId(Map<String,Object> map)throws Exception;

    /**
     * 查询客户的周月记录年级联菜单
     * @param map
     * @return
     * @throws Exception
     */
    public List<Integer> queryCustomerYearsByCustomerId(Map<String,Object> map) throws Exception;

    /**
     * 查询客户的周月记录月级联菜单
     * @param map
     * @return
     * @throws Exception
     */
    public List<Integer> queryCustomerMonthsByCustomerId(Map<String,Object> map) throws Exception;

    /**
     * 月账单走势
     * @param customerId
     * @param tableId
     * @param result
     * @return
     */
    public WeekMonthAmount queryMonthChargeConsumeToward(Integer customerId, Integer tableId, Integer result);

    /**
     * 根据账号Id查找Ip
     * @param customerId
     * @return
     */
    public List<CustomerIp> queryCustomerIpById(Integer customerId);

}
