package com.example.goodtaste.naver;

import com.example.goodtaste.naver.dto.SearchImageReq;
import com.example.goodtaste.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest() {

        var search = new SearchLocalReq();
        search.setQuery("만두");

        var result = naverClient.searchLocal(search);
        System.out.println(result);
    }


    @Test
    public void searchImageTest() {

        var search = new SearchImageReq();
        search.setQuery("만두");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }
}