package com.topica.vn.service;

import com.topica.vn.entity.Item;

import java.util.List;

public interface IItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);
}
