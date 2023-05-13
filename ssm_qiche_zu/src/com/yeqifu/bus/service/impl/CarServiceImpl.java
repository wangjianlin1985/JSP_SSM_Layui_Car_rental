// 
// 
// 

package com.yeqifu.bus.service.impl;

import com.yeqifu.sys.utils.AppFileUtils;
import com.yeqifu.sys.constast.SysConstast;
import com.yeqifu.bus.domain.Car;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.mapper.CarMapper;
import org.springframework.stereotype.Service;
import com.yeqifu.bus.service.ICarService;

@Service
public class CarServiceImpl implements ICarService
{
    @Autowired
    private CarMapper carMapper;
    
    @Override
    public DataGridView queryAllCar(final CarVo carVo) {
        final Page<Object> page = (Page<Object>)PageHelper.startPage((int)carVo.getPage(), (int)carVo.getLimit());
        final List<Car> data = this.carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(), data);
    }
    
    @Override
    public void addCar(final CarVo carVo) {
        this.carMapper.insertSelective(carVo);
    }
    
    @Override
    public void updateCar(final CarVo carVo) {
        this.carMapper.updateByPrimaryKeySelective(carVo);
    }
    
    @Override
    public void deleteCar(final String carnumber) {
        final Car car = this.carMapper.selectByPrimaryKey(carnumber);
        if (!car.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        this.carMapper.deleteByPrimaryKey(carnumber);
    }
    
    @Override
    public void deleteBatchCar(final String[] carnumbers) {
        for (final String carnumber : carnumbers) {
            this.deleteCar(carnumber);
        }
    }
    
    @Override
    public Car queryCarByCarNumber(final String carnumber) {
        return this.carMapper.selectByPrimaryKey(carnumber);
    }
}
