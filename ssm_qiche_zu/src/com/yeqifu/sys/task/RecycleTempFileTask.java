// 
// 
// 

package com.yeqifu.sys.task;

import org.springframework.scheduling.annotation.Scheduled;
import java.io.File;
import com.yeqifu.sys.utils.AppFileUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RecycleTempFileTask
{
    @Scheduled(cron = "0 0 0 * * ? ")
    public void recycleTempFile() {
        final File file = new File(AppFileUtils.PATH);
    }
    
    public void deleteFile(final File file) {
        if (file != null) {
            final File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                File[] array;
                for (int length = (array = listFiles).length, i = 0; i < length; ++i) {
                    final File f = array[i];
                    if (f.getName().endsWith("_temp")) {
                        f.delete();
                    }
                    else {
                        this.deleteFile(f);
                    }
                }
            }
        }
    }
}
