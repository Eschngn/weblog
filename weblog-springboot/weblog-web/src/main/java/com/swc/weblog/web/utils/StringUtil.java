package com.swc.weblog.web.utils;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/27 0:50
 */
public class StringUtil {
    /**
     * 判断字符串是否是纯数字
     * @param str
     * @return
     */
    public static boolean isPureNumber(String str) {
        return str.matches("\\d+");
    }
}
