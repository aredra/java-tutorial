package com.example.goodtaste.wishlist.service;

import com.example.goodtaste.naver.NaverClient;
import com.example.goodtaste.naver.dto.SearchImageReq;
import com.example.goodtaste.naver.dto.SearchLocalReq;
import com.example.goodtaste.wishlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public WishListDto search(String query) {

        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if (searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);
            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                var result = new WishListDto();
                result.setTitle(localItem.getTitle())
                        .setCategory(localItem.getCategory())
                        .setAddress(localItem.getAddress())
                        .setRoadAddress(localItem.getRoadAddress())
                        .setHomePageLink(localItem.getLink())
                        .setImageLink(imageItem.getLink());

                return result;
            }
        }

        return new WishListDto();
    }
}
