package com.topica.vn.service;

import com.topica.vn.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findByType (String type, int pageIndex, int pageSize);
    void updateCategory(Long id, String name);
}
