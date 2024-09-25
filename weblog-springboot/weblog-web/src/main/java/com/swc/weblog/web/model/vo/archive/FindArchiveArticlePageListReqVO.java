package com.swc.weblog.web.model.vo.archive;

import com.swc.weblog.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/22 11:28
 */
@Data
@Builder
@ApiModel(value = "文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}
