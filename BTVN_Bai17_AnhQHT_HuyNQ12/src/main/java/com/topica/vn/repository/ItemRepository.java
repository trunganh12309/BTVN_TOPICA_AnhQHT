package com.topica.vn.repository;

import com.topica.vn.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT * from public.item as a inner join public.item_category as b on a.id = b.item_id where b.category_id = ?1",nativeQuery = true)
    Page<Item> findByCategoryId(Long id, Pageable pageable);
}
