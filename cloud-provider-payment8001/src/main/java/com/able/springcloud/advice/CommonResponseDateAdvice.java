package com.able.springcloud.advice;



import com.able.springcloud.annotation.UseResponseAdvice;
import com.able.springcloud.dto.CommonResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDateAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 响应是否支持拦截
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {


        //类是否被注解标识
        if (methodParameter.getDeclaringClass().isAnnotationPresent(UseResponseAdvice.class)) {
            return Boolean.TRUE;
        }
        //方法是否被注解标识
        if (methodParameter.getMethod().isAnnotationPresent(UseResponseAdvice.class)) {
            return Boolean.TRUE;
        }
        //其他情况不予拦截处理
        return Boolean.FALSE;
    }

    /**
     * 在写入响应之前操作
     *
     * @param o                  为响应对象
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response = CommonResponse.getSuccessInstance();

        if (o == null) {
            return response;
        } else if (o instanceof CommonResponse) {
            return o;
        }
        response.setData(o);
        //处理返回值是String的情况
        if (o instanceof String) {
            serverHttpResponse.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE));
            return JSON.toJSONString(response);
        }

        return response;
    }
}
