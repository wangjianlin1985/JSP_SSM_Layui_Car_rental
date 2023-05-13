// 
// 
// 

package com.yeqifu.stat.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.ByteArrayOutputStream;
import com.yeqifu.bus.domain.Customer;
import java.util.List;

public class ExportCustomerUtils
{
    public static ByteArrayOutputStream exportCustomer(final List<Customer> customers, final String sheetName) {
        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFCellStyle baseStyle = ExportHSSFCellStyle.createBaseStyle(workbook);
        final HSSFCellStyle subTitleStyle = ExportHSSFCellStyle.createSubTitleStyle(workbook);
        final HSSFCellStyle tableTitleStyle = ExportHSSFCellStyle.createTableTitleStyle(workbook);
        final HSSFCellStyle titleStyle = ExportHSSFCellStyle.createTitleStyle(workbook);
        final HSSFSheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(25);
        final CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 6);
        final CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 6);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region2);
        int index = 0;
        final HSSFRow row1 = sheet.createRow(index);
        final HSSFCell row1_cell1 = row1.createCell(0);
        row1_cell1.setCellStyle(titleStyle);
        row1_cell1.setCellValue("\u5ba2\u6237\u6570\u636e\u5217\u8868");
        ++index;
        final HSSFRow row2 = sheet.createRow(index);
        final HSSFCell row2_cell1 = row2.createCell(0);
        row2_cell1.setCellStyle(subTitleStyle);
        row2_cell1.setCellValue("\u603b\u6761\u6570\uff1a" + customers.size() + "   \u5bfc\u51fa\u65f6\u95f4\uff1a" + new Date().toLocaleString());
        final String[] titles = { "\u8eab\u4efd\u8bc1\u53f7", "\u5ba2\u6237\u59d3\u540d", "\u5ba2\u6237\u7535\u8bdd", "\u5ba2\u6237\u5730\u5740", "\u5ba2\u6237\u804c\u4e1a", "\u6027\u522b", "\u5f55\u5165\u65f6\u95f4" };
        ++index;
        final HSSFRow row3 = sheet.createRow(index);
        for (int i = 0; i < titles.length; ++i) {
            final HSSFCell row3_cell = row3.createCell(i);
            row3_cell.setCellStyle(tableTitleStyle);
            row3_cell.setCellValue(titles[i]);
        }
        for (int i = 0; i < customers.size(); ++i) {
            ++index;
            final Customer customer = customers.get(i);
            final HSSFRow row4 = sheet.createRow(index);
            final HSSFCell row_identity = row4.createCell(0);
            row_identity.setCellStyle(baseStyle);
            row_identity.setCellValue(customer.getIdentity());
            final HSSFCell row_custname = row4.createCell(1);
            row_custname.setCellStyle(baseStyle);
            row_custname.setCellValue(customer.getCustname());
            final HSSFCell row_phone = row4.createCell(2);
            row_phone.setCellStyle(baseStyle);
            row_phone.setCellValue(customer.getPhone());
            final HSSFCell row_address = row4.createCell(3);
            row_address.setCellStyle(baseStyle);
            row_address.setCellValue(customer.getAddress());
            final HSSFCell row_career = row4.createCell(4);
            row_career.setCellStyle(baseStyle);
            row_career.setCellValue(customer.getCareer());
            final HSSFCell row_sex = row4.createCell(5);
            row_sex.setCellStyle(baseStyle);
            row_sex.setCellValue((customer.getSex() == 1) ? "\u7537" : "\u5973");
            final HSSFCell row_createtime = row4.createCell(6);
            row_createtime.setCellStyle(baseStyle);
            row_createtime.setCellValue(customer.getCreatetime().toLocaleString());
        }
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write((OutputStream)outputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
