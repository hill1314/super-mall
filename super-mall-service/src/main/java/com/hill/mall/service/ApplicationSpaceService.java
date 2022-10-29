package com.hill.mall.service;

import com.hill.mall.dao.domain.ApplicationSpaceInfo;
import com.hill.mall.dao.operator.ApplicationSpaceInfoOperator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ApplicationSpaceService
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@Service
public class ApplicationSpaceService {
    @Resource
    private ApplicationSpaceInfoOperator applicationSpaceInfoOperator;

    public int add(ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.insert(info);
    }

    public int delete(int id) {
        return applicationSpaceInfoOperator.deleteByPrimaryKey(id);
    }

    public int update(ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.updateByPrimaryKey(info);
    }

    public List listAll(ApplicationSpaceInfo info) {
        return applicationSpaceInfoOperator.select();
    }
}
