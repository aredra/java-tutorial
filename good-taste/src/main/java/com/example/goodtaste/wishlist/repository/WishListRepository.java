package com.example.goodtaste.wishlist.repository;

import com.example.goodtaste.db.MemoryDbRepositoryAbstract;
import com.example.goodtaste.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
