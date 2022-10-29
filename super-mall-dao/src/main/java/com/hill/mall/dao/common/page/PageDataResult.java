package com.hill.mall.dao.common.page;

import com.hill.mall.base.BaseResult;
import com.hill.mall.base.BaseResultConst;
import lombok.Data;

import java.util.List;

/**
 * PageDataResult
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/

@Data
public class PageDataResult extends BaseResult {

    private static final String SUCCESS = "0";

    private static final String ERROR = "-1";

    private Long total;

    private List dataList;

    public PageDataResult(Long total, List dataList) {
        super(SUCCESS, "");
        this.total = total;
        this.dataList = dataList;
    }

    public PageDataResult(BaseResult baseResult, Long total, List dataList) {
        super(baseResult);
        this.total = total;
        this.dataList = dataList;
    }

    public PageDataResult(String code, String message, Long total, List dataList) {
        super(code, message);
        this.total = total;
        this.dataList = dataList;
    }

    public PageDataResult(BaseResult victory) {
        super(victory);
    }

    public static PageDataResult success() {
        return new PageDataResult(BaseResultConst.VICTORY);
    }

    public static PageDataResult success(String code, String message, Long total, List dataList) {
        return new PageDataResult(code, message, total, dataList);
    }


    public static PageDataResult success(List dataList) {
        return new PageDataResult(BaseResultConst.VICTORY, null, dataList);
    }

    public static PageDataResult success(Long total, List dataList) {
        return new PageDataResult(BaseResultConst.VICTORY, total, dataList);
    }

    public static PageDataResult success(String code, String message) {
        return new PageDataResult(code, message, null, null);
    }

    public static PageDataResult failed(BaseResult BaseResult, List dataList) {
        return new PageDataResult(BaseResult, null, dataList);
    }

    public static PageDataResult failed() {
        return new PageDataResult(BaseResultConst.DEFEAT);
    }

    public static PageDataResult failed(BaseResult BaseResult) {
        return new PageDataResult(BaseResult, null, null);
    }

    public static PageDataResult failed(String code, String message, Long total, List dataList) {
        return new PageDataResult(code, message, total, dataList);
    }

    public static PageDataResult failed(String code, String message) {
        return new PageDataResult(code, message, null, null);
    }
}
