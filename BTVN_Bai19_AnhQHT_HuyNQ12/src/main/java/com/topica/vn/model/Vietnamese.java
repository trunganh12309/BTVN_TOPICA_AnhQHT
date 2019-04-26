package com.topica.vn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table
public class Vietnamese {

  public Vietnamese() {
  }

  public Vietnamese(String content, String translate){
    this.translate = translate;
    this.content = content;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String content;

  @Column(columnDefinition = "text")
  private String translate;
}
