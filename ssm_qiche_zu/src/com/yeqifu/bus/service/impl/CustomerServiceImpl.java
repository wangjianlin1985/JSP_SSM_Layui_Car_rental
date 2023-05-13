// 
// 
// 

package com.yeqifu.bus.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import com.yeqifu.bus.domain.Customer;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.bus.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService
{
    @Autowired
    private CustomerMapper customerMapper;
    
    @Override
    public DataGridView queryAllCustomer(final CustomerVo customerVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)customerVo.getPage(), (int)customerVo.getLimit());
        final List<Customer> data = this.customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addCustomer(final CustomerVo customerVo) {
        this.customerMapper.insertSelective(customerVo);
    }
    
    @Override
    public void updateCustomer(final CustomerVo customerVo) {
        this.customerMapper.updateByPrimaryKeySelective(customerVo);
    }
    
    @Override
    public void deleteCustomer(final String identity) {
        this.customerMapper.deleteByPrimaryKey(identity);
    }
    
    @Override
    public void deleteBatchCustomer(final String[] identitys) {
        for (final String identity : identitys) {
            this.deleteCustomer(identity);
        }
    }
    
    @Override
    public Customer queryCustomerByIdentity(final String identity) {
        return this.customerMapper.selectByPrimaryKey(identity);
    }
    
    @Override
    public List<Customer> queryAllCustomerForList(final CustomerVo customerVo) {
        return this.customerMapper.queryAllCustomer(customerVo);
    }
}
