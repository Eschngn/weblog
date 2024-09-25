package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.article.FindArticleDetailReqVO;
import com.swc.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 22:58
 */
public interface ArticleService {
    /**
     * 获取首页文章分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);

    /**
     * 获取文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);
}
