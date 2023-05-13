// 
// 
// 

package com.yeqifu.bus.service;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CheckVo;
import java.util.Map;

public interface ICheckService
{
    Map<String, Object> initCheckFormData(String p0);
    
    void addCheck(CheckVo p0);
    
    DataGridView queryAllCheck(CheckVo p0);
    
    void deleteBatchCheck(String[] p0);
    
    void deleteCheck(CheckVo p0);
    
    void updateCheck(CheckVo p0);
}
