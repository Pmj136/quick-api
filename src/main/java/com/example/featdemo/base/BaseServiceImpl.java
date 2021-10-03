package com.example.featdemo.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    public List<T> getList() {
        return null;
    }
}