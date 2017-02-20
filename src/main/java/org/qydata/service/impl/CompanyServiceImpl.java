package org.qydata.service.impl;

import org.qydata.entity.CompanyApi;
import org.qydata.mapper.CompanyMapper;
import org.qydata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired private CompanyMapper companyMapper;

    @Override
    public List<CompanyApi> queryApiByCompanyId(Map<String,Object> map) {
        try {
            return companyMapper.queryApiByCompanyId(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
