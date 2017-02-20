package org.qydata.service;

import org.qydata.entity.CompanyApi;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
public interface CompanyService {

    /**
     * 根据公司Id查找所购买产品
     * @return
     */
    public List<CompanyApi> queryApiByCompanyId(Map<String,Object> map);
}
