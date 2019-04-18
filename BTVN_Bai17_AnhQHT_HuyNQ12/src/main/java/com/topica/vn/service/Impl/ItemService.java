package com.topica.vn.service.Impl;

import com.topica.vn.entity.Category;
import com.topica.vn.entity.Item;
import com.topica.vn.repository.CategoryRepository;
import com.topica.vn.repository.ItemRepository;
import com.topica.vn.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findByCategory(String category, int pageIndex, int pageSize) {
        Category category1 = categoryRepository.findByName(category);
        Page<Item> items = itemRepository.findByCategoryId(category1.getId(),new PageRequest(pageIndex,pageSize));
        return items.getContent();
    }
}
