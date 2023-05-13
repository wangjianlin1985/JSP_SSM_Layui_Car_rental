// 
// 
// 

package com.yeqifu.bus.controller;

import com.yeqifu.bus.domain.Car;
import com.yeqifu.sys.utils.AppFileUtils;
import com.yeqifu.sys.constast.SysConstast;
import java.util.Date;
import com.yeqifu.sys.utils.ResultObj;
import com.yeqifu.sys.utils.DataGridView;
import com.yeqifu.bus.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.bus.service.ICarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "car" })
public class CarController
{
    @Autowired
    private ICarService carService;
    
    @RequestMapping({ "loadAllCar" })
    public DataGridView loadAllCar(final CarVo carVo) {
        return this.carService.queryAllCar(carVo);
    }
    
    @RequestMapping({ "addCar" })
    public ResultObj addCar(final CarVo carVo) {
        try {
            carVo.setCreatetime(new Date());
            if (!carVo.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
                final String filePath = AppFileUtils.updateFileName(carVo.getCarimg(), "_temp");
                carVo.setCarimg(filePath);
            }
            this.carService.addCar(carVo);
            return ResultObj.ADD_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping({ "updateCar" })
    public ResultObj updateCar(final CarVo carVo) {
        try {
            final String carimg = carVo.getCarimg();
            if (carimg.endsWith("_temp")) {
                final String filePath = AppFileUtils.updateFileName(carVo.getCarimg(), "_temp");
                carVo.setCarimg(filePath);
                final Car car = this.carService.queryCarByCarNumber(carVo.getCarnumber());
                AppFileUtils.removeFileByPath(car.getCarimg());
            }
            this.carService.updateCar(carVo);
            return ResultObj.UPDATE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteCar" })
    public ResultObj deleteCar(final CarVo carVo) {
        try {
            this.carService.deleteCar(carVo.getCarnumber());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping({ "deleteBatchCar" })
    public ResultObj deleteBatchCar(final CarVo carVo) {
        try {
            this.carService.deleteBatchCar(carVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
