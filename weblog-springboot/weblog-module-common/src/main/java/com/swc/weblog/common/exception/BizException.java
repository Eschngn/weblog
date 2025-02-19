package com.swc.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilson
 * @Description: 业务异常
 * @date 2024/9/19 11:59
 */
@Getter
@Setter
public class BizException extends RuntimeException{
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
