package org.qydata.service.impl;

import org.qydata.entity.Customer;
import org.qydata.mapper.CustomerMapper;
import org.qydata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
}
