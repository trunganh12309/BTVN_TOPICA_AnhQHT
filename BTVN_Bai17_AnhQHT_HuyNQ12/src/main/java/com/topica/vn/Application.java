package com.topica.vn;

import com.topica.vn.entity.Category;
import com.topica.vn.entity.Item;
import com.topica.vn.service.ICategoryService;
import com.topica.vn.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = categoryService.findByType("type1",0,5);
        for(Category category : categories){
            System.out.println("Category name is: "+category.getName());
        }

        List<Item> items = itemService.findByCategory("cat1",0,5);
        for (Item i : items){
            System.out.println("Item name is: "+i.getName());
        }

        categoryService.updateCategory((long) 2,"category2");
    }
}
