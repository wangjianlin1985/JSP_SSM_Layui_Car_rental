// 
// 
// 

package com.yeqifu.bus.controller;

import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.sys.utils.WebUtils;
import com.yeqifu.sys.domain.User;
import java.util.Date;
import com.yeqifu.sys.utils.RandomUtils;
import com.yeqifu.bus.domain.Customer;
import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.bus.vo.RentVo;
import com.yeqifu.bus.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.service.IRentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "rent" })
public class RentController
{
    @Autowired
    private IRentService rentService;
    @Autowired
    private ICustomerService customerService;
    
    @RequestMapping({ "checkCustomerExist" })
    public ResultObj checkCustomerExist(final RentVo rentVo) {
        final Customer customer = this.customerService.queryCustomerByIdentity(rentVo.getIdentity());
        if (customer != null) {
            return ResultObj.STATUS_TRUE;
        }
        return ResultObj.STATUS_FALSE;
    }
    
    @RequestMapping({ "initRentFrom" })
    public RentVo initRentFrom(final RentVo rentVo) {
        rentVo.setRentid(RandomUtils.createRandomStringUseTime("CZ"));
        rentVo.setBegindate(new Date());
        final User user = (User)WebUtils.getHttpSession().getAttribute("user");
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }
    
    @RequestMapping({ "saveRent" })
    public ResultObj saveRent(final RentVo rentVo) {
        try {
            rentVo.setCreatetime(new Date());
            rentVo.setRentflag(SysConstast.RENT_BACK_FALSE);
            this.rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "deleteRent" })
    public ResultObj deleteRent(final RentVo rentVo) {
        try {
            this.rentService.deleteRent(rentVo.getRentid());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "updateRent" })
    public ResultObj updateRent(final RentVo rentVo) {
        try {
            this.rentService.updateRent(rentVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "loadAllRent" })
    public DataGridView loadAllRent(final RentVo rentVo) {
        return this.rentService.queryAllRent(rentVo);
    }
}
