package com.example.featdemo.base;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBaseService<T> extends IService<T> {
    List<T> getList();
}
