package com.swc.weblog.admin.service;

import com.swc.weblog.admin.model.vo.comment.DeleteCommentReqVO;
import com.swc.weblog.admin.model.vo.comment.ExamineCommentReqVO;
import com.swc.weblog.admin.model.vo.comment.FindCommentPageListReqVO;
import com.swc.weblog.common.utils.Response;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/27 16:59
 */
public interface AdminCommentService {
    /**
     * 查询评论分页数据
     * @param findCommentPageListReqVO
     * @return
     */
    Response findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);

    /**
     * 删除评论
     * @param deleteCommentReqVO
     * @return
     */
    Response deleteComment(DeleteCommentReqVO deleteCommentReqVO);

    /**
     * 评论审核
     * @param examineCommentReqVO
     * @return
     */
    Response examine(ExamineCommentReqVO examineCommentReqVO);
}
