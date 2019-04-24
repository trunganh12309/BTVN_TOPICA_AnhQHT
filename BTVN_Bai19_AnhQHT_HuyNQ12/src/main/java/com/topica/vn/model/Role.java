package com.topica.vn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
