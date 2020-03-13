package com.able.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***通用返回数据dto
* @author jipeng
* @date 2020/3/12 17:20
* @return 
**/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    public static final String SUCCESS_STR = "请求成功";
    /**
     *
     */
    public static final Integer SUCCESS_CODE = 0;

    private Integer code;
    private String message;
    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> CommonResponse<T> getSuccessWithResultInstance(T result) {
        CommonResponse<T> commonResponse = new CommonResponse<>(SUCCESS_CODE, SUCCESS_STR);
        commonResponse.setData(result);
        return commonResponse;
    }

    public static CommonResponse getSuccessInstance() {
        CommonResponse commonResponse = new CommonResponse<>(SUCCESS_CODE, SUCCESS_STR);
        return commonResponse;
    }
}
