package com.hill.mall.base;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BaseResult
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@Data
@NoArgsConstructor
public class BaseResult {

    protected String code;

    protected String message;



    public BaseResult(BaseResult baseResult) {
        this.code = baseResult.getCode();
        this.message = baseResult.getMessage();
    }

    public BaseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }



}
