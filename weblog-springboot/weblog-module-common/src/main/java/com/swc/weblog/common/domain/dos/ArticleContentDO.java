package com.swc.weblog.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article_content")
public class ArticleContentDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long articleId;

    private String content;

}

