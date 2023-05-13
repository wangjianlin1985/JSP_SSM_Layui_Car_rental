// 
// 
// 

package com.yeqifu.stat.service.impl;

import com.yeqifu.stat.domain.BaseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.stat.mapper.StatMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.stat.service.IStatService;

@Service
public class StatServiceImpl implements IStatService
{
    @Autowired
    private StatMapper statMapper;
    
    @Override
    public List<BaseEntity> loadCustomerAreaStatList() {
        return this.statMapper.queryCustomerAreaStat();
    }
    
    @Override
    public List<BaseEntity> loadCustomerAreaSexStatList(final String area) {
        return this.statMapper.queryCustomerAreaSexStat(area);
    }
    
    @Override
    public List<BaseEntity> loadOpernameYearGradeStatList(final String year) {
        return this.statMapper.queryOpernameYearGradeStat(year);
    }
    
    @Override
    public List<Double> loadCompanyYearGradeStatList(final String year) {
        return this.statMapper.queryCompanyYearGradeStat(year);
    }
}
