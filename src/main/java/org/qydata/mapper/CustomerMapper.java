package org.qydata.mapper;

import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.*;

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
     * 统计客户的消费明细记录总数
     * @param map
     * @return
     * @throws Exception
     */
    public Integer getAllCountCustomerConsumeDetailRecordByCustomerId(Map<String,Object> map)throws Exception;

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
     * 根据账号Id查找Ip用于账号信页面显示Ip范围
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

    /**
     * 根据userId查找客户Id对应的公司名称用于title
     * @param userId
     * @return
     */
    public String findCompanyNameByUserId(Integer userId);

    /**
     * 根据customerId查询上月消费账单
     * @param map
     * @return
     */
    public CustomerConsumeExcel queryCustomerConsumeExcelByCustomerId(Map<String,Object> map);

    /**
     * 根据customerId查找公司名称用于下载账单给文件命名
     * @param map
     * @return
     */
    public String queryCompanyNameByCustomerId(Map<String,Object> map);

    /**
     * 根据customerId查询消费账单用于用户选择下载的文件
     * @return
     */
    public List<CustomerConsumeExcel> queryCustomerConsumeExcelConsuTimeByCustomerId(Integer customerId);

    /**
     * 根据客户apiType用于财务页面产品类型选择select
     * @param userId
     * @return
     */
    public List<CompanyApi> queryCompanyApiTypeByCompanyId(Integer userId);
}
