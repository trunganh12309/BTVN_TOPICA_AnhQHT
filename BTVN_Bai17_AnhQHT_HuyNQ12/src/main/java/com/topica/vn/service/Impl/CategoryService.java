package com.topica.vn.service.Impl;

import com.topica.vn.entity.Category;
import com.topica.vn.entity.Type;
import com.topica.vn.repository.CategoryRepository;
import com.topica.vn.repository.TypeRepository;
import com.topica.vn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Category> findByType(String type, int pageIndex, int pageSize) {
        Page<Category> categories = categoryRepository.findByTypesId(typeRepository.findByName(type).getId(),new PageRequest(pageIndex,pageSize));
        return categories.getContent();
    }

    @Override
    @Transactional
    public void updateCategory(Long id, String name) {
        if (categoryRepository.findById(id).isPresent()){
            Category category  = categoryRepository.findById(id).get();
            category.setName(name);
            categoryRepository.save(category);
            System.out.println("Update category with id = "+id+" success!!!");
            System.out.println("Category new name is: "+name);
        }else {
            System.out.println("Category with id = "+id+" is not exist!!!");
        }

    }
}
