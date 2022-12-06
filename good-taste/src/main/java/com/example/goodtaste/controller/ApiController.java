package com.example.goodtaste.controller;


import com.example.goodtaste.wishlist.dto.WishListDto;
import com.example.goodtaste.wishlist.service.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "검색 API")
@RestController
@RequestMapping("/api/good-taste")
@RequiredArgsConstructor
public class ApiController {


    private final WishListService wishListService;

    @ApiOperation(value = "입력값 검색")
    @GetMapping("/search")
    public WishListDto search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping("/")
    public WishListDto add(@RequestBody WishListDto wishListDto) {
      log.info("{}", wishListDto);
        return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wishListService.delete(id);
    }

    @PostMapping("/{id}")
    public void addVisit(@PathVariable Long id) {
        wishListService.addVisit(id);
    }
}


