// 
// 
// 

package com.yeqifu.bus.service;

import java.util.List;
import com.yeqifu.bus.domain.Customer;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CustomerVo;

public interface ICustomerService
{
    DataGridView queryAllCustomer(CustomerVo p0);
    
    void addCustomer(CustomerVo p0);
    
    void updateCustomer(CustomerVo p0);
    
    void deleteCustomer(String p0);
    
    void deleteBatchCustomer(String[] p0);
    
    Customer queryCustomerByIdentity(String p0);
    
    List<Customer> queryAllCustomerForList(CustomerVo p0);
}
