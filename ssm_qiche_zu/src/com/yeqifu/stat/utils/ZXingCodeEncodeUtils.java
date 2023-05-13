// 
// 
// 

package com.yeqifu.stat.utils;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.io.InputStream;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.EncodeHintType;
import java.util.EnumMap;

public class ZXingCodeEncodeUtils
{
    private static final int BLACK = -16777216;
    private static final int WHITE = -1;
    private static final EnumMap<EncodeHintType, Object> hints;
    
    static {
        (hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class)).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        ZXingCodeEncodeUtils.hints.put(EncodeHintType.MARGIN, Integer.valueOf(1));
        ZXingCodeEncodeUtils.hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
    }
    
    public static void createZXingCodeSaveToDisk(final String content, final int width, final int height, final String savePath, final String imageType) {
        try {
            final BufferedImage image = createZXingCodeNormal(content, width, height);
            final File file = new File(savePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(image, imageType, file);
            System.out.println("\u751f\u6210\u6210\u529f");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage createZXingCodeNormal(final String content, final int width, final int height) {
        try {
            final BitMatrix encode = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, (Map)ZXingCodeEncodeUtils.hints);
            final int code_width = encode.getWidth();
            final int code_height = encode.getHeight();
            final BufferedImage image = new BufferedImage(code_width, code_height, 1);
            for (int i = 0; i < code_width; ++i) {
                for (int j = 0; j < code_height; ++j) {
                    image.setRGB(i, j, encode.get(i, j) ? -16777216 : -1);
                }
            }
            return image;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void createZxingCodeUseLogoSaveToDisk(final String content, final int width, final int height, final String savePath, final String imageType, final InputStream logoStream) {
        try {
            final BufferedImage codeImage = createZxingCodeUseLogo(content, width, height, logoStream);
            final File file = new File(savePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(codeImage, imageType, file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage createZxingCodeUseLogo(final String content, final int width, final int height, final InputStream logoStream) {
        try {
            final BufferedImage codeNormal = createZXingCodeNormal(content, width, height);
            if (codeNormal != null) {
                if (logoStream != null) {
                    final Graphics2D graphics = codeNormal.createGraphics();
                    final BufferedImage logoImage = ImageIO.read(logoStream);
                    final int old_logo_width = logoImage.getWidth();
                    final int old_logo_height = logoImage.getHeight();
                    final int code_width = codeNormal.getWidth();
                    final int code_height = codeNormal.getHeight();
                    final int logo_max_width = code_width / 5;
                    final int logo_max_height = code_height / 5;
                    final int logo_width = (logo_max_width < old_logo_width) ? logo_max_width : old_logo_width;
                    final int logo_height = (logo_max_height < old_logo_height) ? logo_max_height : old_logo_height;
                    final int x = (code_width - logo_width) / 2;
                    final int y = (code_height - logo_height) / 2;
                    graphics.drawImage(logoImage, x, y, logo_width, logo_height, null);
                    graphics.setStroke(new BasicStroke(2.0f));
                    graphics.setColor(Color.WHITE);
                    graphics.drawRoundRect(x, y, logo_width, logo_height, 15, 15);
                    graphics.dispose();
                    return codeNormal;
                }
            }
            else {
                System.out.println("\u751f\u6210\u5931\u8d25");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\u751f\u6210\u5931\u8d25");
        }
        return null;
    }
    
    public static void main(final String[] args) {
        final InputStream logoStream = ZXingCodeEncodeUtils.class.getClassLoader().getResourceAsStream("logo.jpg");
        createZxingCodeUseLogoSaveToDisk("\u8001\u96f7", 400, 400, "D:/laolei.gif", "JPEG", logoStream);
    }
}
