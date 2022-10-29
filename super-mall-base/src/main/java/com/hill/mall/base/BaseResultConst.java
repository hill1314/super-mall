package com.hill.mall.base;

/**
 * TODO 类注释
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
public class BaseResultConst {
    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    public static final BaseResult VICTORY = new BaseResult(SUCCESS, "成功");
    public static final BaseResult DEFEAT = new BaseResult(ERROR, "失败");
}
