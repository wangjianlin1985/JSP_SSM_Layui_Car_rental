// 
// 
// 

package com.yeqifu.stat.service;

import com.yeqifu.stat.domain.BaseEntity;
import java.util.List;

public interface IStatService
{
    List<BaseEntity> loadCustomerAreaStatList();
    
    List<BaseEntity> loadCustomerAreaSexStatList(String p0);
    
    List<BaseEntity> loadOpernameYearGradeStatList(String p0);
    
    List<Double> loadCompanyYearGradeStatList(String p0);
}
