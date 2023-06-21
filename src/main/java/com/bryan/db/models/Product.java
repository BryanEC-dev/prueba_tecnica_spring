package com.bryan.db.models;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
