package com.zhenghao.rule.management.api.advice;

import com.zhenghao.rule.management.contract.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class,
            IllegalArgumentException.class, IllegalStateException.class})
    @ResponseBody
    public BaseResponse handleLogicException(Exception e) {
        return BaseResponse.newFailureResponse(e.getMessage());
    }

}
