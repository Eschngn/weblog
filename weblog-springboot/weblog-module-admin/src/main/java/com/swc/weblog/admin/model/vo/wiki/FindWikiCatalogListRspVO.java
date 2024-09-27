package com.swc.weblog.admin.model.vo.wiki;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/26 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindWikiCatalogListRspVO {

    /**
     * 目录 ID
     */
    private Long id;

    private Long articleId;

    private String title;

    private Integer sort;

    private Integer level;

    /**
     * 是否处于编辑状态（用于前端是否显示编辑输入框）
     */
    private Boolean editing;

    /**
     * 二级目录
     */
    private List<FindWikiCatalogListRspVO> children;

}
