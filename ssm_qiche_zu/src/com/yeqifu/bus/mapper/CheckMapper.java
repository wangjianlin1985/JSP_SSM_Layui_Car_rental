// 
// 
// 

package com.yeqifu.bus.mapper;

import java.util.List;
import com.yeqifu.bus.domain.Check;

public interface CheckMapper
{
    int deleteByPrimaryKey(String p0);
    
    int insert(Check p0);
    
    int insertSelective(Check p0);
    
    Check selectByPrimaryKey(String p0);
    
    int updateByPrimaryKeySelective(Check p0);
    
    int updateByPrimaryKey(Check p0);
    
    List<Check> queryAllCheck(Check p0);
}
