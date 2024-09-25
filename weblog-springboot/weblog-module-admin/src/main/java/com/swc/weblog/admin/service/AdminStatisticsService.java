package com.swc.weblog.admin.service;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/25 12:48
 */
public interface AdminStatisticsService {
    /**
     * 统计各分类下文章总数
     */
    void statisticsCategoryArticleTotal();

    /**
     * 统计各标签下文章总数
     */
    void statisticsTagArticleTotal();
}
