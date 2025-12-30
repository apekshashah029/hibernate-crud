package com.example.hibernate_crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@NamedQuery(
        name = "User.findUsersWithAtleastOneProduct",
        query = """
            select distinct u
            from User u
            join u.products p
        """
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uId;

    private String name;

    private int age;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Product> products;
}
