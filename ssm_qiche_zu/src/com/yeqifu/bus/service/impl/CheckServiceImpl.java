// 
// 
// 

package com.yeqifu.bus.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.bus.vo.CheckVo;
import com.yeqifu.bus.domain.Car;
import com.yeqifu.bus.domain.Customer;
import com.yeqifu.bus.domain.Rent;
import java.util.HashMap;
import com.yeqifu.sys.utils.WebUtils;
import com.yeqifu.sys.domain.User;
import java.util.Date;
import com.yeqifu.sys.utils.RandomUtils;
import com.yeqifu.bus.domain.Check;
import java.util.Map;
import com.yeqifu.bus.mapper.CarMapper;
import com.yeqifu.bus.mapper.RentMapper;
import com.yeqifu.bus.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.mapper.CheckMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.bus.service.ICheckService;

@Service
public class CheckServiceImpl implements ICheckService
{
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CarMapper carMapper;
    
    @Override
    public Map<String, Object> initCheckFormData(final String rentid) {
        final Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        final Customer customer = this.customerMapper.selectByPrimaryKey(rent.getIdentity());
        final Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        final Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime("JC"));
        check.setRentid(rentid);
        check.setCheckdate(new Date());
        final User user = (User)WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("rent", rent);
        map.put("customer", customer);
        map.put("car", car);
        map.put("check", check);
        return map;
    }
    
    @Override
    public void addCheck(final CheckVo checkVo) {
        this.checkMapper.insertSelective(checkVo);
        final Rent rent = this.rentMapper.selectByPrimaryKey(checkVo.getRentid());
        rent.setRentflag(SysConstast.RENT_BACK_TRUE);
        this.rentMapper.updateByPrimaryKeySelective(rent);
        final Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_FALSE);
        this.carMapper.updateByPrimaryKeySelective(car);
    }
    
    @Override
    public DataGridView queryAllCheck(final CheckVo checkVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)checkVo.getPage(), (int)checkVo.getLimit());
        final List<Check> data = this.checkMapper.queryAllCheck(checkVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void deleteBatchCheck(final String[] ids) {
        for (final String id : ids) {
            this.checkMapper.deleteByPrimaryKey(id);
        }
    }
    
    @Override
    public void deleteCheck(final CheckVo checkVo) {
        this.checkMapper.deleteByPrimaryKey(checkVo.getCheckid());
    }
    
    @Override
    public void updateCheck(final CheckVo checkVo) {
        this.checkMapper.updateByPrimaryKeySelective(checkVo);
    }
}
