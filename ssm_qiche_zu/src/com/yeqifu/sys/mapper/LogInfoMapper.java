// 
// 
// 

package com.yeqifu.sys.mapper;

import java.util.List;
import com.yeqifu.sys.domain.LogInfo;

public interface LogInfoMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(LogInfo p0);
    
    int insertSelective(LogInfo p0);
    
    LogInfo selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(LogInfo p0);
    
    int updateByPrimaryKey(LogInfo p0);
    
    List<LogInfo> queryAllLogInfo(LogInfo p0);
}
