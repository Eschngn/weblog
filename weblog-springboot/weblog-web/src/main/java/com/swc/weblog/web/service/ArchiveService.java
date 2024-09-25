package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.archive.FindArchiveArticlePageListReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/22 11:46
 */
public interface ArchiveService {
    /**
     * 获取文章归档分页数据
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO);
}
