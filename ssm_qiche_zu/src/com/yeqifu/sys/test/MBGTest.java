// 
// 
// 

package com.yeqifu.sys.test;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.util.List;
import org.mybatis.generator.config.xml.ConfigurationParser;
import java.io.File;
import java.util.ArrayList;

public class MBGTest
{
    public static void main(final String[] args) throws Exception {
        final List<String> warnings = new ArrayList<String>();
        final boolean overwrite = true;
        final File configFile = new File("mbg_news.xml");
        final ConfigurationParser cp = new ConfigurationParser((List)warnings);
        final Configuration config = cp.parseConfiguration(configFile);
        final DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        final MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, (ShellCallback)callback, (List)warnings);
        myBatisGenerator.generate((ProgressCallback)null);
    }
}
