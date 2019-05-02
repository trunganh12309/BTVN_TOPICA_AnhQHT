package com.topica.vn.repository;

import com.topica.vn.model.Vietnamese;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VietnameseRepository extends JpaRepository<Vietnamese, Long> {
    @Query(value = "SELECT * FROM public.vietnamese WHERE content LIKE CONCAT('%',?1,'%')",nativeQuery = true)
    Page<Vietnamese> findByContent(String content, Pageable pageable);

    Vietnamese findByContent(String content);

    List<Vietnamese> findAll();

    Page<Vietnamese> findAll(Pageable pageable);

    Optional<Vietnamese> findById(Long id);
}
