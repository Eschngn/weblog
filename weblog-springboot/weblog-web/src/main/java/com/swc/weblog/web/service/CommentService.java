package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.comment.FindCommentListReqVO;
import com.swc.weblog.web.model.vo.comment.FindQQUserInfoReqVO;
import com.swc.weblog.web.model.vo.comment.PublishCommentReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/27 0:50
 */
public interface CommentService {

    /**
     * 根据 QQ 号获取用户信息
     * @param findQQUserInfoReqVO
     * @return
     */
    Response findQQUserInfo(FindQQUserInfoReqVO findQQUserInfoReqVO);

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Response publishComment(PublishCommentReqVO publishCommentReqVO);

    /**
     * 查询页面所有评论
     * @param findCommentListReqVO
     * @return
     */
    Response findCommentList(FindCommentListReqVO findCommentListReqVO);

}
