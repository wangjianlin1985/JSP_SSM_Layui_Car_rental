// 
// 
// 

package com.yeqifu.sys.controller;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import com.yeqifu.sys.utils.RandomUtils;
import com.yeqifu.sys.utils.AppFileUtils;
import com.yeqifu.sys.utils.DataGridView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "file" })
public class FileController
{
    @RequestMapping({ "uploadFile" })
    @ResponseBody
    public DataGridView uploadFile(final MultipartFile mf) throws IllegalStateException, IOException {
        final String parentPath = AppFileUtils.PATH;
        final String dirName = RandomUtils.getCurrentDateForString();
        final File dirFile = new File(parentPath, dirName);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        final String oldName = mf.getOriginalFilename();
        final String newName = RandomUtils.createFileNameUseTime(oldName, "_temp");
        final File dest = new File(dirFile, newName);
        mf.transferTo(dest);
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("src", String.valueOf(dirName) + "/" + newName);
        return new DataGridView(map);
    }
    
    @RequestMapping({ "downloadShowFile" })
    public ResponseEntity<Object> downloadShowFile(final String path, final HttpServletResponse response) {
        return AppFileUtils.downloadFile(response, path, "");
    }
    
    @RequestMapping({ "downloadFile" })
    public ResponseEntity<Object> downloadFile(final String path, final HttpServletResponse response) {
        final String oldName = "";
        return AppFileUtils.downloadFile(response, path, oldName);
    }
}
