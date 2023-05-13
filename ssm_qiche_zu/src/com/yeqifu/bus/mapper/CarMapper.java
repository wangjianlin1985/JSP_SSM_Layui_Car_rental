// 
// 
// 

package com.yeqifu.bus.mapper;

import java.util.List;
import com.yeqifu.bus.vo.CarVo;
import com.yeqifu.bus.domain.Car;

public interface CarMapper
{
    int deleteByPrimaryKey(String p0);
    
    int insert(Car p0);
    
    int insertSelective(Car p0);
    
    Car selectByPrimaryKey(String p0);
    
    int updateByPrimaryKeySelective(Car p0);
    
    int updateByPrimaryKey(Car p0);
    
    List<Car> queryAllCar(CarVo p0);
}
