package org.qydata.service.impl;

import org.apache.commons.collections.map.HashedMap;
import org.qydata.dst.CustomerApiConsume;
import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceLog;
import org.qydata.entity.WeekMonthAmount;
import org.qydata.mapper.CustomerMapper;
import org.qydata.service.CustomerService;
import org.qydata.tools.CalendarTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by jonhn on 2017/2/20.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerMapper customerMapper;

    @Override
    public List<Customer> queryCustomerByAuthId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerByAuthId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findCustomerByAuthId(String authId) {
        return customerMapper.findCustomerByAuthId(authId);
    }

    @Override
    public Customer findCustomerByAuthIdAndAuthPass(String authId, String authPass) {
        return customerMapper.findCustomerByAuthIdAndAuthPass(authId,authPass);
    }

    @Override
    public boolean addUserCustomer(Map<String, Object> map) {
        try {
            return customerMapper.addUserCustomer(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer queryCompanyIdByUserId(Integer userId) {
        try {
            return customerMapper.queryCompanyIdByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerBalanceLog> queryCustomerRechargeRecordByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerRechargeRecordByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerApiConsume> queryCustomerConsumeRecordByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerConsumeRecordByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerBalanceLog> queryCustomerConsumeDetailRecordByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerConsumeDetailRecordByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> queryCustomerMonthsByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerMonthsByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Integer> queryCustomerYearsByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerYearsByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WeekMonthAmount> queryCustomerWeekMonthRecordByCustomerId(Map<String, Object> map) {
        try {
            return customerMapper.queryCustomerWeekMonthRecordByCustomerId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, List> monthChargeConsumeToward(Map<String, Object> map) {
        Set<Map.Entry<String,Object>> set = map.entrySet();
        Iterator<Map.Entry<String,Object>> it = set.iterator();
        Integer customerId = null;
        Integer tableId = null;
        Integer result = null;
        while(it.hasNext()){
            Map.Entry<String,Object> me = it.next();
            if(me.getKey().equals("customerId")){
                customerId = (Integer)me.getValue();
            }
            if(me.getKey().equals("tableId") ){
                tableId = (Integer)me.getValue();
            }
            if(me.getKey().equals("result") ){
                result = (Integer)me.getValue();
            }
        }
        List<Long> yList = new ArrayList<>();
        List<String> xList = new ArrayList<>();
        Map<String, List> stringListMap = new HashedMap();

        for (int i = 12; i >0; i--) {
            WeekMonthAmount weekMonthAmount = customerMapper.queryMonthChargeConsumeToward(customerId, tableId, (result+i));

            if (weekMonthAmount != null) {
                if (weekMonthAmount.getTotleAmount()>0){
                    yList.add((weekMonthAmount.getTotleAmount()/100));
                }else{
                    yList.add(-(weekMonthAmount.getTotleAmount()/100));
                }
                xList.add(weekMonthAmount.getYears() + "年" + weekMonthAmount.getMonths() + "月");
            } else {
                yList.add(0L);
                xList.add(CalendarTools.getYearMonthCount(result+i) + "年" + CalendarTools.getMonthCount(result+i) + "月");
            }
        }
        stringListMap.put("xPort",xList);
        stringListMap.put("type",yList);
        return stringListMap;
    }
}
