package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.search.SearchArticlePageListReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/25 0:14
 */
public interface SearchService {

    /**
     * 关键词分页搜索
     * @param searchArticlePageListReqVO
     * @return
     */
    Response searchArticlePageList(SearchArticlePageListReqVO searchArticlePageListReqVO);
}
