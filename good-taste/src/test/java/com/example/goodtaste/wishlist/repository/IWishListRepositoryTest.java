package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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
        Page<WishListEntity> wishListEntities = wishListRepository.findAll(PageRequest.of(1, 2, Sort.by(Sort.Order.desc("title"))));

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

    @Test
    void save() {
        wishListRepository.save(new WishListEntity().setTitle("Save title"));

        WishListEntity wishList = wishListRepository.findById(1L).orElseThrow(RuntimeException::new);
        wishList.setTitle("Update title");

        wishListRepository.save(wishList);
    }

    @Test
    void findByTitleTest() {

    }
}