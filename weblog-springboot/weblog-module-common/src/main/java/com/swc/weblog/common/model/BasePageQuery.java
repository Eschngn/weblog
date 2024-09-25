package com.swc.weblog.common.model;

import lombok.Data;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 0:53
 */
@Data
public class BasePageQuery {
    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;
}
