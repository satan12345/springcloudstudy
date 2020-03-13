package com.able.springcloud.advice;


import com.able.springcloud.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {


    @ExceptionHandler(value = RuntimeException.class)
    public CommonResponse<String> handlerGlobalException(HttpServletRequest req,
                                                         RuntimeException ex) {
        String requestURI = req.getRequestURI();
        Map<String, String[]> parameterMap = req.getParameterMap();
        CommonResponse<String> response = new CommonResponse<>(-1, "系统发生了不可预期的错误了");
        log.error("程序调用发生异常 requestURI={} param={} e=", requestURI,parameterMap, ex);

        return response;
    }
}
