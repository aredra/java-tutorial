package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IWishListRepositoryTest {

    @Autowired
    private IWishListRepository wishListRepository;

    @Test
    void create(){
        wishListRepository.findAll().forEach(System.out::println);
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }
}