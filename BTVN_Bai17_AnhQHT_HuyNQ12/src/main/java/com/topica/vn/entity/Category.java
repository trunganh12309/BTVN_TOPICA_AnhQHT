package com.topica.vn.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @OneToMany
    @JoinTable(
            name="ItemCategory",
            joinColumns = @JoinColumn( name="category_id"),
            inverseJoinColumns = @JoinColumn( name="item_id")
    )
    private List<Item> items = new ArrayList<>();
}
