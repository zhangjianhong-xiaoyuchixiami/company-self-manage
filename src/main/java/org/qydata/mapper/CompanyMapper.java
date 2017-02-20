package org.qydata.mapper;

import org.qydata.entity.CompanyApi;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/2/20.
 */
public interface CompanyMapper {

    /**
     * 根据公司Id查找所购买产品
     * @return
     * @throws Exception
     */
    public List<CompanyApi> queryApiByCompanyId(Map<String,Object> map)throws Exception;
}
