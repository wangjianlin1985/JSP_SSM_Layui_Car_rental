// 
// 
// 

package com.yeqifu.bus.mapper;

import java.util.List;
import com.yeqifu.bus.domain.Rent;

public interface RentMapper
{
    int deleteByPrimaryKey(String p0);
    
    int insert(Rent p0);
    
    int insertSelective(Rent p0);
    
    Rent selectByPrimaryKey(String p0);
    
    int updateByPrimaryKeySelective(Rent p0);
    
    int updateByPrimaryKey(Rent p0);
    
    List<Rent> queryAllRent(Rent p0);
}
