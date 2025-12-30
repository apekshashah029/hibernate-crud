package com.example.hibernate_crud.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    private String productName;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uId",nullable = true)
    @JsonManagedReference
    private User user;

}
