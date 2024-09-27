package com.swc.weblog.web.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.swc.weblog.common.domain.dos.ArticleDO;
import com.swc.weblog.common.domain.mapper.ArticleMapper;
import com.swc.weblog.common.utils.PageResponse;
import com.swc.weblog.common.utils.Response;
import com.swc.weblog.web.convert.ArticleConvert;
import com.swc.weblog.web.model.vo.archive.FindArchiveArticlePageListReqVO;
import com.swc.weblog.web.model.vo.archive.FindArchiveArticlePageListRspVO;
import com.swc.weblog.web.model.vo.archive.FindArchiveArticleRspVO;
import com.swc.weblog.web.service.ArchiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.YearMonth;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/22 11:46
 */
@Service
@Slf4j
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO) {
        Long current = findArchiveArticlePageListReqVO.getCurrent();
        Long size = findArchiveArticlePageListReqVO.getSize();

        // 分页查询
        Page<ArticleDO> page = articleMapper.selectPageList(current, size, null, null, null,null);
        List<ArticleDO> articleDOS = page.getRecords();

        List<FindArchiveArticlePageListRspVO> vos=Lists.newArrayList();
        if(!CollectionUtils.isEmpty(articleDOS)){
            // DO 转 VO
            List<FindArchiveArticleRspVO> findArchiveArticleRspVOS=articleDOS.stream()
                    .map(articleDO -> ArticleConvert.INSTANCE.convertDO2ArchiveArticleVO(articleDO))
                    .collect(Collectors.toList());

            // 按创建的月份进行分组
            Map<YearMonth, List<FindArchiveArticleRspVO>> map = findArchiveArticleRspVOS.stream().collect(Collectors
                    .groupingBy(FindArchiveArticleRspVO::getCreateMonth));

            // 使用 TreeMap 按月份倒序排列
            Map<YearMonth, List<FindArchiveArticleRspVO>> sortedMap = new TreeMap<>(Collections.reverseOrder());
            sortedMap.putAll(map);

            sortedMap.forEach((k,v)->vos.add(FindArchiveArticlePageListRspVO.builder().month(k).articles(v).build()));
        }
        return PageResponse.success(page,vos);
    }
}
