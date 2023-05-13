// 
// 
// 

package com.yeqifu.bus.controller;

import java.util.Date;
import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.service.ICustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "customer" })
public class CustomerController
{
    @Autowired
    private ICustomerService customerService;
    
    @RequestMapping({ "loadAllCustomer" })
    public DataGridView loadAllCustomer(final CustomerVo customerVo) {
        return this.customerService.queryAllCustomer(customerVo);
    }
    
    @RequestMapping({ "addCustomer" })
    public ResultObj addCustomer(final CustomerVo customerVo) {
        try {
            customerVo.setCreatetime(new Date());
            this.customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "updateCustomer" })
    public ResultObj updateCustomer(final CustomerVo customerVo) {
        try {
            this.customerService.updateCustomer(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteCustomer" })
    public ResultObj deleteCustomer(final CustomerVo customerVo) {
        try {
            this.customerService.deleteCustomer(customerVo.getIdentity());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchCustomer" })
    public ResultObj deleteBatchCustomer(final CustomerVo customerVo) {
        try {
            this.customerService.deleteBatchCustomer(customerVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
