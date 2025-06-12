package com.swc.weblog.admin.service.impl;

import com.swc.weblog.admin.model.vo.file.UploadFileRspVO;
import com.swc.weblog.admin.service.AdminFileService;
import com.swc.weblog.admin.utils.AliyunOSSUtil;
import com.swc.weblog.admin.utils.MinioUtil;
import com.swc.weblog.common.enums.ResponseCodeEnum;
import com.swc.weblog.common.exception.BizException;
import com.swc.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/21 14:46
 */
@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {
    @Autowired
    private MinioUtil minioUtil;
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public Response uploadFile(MultipartFile file) {
        try {
            // 上传文件
            String url = aliyunOSSUtil.uploadFile(file);

            // 构建成功返参，将图片的访问链接返回
            return Response.success(UploadFileRspVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至 AliyunOSS 错误: ", e);
            // 手动抛出业务异常，提示 “文件上传失败”
            throw new BizException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}

