// 
// 
// 

package com.yeqifu.bus.service.impl;

import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.bus.domain.Car;
import com.yeqifu.bus.domain.Rent;
import com.yeqifu.bus.vo.RentVo;
import com.yeqifu.bus.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.mapper.RentMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.bus.service.IRentService;

@Service
public class RentServiceImpl implements IRentService
{
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CarMapper carMapper;
    
    @Override
    public void addRent(final RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        final Car car = new Car();
        car.setCarnumber(rentVo.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_TRUE);
        this.carMapper.updateByPrimaryKeySelective(car);
    }
    
    @Override
    public DataGridView queryAllRent(final RentVo rentVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)rentVo.getPage(), (int)rentVo.getLimit());
        final List<Rent> data = this.rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void updateRent(final RentVo rentVo) {
        this.rentMapper.updateByPrimaryKeySelective(rentVo);
    }
    
    @Override
    public void deleteRent(final String rentid) {
        final Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        final Car car = new Car();
        car.setCarnumber(rent.getCarnumber());
        car.setIsrenting(SysConstast.RENT_CAR_FALSE);
        this.carMapper.updateByPrimaryKeySelective(car);
        this.rentMapper.deleteByPrimaryKey(rentid);
    }
    
    @Override
    public Rent queryRentByRentId(final String rentid) {
        return this.rentMapper.selectByPrimaryKey(rentid);
    }
}
