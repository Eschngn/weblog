package com.swc.weblog.admin.service;

import com.swc.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.swc.weblog.common.utils.Response;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/20 23:39
 */
public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
