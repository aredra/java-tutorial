package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface IWishListRepository extends JpaRepository<WishListEntity, Long> {

    List<WishListEntity> findByTitle(String title);

    WishListEntity findFirst1ByTitle(String title);

    List<WishListEntity> findTop2ByTitle(String title);

    List<WishListEntity> findByTitleAndAddress(String title, String address);

    List<WishListEntity> findByTitleOrAddress(String title, String address);

    List<WishListEntity> findByCreatedAtAfter(OffsetDateTime yesterday);

    List<WishListEntity> findByIdAfter(Long id);

    List<WishListEntity> findByCreatedAtGreaterThan(OffsetDateTime yesterday);

    List<WishListEntity> findByCreatedAtGreaterThanEqual(OffsetDateTime yesterday);

    List<WishListEntity> findByCreatedAtBetween(OffsetDateTime from, OffsetDateTime to);

    List<WishListEntity> findByIdGreaterThanEqualAndIdLessThanEqual(Long from, Long to);

    List<WishListEntity> findByIdIsNotNull();

    // 컬렉션이 비어있는지 확인하는 용도
    List<WishListEntity> findByIdIsNotEmpty();

    List<WishListEntity> findByTitleIn(List<String> titles);

    List<WishListEntity> findByTitleContains(String title);

    List<WishListEntity> findByTitleStartingWith(String title);

    List<WishListEntity> findByTitleEndingWith(String title);

    List<WishListEntity> findByTitleLike(String title);

    List<WishListEntity> findByTitleIs(String title);
}