package com.swc.weblog.admin.service;

import com.swc.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.swc.weblog.common.utils.Response;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 14:57
 */
public interface AdminBlogSettingsService {
    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);

    /**
     * 获取博客设置详情
     * @return
     */
    Response findDetail();
}
