// 
// 
// 

package com.yeqifu.bus.service;

import com.yeqifu.bus.domain.Car;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CarVo;

public interface ICarService
{
    DataGridView queryAllCar(CarVo p0);
    
    void addCar(CarVo p0);
    
    void updateCar(CarVo p0);
    
    void deleteCar(String p0);
    
    void deleteBatchCar(String[] p0);
    
    Car queryCarByCarNumber(String p0);
}
