package com.swc.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swc.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.swc.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.swc.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.swc.weblog.admin.model.vo.category.FindCategoryPageListRspVO;
import com.swc.weblog.admin.model.vo.tag.*;
import com.swc.weblog.admin.service.AdminCategoryService;
import com.swc.weblog.admin.service.AdminTagService;
import com.swc.weblog.common.domain.dos.ArticleTagRelDO;
import com.swc.weblog.common.domain.dos.CategoryDO;
import com.swc.weblog.common.domain.dos.TagDO;
import com.swc.weblog.common.domain.mapper.ArticleTagRelMapper;
import com.swc.weblog.common.domain.mapper.CategoryMapper;
import com.swc.weblog.common.domain.mapper.TagMapper;
import com.swc.weblog.common.enums.ResponseCodeEnum;
import com.swc.weblog.common.exception.BizException;
import com.swc.weblog.common.model.vo.SelectRspVO;
import com.swc.weblog.common.utils.PageResponse;
import com.swc.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 0:42
 */
@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;


    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    @Override
    public Response addTags(AddTagReqVO addTagReqVO) {
        //VO 转DO
        List<TagDO> tagDOS=addTagReqVO.getTags()
                .stream().map(tanName-> TagDO.builder()
                        .name(tanName.trim())
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build()).collect(Collectors.toList());
        try {
            saveBatch(tagDOS);
        } catch (Exception e) {
            log.warn(ResponseCodeEnum.TAG_CANT_DUPLICATE.getErrorMessage(),e);
            return Response.fail(ResponseCodeEnum.TAG_CANT_DUPLICATE);

        }
        return Response.success();
    }

    /**
     * 查询标签分页
     * @param findTagPageListReqVO
     * @return
     */
    @Override
    public PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO) {
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();
        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDate();
        LocalDate endDate = findTagPageListReqVO.getEndDate();

        Page<TagDO> page = tagMapper.selectPageList(current, size, name, startDate, endDate);

        List<TagDO> records = page.getRecords();

        // do 转 vo
        List<FindTagPageListRspVO> vos=null;

        if(!CollectionUtils.isEmpty(records)){
            vos=records.stream()
                    .map(tagDO -> FindTagPageListRspVO.builder()
                            .id(tagDO.getId())
                            .name(tagDO.getName())
                            .createTime(tagDO.getCreateTime())
                            .articlesTotal(tagDO.getArticlesTotal())
                            .build()).collect(Collectors.toList());
        }
        return PageResponse.success(page,vos);
    }

    /**
     * 删除标签
     * @param deleteTagReqVO
     * @return
     */
    @Override
    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        // 标签ID
        Long tagId = deleteTagReqVO.getId();

        // 校验该标签下是否有关联的文章，若有，则不允许删除，提示用户需要先删除标签下的文章
        ArticleTagRelDO articleTagRelDO = articleTagRelMapper.selectOneByTagId(tagId);
        if (Objects.nonNull(articleTagRelDO)) {
            log.warn("==> 此标签下包含文章，无法删除，tagId: {}", tagId);
            throw new BizException(ResponseCodeEnum.TAG_CAN_NOT_DELETE);
        }
        int count = tagMapper.deleteById(tagId);
        return count==1 ? Response.success() :Response.fail(ResponseCodeEnum.TAG_NOT_EXISTED);
    }

    /**
     * 根据标签关键词模糊查询
     * @param searchTagReqVO
     * @return
     */
    @Override
    public Response searchTag(SearchTagReqVO searchTagReqVO) {
        String key = searchTagReqVO.getKey();

        // 执行模糊查询
        List<TagDO> tagDOS = tagMapper.selectByKey(key);

        // do 转 vo
        List<SelectRspVO> vos=null;

        if(!CollectionUtils.isEmpty(tagDOS)){
            vos=tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build()).collect(Collectors.toList());
        }

        return Response.success(vos);
    }

    @Override
    public Response findTagSelectList() {
        // 查询所有标签, Wrappers.emptyWrapper() 表示查询条件为空
        List<TagDO> tagDOS = tagMapper.selectList(Wrappers.emptyWrapper());

        // DO 转 VO
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }
}
