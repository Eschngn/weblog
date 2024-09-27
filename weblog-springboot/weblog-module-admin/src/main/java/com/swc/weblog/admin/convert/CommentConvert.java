package com.swc.weblog.admin.convert;

import com.swc.weblog.admin.model.vo.comment.FindCommentPageListRspVO;
import com.swc.weblog.common.domain.dos.CommentDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/27 16:59
 */
@Mapper
public interface CommentConvert {
    /**
     * 初始化 convert 实例
     */
    CommentConvert INSTANCE = Mappers.getMapper(CommentConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindCommentPageListRspVO convertDO2VO(CommentDO bean);

}

