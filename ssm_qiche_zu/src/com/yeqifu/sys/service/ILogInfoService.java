// 
// 
// 

package com.yeqifu.sys.service;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.vo.LogInfoVo;

public interface ILogInfoService
{
    DataGridView queryAllLogInfo(LogInfoVo p0);
    
    void addLogInfo(LogInfoVo p0);
    
    void deleteLogInfo(Integer p0);
    
    void deleteBatchLogInfo(Integer[] p0);
}
