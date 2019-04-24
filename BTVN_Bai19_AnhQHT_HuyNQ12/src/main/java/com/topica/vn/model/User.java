package com.topica.vn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;

  @Column
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id", nullable = false),
          inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
  private List<Role> roles;
}
