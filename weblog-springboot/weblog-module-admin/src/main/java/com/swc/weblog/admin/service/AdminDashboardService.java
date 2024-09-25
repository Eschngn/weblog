package com.swc.weblog.admin.service;

import com.swc.weblog.common.utils.Response;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/23 11:56
 */
public interface AdminDashboardService {
    /**
     * 获取仪表盘基础统计信息
     * @return
     */
    Response findDashboardStatistics();

    /**
     * 获取文章发布热点统计信息
     * @return
     */
    Response findDashboardPublishArticleStatistics();

    /**
     * 获取文章最近一周 PV 访问量统计信息
     * @return
     */
    Response findDashboardPVStatistics();
}
