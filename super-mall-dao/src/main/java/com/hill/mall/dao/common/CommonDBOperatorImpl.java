package com.hill.mall.dao.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hill.mall.base.exception.BaseException;
import com.hill.mall.base.exception.ExceptionCode;
import com.hill.mall.dao.common.page.ExtPageHelper;
import com.hill.mall.dao.common.page.PageDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * CommonDBOperatorServiceImpl
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@Slf4j
public class CommonDBOperatorImpl<T> implements CommonDBOperator<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public int insert(T t) {
        try {
            return mapper.insert(t);
        } catch (Exception e) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, e);
            throw new BaseException(e);
        }
    }

    @Override
    public int delete(T t) {
        try {
            return mapper.delete(t);
        } catch (Exception e) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, e);
            throw new BaseException(e);
        }
    }

    @Override
    public int updateByPrimaryKey(T t) {
        try {
            return mapper.updateByPrimaryKey(t);
        } catch (Exception e) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, e);
            throw new BaseException(e);
        }
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        try {
            return mapper.updateByPrimaryKeySelective(t);
        } catch (Exception e) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, e);
            throw new BaseException(e);
        }
    }

    @Override
    public int updateByExample(T t, Example e) {
        try {
            return mapper.updateByExample(t, e);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);
            throw new BaseException(ex);
        }

    }

    @Override
    public int updateByExampleSelective(T t, Example e) {
        try {
            return mapper.updateByExampleSelective(t, e);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, e);
            throw new BaseException(ex);
        }
    }

    @Override
    public T selectOne(T t) {
        try {
            return mapper.selectOne(t);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);
            throw new BaseException(ex);
        }
    }

    @Override
    public List<T> select() {
        try {
            return mapper.selectAll();
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public List<T> select(T t) {
        try {
            return mapper.select(t);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);
            throw new BaseException(ex);
        }
    }

    @Override
    public List<T> selectByExample(Example e) {
        try {
            return mapper.selectByExample(e);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public T selectByPrimaryKey(Long pk) {
        try {
            return mapper.selectByPrimaryKey(pk);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public PageInfo<T> selectPage(int pageNum, int pageSize, Example e) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<T> lst = mapper.selectByExample(e);
            return new PageInfo(lst);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }

    }

    @Override
    @ExtPageHelper
    public PageDataResult selectByPage(int pageNum, int pageSize, Example e) {
        try {

            PageHelper.startPage(pageNum, pageSize);
            List<T> lst = null;
            if (e == null) {
                lst = mapper.selectAll();
            } else {
                lst = mapper.selectByExample(e);
            }
            PageInfo<T> pageList = new PageInfo<T>(lst);

            return PageDataResult.success(pageList.getTotal(), pageList.getList());
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public int selectCountByExample(Example e) {
        try {
            return mapper.selectCountByExample(e);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }

    }

    @Override
    public int selectCount(T t) {
        try {
            return mapper.selectCount(t);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public int deleteByExample(Example e) {
        try {
            return mapper.deleteByExample(e);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        try {
            return mapper.deleteByPrimaryKey(key);
        } catch (Exception ex) {
            log.error(ExceptionCode.DB_ERROR_FORMAT, ex);

            throw new BaseException(ex);
        }
    }
}
