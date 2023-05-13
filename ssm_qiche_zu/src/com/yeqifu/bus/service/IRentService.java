// 
// 
// 

package com.yeqifu.bus.service;

import com.yeqifu.bus.domain.Rent;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.RentVo;

public interface IRentService
{
    void addRent(RentVo p0);
    
    DataGridView queryAllRent(RentVo p0);
    
    void updateRent(RentVo p0);
    
    void deleteRent(String p0);
    
    Rent queryRentByRentId(String p0);
}
