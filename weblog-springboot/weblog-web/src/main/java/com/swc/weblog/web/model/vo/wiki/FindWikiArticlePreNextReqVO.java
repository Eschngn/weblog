package com.swc.weblog.web.model.vo.wiki;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/26 17:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindWikiArticlePreNextReqVO {

    @NotNull(message = "知识库 ID 不能为空")
    private Long id;

    @NotNull(message = "文章 ID 不能为空")
    private Long articleId;

}
