package com.swc.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/26 13:57
 */
@Getter
@AllArgsConstructor
public enum WikiCatalogLevelEnum {

    // 一级目录
    ONE(1),
    // 二级目录
    TWO(2);

    private Integer value;

}
