package com.example.hibernate_crud.repository;

import com.example.hibernate_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // 1. Derived query (already present in jparepository)

    // 2. JPQL Query
    @Query("""
        select u.uId, u.name, sum(p.quantity)
        from User u
        join u.products p
        group by u.uId, u.name
        having sum(p.quantity) > 10
    """)
    List<Object[]> findUsersWithHighTotalQuantity();


    // 3. NamedQuery
    @Query(name = "User.findUsersWithAtleastOneProduct")
    List<User> findUsersWithProducts();

    // 4. Criteria Query

}
