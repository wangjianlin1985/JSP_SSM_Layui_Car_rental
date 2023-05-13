// 
// 
// 

package com.yeqifu.stat.mapper;

import com.yeqifu.stat.domain.BaseEntity;
import java.util.List;

public interface StatMapper
{
    List<BaseEntity> queryCustomerAreaStat();
    
    List<BaseEntity> queryCustomerAreaSexStat(String p0);
    
    List<BaseEntity> queryOpernameYearGradeStat(String p0);
    
    List<Double> queryCompanyYearGradeStat(String p0);
}
