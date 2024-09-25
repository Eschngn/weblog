package com.swc.weblog.web.service;

import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;
import com.swc.weblog.web.model.vo.category.FindCategoryListReqVO;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 23:36
 */
public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList(FindCategoryListReqVO findCategoryListReqVO);

    /**
     * 获取分类下文章分页数据
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}
