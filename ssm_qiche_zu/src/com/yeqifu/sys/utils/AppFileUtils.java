// 
// 
// 

package com.yeqifu.sys.utils;

import java.io.PrintWriter;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.apache.commons.io.FileUtils;
import java.net.URLEncoder;
import java.io.File;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class AppFileUtils
{
    public static String PATH;
    
    static {
        AppFileUtils.PATH = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0, Thread.currentThread().getContextClassLoader().getResource("").getPath().length() - 16)) + "/upload/";
        final InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
        final Properties properties = new Properties();
        try {
            properties.load(stream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ResponseEntity<Object> downloadFile(final HttpServletResponse response, final String path, String oldName) {
        final File file = new File(AppFileUtils.PATH, path);
        if (file.exists()) {
            try {
                try {
                    oldName = URLEncoder.encode(oldName, "UTF-8");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                final byte[] bytes = FileUtils.readFileToByteArray(file);
                final HttpHeaders header = new HttpHeaders();
                header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                header.setContentDispositionFormData("attachment", oldName);
                final ResponseEntity<Object> entity = (ResponseEntity<Object>)new ResponseEntity((Object)bytes, (MultiValueMap)header, HttpStatus.CREATED);
                return entity;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            final PrintWriter out = response.getWriter();
            out.write("\u6587\u4ef6\u4e0d\u5b58\u5728");
            out.flush();
            out.close();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }
    
    public static void deleteFileUsePath(final String path) {
        final String realPath = String.valueOf(AppFileUtils.PATH) + path;
        final File file = new File(realPath);
        if (file.exists()) {
            file.delete();
        }
    }
    
    public static String updateFileName(final String carimg, final String suffix) {
        try {
            final File file = new File(AppFileUtils.PATH, carimg);
            if (file.exists()) {
                file.renameTo(new File(AppFileUtils.PATH, carimg.replace(suffix, "")));
                return carimg.replace(suffix, "");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void removeFileByPath(final String carimg) {
        try {
            final File file = new File(AppFileUtils.PATH, carimg);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
