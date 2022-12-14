package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IWishListRepository extends JpaRepository<WishListEntity, Long> {

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findLimit1();
}