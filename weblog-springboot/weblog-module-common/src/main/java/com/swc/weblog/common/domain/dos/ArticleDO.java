package com.swc.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article")
public class ArticleDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String cover;

    private String summary;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDeleted;

    private Long readNum;
}
