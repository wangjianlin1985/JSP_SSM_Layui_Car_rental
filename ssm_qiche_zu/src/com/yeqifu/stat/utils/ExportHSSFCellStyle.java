// 
// 
// 

package com.yeqifu.stat.utils;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportHSSFCellStyle
{
    public static HSSFCellStyle createBaseStyle(final HSSFWorkbook workbook) {
        final HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }
    
    public static HSSFCellStyle createTableTitleStyle(final HSSFWorkbook workbook) {
        final HSSFCellStyle style = createBaseStyle(workbook);
        final HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setItalic(true);
        font.setFontHeightInPoints((short)20);
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_YELLOW.getIndex());
        font.setFontName("\u9ed1\u4f53");
        style.setFont(font);
        return style;
    }
    
    public static HSSFCellStyle createSubTitleStyle(final HSSFWorkbook workbook) {
        final HSSFCellStyle style = createBaseStyle(workbook);
        final HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)25);
        font.setColor(HSSFColor.HSSFColorPredefined.SKY_BLUE.getIndex());
        font.setFontName("\u9ed1\u4f53");
        style.setFont(font);
        return style;
    }
    
    public static HSSFCellStyle createTitleStyle(final HSSFWorkbook workbook) {
        final HSSFCellStyle style = createBaseStyle(workbook);
        final HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)35);
        font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        font.setFontName("\u534e\u6587\u884c\u6977");
        style.setFont(font);
        return style;
    }
}
