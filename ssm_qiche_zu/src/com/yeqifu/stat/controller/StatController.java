// 
// 
// 

package com.yeqifu.stat.controller;

import com.yeqifu.bus.domain.Rent;
import com.yeqifu.stat.utils.ExportRentUtils;
import java.io.ByteArrayOutputStream;
import com.yeqifu.bus.domain.Customer;
import java.io.UnsupportedEncodingException;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import java.net.URLEncoder;
import com.yeqifu.stat.utils.ExportCustomerUtils;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletResponse;
import com.yeqifu.bus.vo.CustomerVo;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yeqifu.stat.domain.BaseEntity;
import java.util.List;
import com.yeqifu.bus.service.IRentService;
import com.yeqifu.bus.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yeqifu.stat.service.IStatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "stat" })
@Controller
public class StatController
{
    @Autowired
    private IStatService statService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IRentService rentService;
    
    @RequestMapping({ "toCustomerAreaStat" })
    public String toCustomerAreaStat() {
        return "stat/customerAreaStat";
    }
    
    @RequestMapping({ "loadCustomerAreaStatJson" })
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaStatJson() {
        return this.statService.loadCustomerAreaStatList();
    }
    
    @RequestMapping({ "toCustomerAreaSexStat" })
    public String toCustomerAreaSexStat() {
        return "stat/customerAreaSexStat";
    }
    
    @RequestMapping({ "loadCustomerAreaSexStatJson" })
    @ResponseBody
    public List<BaseEntity> loadCustomerAreaSexStatJson(final String area) {
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        System.out.println(this.statService.loadCustomerAreaSexStatList(area));
        return this.statService.loadCustomerAreaSexStatList(area);
    }
    
    @RequestMapping({ "toOpernameYearGradeStat" })
    public String toOpernameYearGradeStat() {
        return "stat/opernameYearGradeStat";
    }
    
    @RequestMapping({ "loadOpernameYearGradeStatJson" })
    @ResponseBody
    public Map<String, Object> loadOpernameYearGradeStatJson(final String year) {
        final List<BaseEntity> entities = this.statService.loadOpernameYearGradeStatList(year);
        final Map<String, Object> map = new HashMap<String, Object>();
        final List<String> names = new ArrayList<String>();
        final List<Double> values = new ArrayList<Double>();
        for (final BaseEntity baseEntity : entities) {
            names.add(baseEntity.getName());
            values.add(baseEntity.getValue());
        }
        map.put("name", names);
        map.put("value", values);
        return map;
    }
    
    @RequestMapping({ "toCompanyYearGradeStat" })
    public String toCompanyYearGradeStat() {
        return "stat/companyYearGradeStat";
    }
    
    @RequestMapping({ "loadCompanyYearGradeStatJson" })
    @ResponseBody
    public List<Double> loadCompanyYearGradeStatJson(final String year) {
        final List<Double> entities = this.statService.loadCompanyYearGradeStatList(year);
        for (int i = 0; i < entities.size(); ++i) {
            if (entities.get(i) == null) {
                entities.set(i, 0.0);
            }
        }
        return entities;
    }
    
    @RequestMapping({ "exportCustomer" })
    public ResponseEntity<Object> exportCustomer(final CustomerVo customerVo, final HttpServletResponse response) {
        final List<Customer> customers = this.customerService.queryAllCustomerForList(customerVo);
        String fileName = "\u5ba2\u6237\u6570\u636e.xls";
        final String sheetName = "\u5ba2\u6237\u6570\u636e";
        final ByteArrayOutputStream bos = ExportCustomerUtils.exportCustomer(customers, sheetName);
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);
            return (ResponseEntity<Object>)new ResponseEntity((Object)bos.toByteArray(), (MultiValueMap)headers, HttpStatus.CREATED);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @RequestMapping({ "exportRent" })
    public ResponseEntity<Object> exportRent(final String rentid) {
        final Rent rent = this.rentService.queryRentByRentId(rentid);
        final Customer customer = this.customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName = String.valueOf(customer.getCustname()) + "-\u7684\u51fa\u79df\u5355.xls";
        final String sheetName = String.valueOf(customer.getCustname()) + "\u51fa\u79df\u5355";
        final ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent, customer, sheetName);
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);
            return (ResponseEntity<Object>)new ResponseEntity((Object)bos.toByteArray(), (MultiValueMap)headers, HttpStatus.CREATED);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
