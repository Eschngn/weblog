package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 23:42
 */
public interface BlogSettingsService {
    /**
     * 获取博客设置信息
     * @return
     */
    Response findDetail();
}
