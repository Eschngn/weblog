package com.swc.weblog.common.constant;

import java.time.format.DateTimeFormatter;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/23 12:37
 */
public interface Constants {
    /**
     * 月-日 格式
     */
    DateTimeFormatter MONTH_DAY_FORMATTER = DateTimeFormatter.ofPattern("MM-dd");

    /**
     * 年-月-日 小时-分钟-秒
     */
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
