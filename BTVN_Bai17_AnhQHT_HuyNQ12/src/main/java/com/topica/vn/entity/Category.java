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
    private Type types;

    @OneToMany
    @JoinTable(
            name="ItemCategory",
            joinColumns = @JoinColumn( name="item_Id"),
            inverseJoinColumns = @JoinColumn( name="category_Id")
    )
    private List<Item> items = new ArrayList<>();
}
