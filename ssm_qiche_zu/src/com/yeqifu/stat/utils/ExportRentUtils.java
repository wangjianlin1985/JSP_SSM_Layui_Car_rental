// 
// 
// 

package com.yeqifu.stat.utils;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import java.util.Date;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.ByteArrayOutputStream;
import com.yeqifu.bus.domain.Customer;
import com.yeqifu.bus.domain.Rent;

public class ExportRentUtils
{
    public static ByteArrayOutputStream exportRent(final Rent rent, final Customer customer, final String sheetName) {
        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFCellStyle baseStyle = ExportHSSFCellStyle.createBaseStyle(workbook);
        final HSSFCellStyle titleStyle = ExportHSSFCellStyle.createTitleStyle(workbook);
        final HSSFSheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(30);
        sheet.setColumnWidth(1, 12800);
        final CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(region1);
        int index = 0;
        final HSSFRow row1 = sheet.createRow(index);
        final HSSFCell row1_cell1 = row1.createCell(0);
        row1_cell1.setCellStyle(titleStyle);
        row1_cell1.setCellValue(String.valueOf(customer.getCustname()) + "\u7684\u51fa\u79df\u5355\u4fe1\u606f");
        ++index;
        final HSSFRow row2 = sheet.createRow(index);
        row2.setHeightInPoints(150.0f);
        final HSSFCell row2_cell1 = row2.createCell(0);
        row2_cell1.setCellStyle(baseStyle);
        row2_cell1.setCellValue("\u51fa\u79df\u5355\u53f7\uff1a");
        final HSSFCell row2_cell2 = row2.createCell(1);
        row2_cell2.setCellStyle(baseStyle);
        row2_cell2.setCellValue(rent.getRentid());
        final HSSFCell row2_cell3 = row2.createCell(2);
        row2_cell3.setCellStyle(baseStyle);
        row2_cell3.setCellValue("\u4e8c\u7ef4\u7801\uff1a");
        final HSSFCell row2_cell4 = row2.createCell(3);
        row2_cell4.setCellStyle(baseStyle);
        row2_cell4.setCellValue("");
        final InputStream logoStream = ExportCustomerUtils.class.getClassLoader().getResourceAsStream("logo.jpg");
        final BufferedImage image = ZXingCodeEncodeUtils.createZxingCodeUseLogo(rent.getRentid(), 150, 150, logoStream);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", bos);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        final HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 255, (short)3, 1, (short)4, 1);
        anchor.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
        patriarch.createPicture(anchor, workbook.addPicture(bos.toByteArray(), 5));
        ++index;
        final HSSFRow row3 = sheet.createRow(index);
        final HSSFCell row3_cell1 = row3.createCell(0);
        row3_cell1.setCellStyle(baseStyle);
        row3_cell1.setCellValue("\u5ba2\u6237\u59d3\u540d\uff1a");
        final HSSFCell row3_cell2 = row3.createCell(1);
        row3_cell2.setCellStyle(baseStyle);
        row3_cell2.setCellValue(customer.getCustname());
        final HSSFCell row3_cell3 = row3.createCell(2);
        row3_cell3.setCellStyle(baseStyle);
        row3_cell3.setCellValue("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        final HSSFCell row3_cell4 = row3.createCell(3);
        row3_cell4.setCellStyle(baseStyle);
        row3_cell4.setCellValue(customer.getIdentity());
        ++index;
        final HSSFRow row4 = sheet.createRow(index);
        final HSSFCell row4_cell1 = row4.createCell(0);
        row4_cell1.setCellStyle(baseStyle);
        row4_cell1.setCellValue("\u8d77\u79df\u65f6\u95f4");
        final HSSFCell row4_cell2 = row4.createCell(1);
        row4_cell2.setCellStyle(baseStyle);
        row4_cell2.setCellValue(rent.getBegindate().toLocaleString());
        final HSSFCell row4_cell3 = row4.createCell(2);
        row4_cell3.setCellStyle(baseStyle);
        row4_cell3.setCellValue("\u8fd8\u8f66\u65f6\u95f4\uff1a");
        final HSSFCell row4_cell4 = row4.createCell(3);
        row4_cell4.setCellStyle(baseStyle);
        row4_cell4.setCellValue(rent.getReturndate().toLocaleString());
        ++index;
        final HSSFRow row5 = sheet.createRow(index);
        final HSSFCell row5_cell1 = row5.createCell(0);
        row5_cell1.setCellStyle(baseStyle);
        row5_cell1.setCellValue("\u8f66\u724c\u53f7\uff1a");
        final HSSFCell row5_cell2 = row5.createCell(1);
        row5_cell2.setCellStyle(baseStyle);
        row5_cell2.setCellValue(rent.getCarnumber());
        final HSSFCell row5_cell3 = row5.createCell(2);
        row5_cell3.setCellStyle(baseStyle);
        row5_cell3.setCellValue("\u51fa\u79df\u4ef7\u683c\uff1a");
        final HSSFCell row5_cell4 = row5.createCell(3);
        row5_cell4.setCellStyle(baseStyle);
        row5_cell4.setCellValue((double)rent.getPrice());
        ++index;
        ++index;
        final HSSFRow row6 = sheet.createRow(index);
        final HSSFCell row7_cell3 = row6.createCell(2);
        row7_cell3.setCellStyle(baseStyle);
        row7_cell3.setCellValue("\u6253\u5370\u65f6\u95f4\uff1a");
        final HSSFCell row7_cell2 = row6.createCell(3);
        row7_cell2.setCellStyle(baseStyle);
        row7_cell2.setCellValue(new Date().toLocaleString());
        ++index;
        final HSSFRow row7 = sheet.createRow(index);
        final HSSFCell row8_cell3 = row7.createCell(2);
        row8_cell3.setCellStyle(baseStyle);
        row8_cell3.setCellValue("\u64cd\u4f5c\u5458\uff1a");
        final HSSFCell row8_cell2 = row7.createCell(3);
        row8_cell2.setCellStyle(baseStyle);
        row8_cell2.setCellValue(rent.getOpername());
        ++index;
        final HSSFRow row8 = sheet.createRow(index);
        final HSSFCell row9_cell3 = row8.createCell(2);
        row9_cell3.setCellStyle(baseStyle);
        row9_cell3.setCellValue("\u5ba2\u6237\u7b7e\u540d\uff1a");
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write((OutputStream)outputStream);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        return outputStream;
    }
}
