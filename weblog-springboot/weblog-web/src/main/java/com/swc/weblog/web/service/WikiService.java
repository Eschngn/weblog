package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.wiki.FindWikiArticlePreNextReqVO;
import com.swc.weblog.web.model.vo.wiki.FindWikiCatalogListReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/26 17:06
 */
public interface WikiService {
    /**
     * 获取知识库
     * @return
     */
    Response findWikiList();

    /**
     * 获取知识库目录
     * @param findWikiCatalogListReqVO
     * @return
     */
    Response findWikiCatalogList(FindWikiCatalogListReqVO findWikiCatalogListReqVO);

    /**
     * 获取上下页
     * @param findWikiArticlePreNextReqVO
     * @return
     */
    Response findArticlePreNext(FindWikiArticlePreNextReqVO findWikiArticlePreNextReqVO);
}
