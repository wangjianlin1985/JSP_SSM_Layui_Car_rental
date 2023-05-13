// 
// 
// 

package com.yeqifu.sys.utils;

import java.util.UUID;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class RandomUtils
{
    private static SimpleDateFormat sdf1;
    private static SimpleDateFormat sdf2;
    private static SimpleDateFormat sdf3;
    private static Random random;
    
    static {
        RandomUtils.sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        RandomUtils.sdf2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        RandomUtils.sdf3 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        RandomUtils.random = new Random();
    }
    
    public static String getCurrentDateForString() {
        return RandomUtils.sdf1.format(new Date());
    }
    
    public static String createFileNameUseTime(final String fileName) {
        final String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        final String time = RandomUtils.sdf2.format(new Date());
        final Integer num = RandomUtils.random.nextInt(9000) + 1000;
        return String.valueOf(time) + num + fileSuffix;
    }
    
    public static String createFileNameUseTime(final String fileName, final String suffix) {
        final String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        final String time = RandomUtils.sdf2.format(new Date());
        final Integer num = RandomUtils.random.nextInt(9000) + 1000;
        return String.valueOf(time) + num + fileSuffix + suffix;
    }
    
    public static String createFileNameUseUUID(final String fileName) {
        final String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        return String.valueOf(UUID.randomUUID().toString().replace("-", "").toUpperCase()) + fileSuffix;
    }
    
    public static String createRandomStringUseTime(final String preffx) {
        return String.valueOf(preffx) + "_" + RandomUtils.sdf3.format(new Date()) + "_" + (RandomUtils.random.nextInt(90000) + 10000);
    }
}
