package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListRepositoryTest {

    private WishListEntity wishListDummy;

    @Autowired
    public WishListRepository wishListRepository;

    @BeforeEach
    void setUp() {
        wishListDummy = new WishListEntity();
        wishListDummy.setTitle("title")
                .setCategory("category")
                .setAddress("address")
                .setReadAddress("readAddress")
                .setHomePageLink("")
                .setImageLink("")
                .setVisit(false)
                .setVisitCount(0)
                .setLastVisitDate(null);
    }

    private WishListEntity createDummy() {
        var wishListDummy = new WishListEntity();
        wishListDummy.setTitle("title")
                .setCategory("category")
                .setAddress("address")
                .setReadAddress("readAddress")
                .setHomePageLink("")
                .setImageLink("")
                .setVisit(false)
                .setVisitCount(0)
                .setLastVisitDate(null);

        return wishListDummy;
    }

    @Test
    public void saveTest() {
        var expected = wishListRepository.save(wishListDummy);
        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void updateTest() {
        var expected = wishListRepository.save(wishListDummy);

        expected.setTitle("Updated title");
        var updatedEntity = wishListRepository.save(wishListDummy);

        Assertions.assertEquals("Updated title", updatedEntity.getTitle());
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }

    @Test
    public void findById() {
        wishListRepository.save(wishListDummy);

        var expected = wishListRepository.findById(1);
        assertTrue(expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());

    }

    @Test
    public void deleteById() {
        wishListRepository.save(wishListDummy);
        wishListRepository.deleteById(1);
        int dbSize = wishListRepository.findAll().size();

        Assertions.assertEquals(0, dbSize);
    }

    @Test
    public void listAll() {
        wishListRepository.save(wishListDummy);

        var wishListDummy2 = createDummy();
        wishListRepository.save(wishListDummy2);

        System.out.println(wishListRepository.findAll());
        int dbSize = wishListRepository.findAll().size();
        Assertions.assertEquals(2, dbSize);
    }
}