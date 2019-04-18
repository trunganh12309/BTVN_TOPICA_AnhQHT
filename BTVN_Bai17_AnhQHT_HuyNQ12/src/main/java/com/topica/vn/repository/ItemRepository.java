package com.topica.vn.repository;

import com.topica.vn.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT item from item inner join itemcategory on item.id = itemcategory.item_id where itemcategory.category_id = 1",nativeQuery = true)
    Page<Item> findByCategoryId(Long id, Pageable pageable);
}
