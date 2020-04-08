package com.brs.project.category.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name = "t_mt_category")
public class Category {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "cat_name")
    private String categoryName;
    @Column(name = "type")
    private String type;
}
