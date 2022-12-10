package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Slf4j
@SpringBootTest
class IWishListRepositoryTest {

    @Autowired
    private IWishListRepository wishListRepository;

    @Test
    void initSetTest(){
        wishListRepository.findAll().forEach(System.out::println);
        Assertions.assertEquals(5, wishListRepository.findAll().size());
    }

    @Test
    void deleteAllInBatch() {
        wishListRepository.deleteAllInBatch();
        Assertions.assertEquals(0, wishListRepository.findAll().size());
    }

    @Test
    void paging() {
        Page<WishListEntity> wishListEntities = wishListRepository.findAll(PageRequest.of(1, 2));

        wishListEntities.getContent().forEach(item -> log.debug("{}", item));

        Assertions.assertEquals(5, wishListEntities.getTotalElements());
        Assertions.assertEquals(3, wishListEntities.getTotalPages());
        Assertions.assertEquals(2, wishListEntities.getNumberOfElements());
    }

    @Test
    void QueryByExample() {
        WishListEntity wishList = new WishListEntity();
        wishList.setTitle("test");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("")
                .withMatcher("email", new ExampleMatcher.GenericPropertyMatcher().endsWith());

        Example<WishListEntity> example = Example.of(wishList, matcher);
        wishListRepository.findAll(example);
    }
}