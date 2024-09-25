package com.swc.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swc.weblog.common.domain.dos.CategoryDO;
import com.swc.weblog.common.domain.dos.TagDO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 0:39
 */
public interface TagMapper extends BaseMapper<TagDO> {
    /**
     * 分页查询
     * @param current
     * @param size
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    default Page<TagDO> selectPageList(long current, long size, String name, LocalDate startDate,LocalDate endDate){
        // 分页对象
        Page<TagDO> page=new Page<>(current,size);

        // 构建查询条件
        LambdaQueryWrapper<TagDO> wrapper=new LambdaQueryWrapper<>();
        wrapper
                .like(StringUtils.isNotEmpty(name),TagDO::getName,name.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate),TagDO::getCreateTime,startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate),TagDO::getCreateTime,endDate) // 小于等于 endDate
                .orderByDesc(TagDO::getCreateTime); // 按创建时间倒叙

        return selectPage(page,wrapper);
    }

    /**
     * 根据标签模糊查询
     * @param key
     * @return
     */
    default List<TagDO> selectByKey(String key){
        LambdaQueryWrapper<TagDO> wrapper=new LambdaQueryWrapper<>();

        wrapper.like(TagDO::getName,key).orderByDesc(TagDO::getCreateTime);

        return selectList(wrapper);
    }

    /**
     * 根据标签 ID 批量查询
     * @param tagIds
     * @return
     */
    default List<TagDO> selectByIds(List<Long> tagIds) {
        return selectList(Wrappers.<TagDO>lambdaQuery()
                .in(TagDO::getId, tagIds));
    }

}
