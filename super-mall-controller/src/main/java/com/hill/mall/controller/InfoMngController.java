package com.hill.mall.controller;

import com.hill.mall.dao.domain.ApplicationSpaceInfo;
import com.hill.mall.dao.operator.ApplicationSpaceInfoOperator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * InfoMngController
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@RestController
@RequestMapping(value = "/space")
public class InfoMngController {

    @Resource
    private ApplicationSpaceInfoOperator applicationSpaceInfoOperator;

    @PostMapping("/add")
    public int add(@RequestBody ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.insert(info);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.deleteByPrimaryKey(info.getId());
    }

    @PostMapping("/update")
    public int update(@RequestBody ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.updateByPrimaryKey(info);
    }

    @RequestMapping("/listAll")
    public List listAll(@RequestBody(required = false) ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.select();
    }

}
