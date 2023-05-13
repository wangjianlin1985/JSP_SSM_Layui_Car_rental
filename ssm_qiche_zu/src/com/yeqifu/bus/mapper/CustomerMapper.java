// 
// 
// 

package com.yeqifu.bus.mapper;

import java.util.List;
import com.yeqifu.bus.domain.Customer;

public interface CustomerMapper
{
    int deleteByPrimaryKey(String p0);
    
    int insert(Customer p0);
    
    int insertSelective(Customer p0);
    
    Customer selectByPrimaryKey(String p0);
    
    int updateByPrimaryKeySelective(Customer p0);
    
    int updateByPrimaryKey(Customer p0);
    
    List<Customer> queryAllCustomer(Customer p0);
}
