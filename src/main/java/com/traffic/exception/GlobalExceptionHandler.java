package com.traffic.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.alibaba.fastjson.JSON;
import com.traffic.common.ApiCode;
import com.traffic.common.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date 2022-01-25
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    // <editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);
    // </editor-fold>

    /**
     * 非法参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> list = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            list.add(fieldError.getDefaultMessage());
        }
        Collections.sort(list);
        log.error("fieldErrors" + JSON.toJSONString(list));
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, list);
    }

    /**
     * HTTP解析请求参数异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("httpMessageNotReadableException:", exception);
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, ApiCode.PARAMETER_PARSE_EXCEPTION);
    }

    /**
     * HTTP
     */
    @ExceptionHandler(HttpMediaTypeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult httpMediaTypeException(HttpMediaTypeException exception) {
        log.error("httpMediaTypeException:", exception);
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, ApiCode.HTTP_MEDIA_TYPE_EXCEPTION);
    }

    /**
     * 自定义业务/数据异常处理
     */
    @ExceptionHandler({MyGlobalException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiResult yyywExceptionHandler(MyGlobalException exception) {
        log.error("MyException:", exception);
        int errorCode = ApiCode.BUSINESS_EXCEPTION.getCode();
        if (exception.getErrorCode() != null) {
            errorCode = exception.getErrorCode();
        }

        return new ApiResult().setCode(errorCode).setMsg(exception.getMessage());
    }

    /**
     * 默认的异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exceptionHandler(Exception exception) {
        log.error("exception:", exception);
        return ApiResult.fail(ApiCode.SYSTEM_EXCEPTION);
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult notLoginException(Exception exception) {
        log.error("exception:", exception);
        String message = exception.getMessage();
        return ApiResult.fail(ApiCode.NO_TOKEN_EXCEPTION);
    }

    /**
     * 角色异常
     */
    @ExceptionHandler(NotRoleException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult notRoleException(Exception exception) {
        log.error("exception:", exception);
        String message = exception.getMessage();
        return ApiResult.fail(ApiCode.ROLE_EXCEPTION);
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(NotPermissionException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult notPermissionException(Exception exception) {
        log.error("exception:", exception);
        String message = exception.getMessage();
        return ApiResult.fail(ApiCode.UNAUTHENTICATED_EXCEPTION);
    }

    /**
     * 上传超过最大值异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult maxUploadSizeExceededException(Exception exception) {
        log.error("exception:", exception);
        return ApiResult.fail("文件上传超过最大值");
    }



}
