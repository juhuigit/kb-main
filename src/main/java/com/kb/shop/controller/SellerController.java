package com.kb.shop.controller;

import com.kb.shop.domain.Promotion;
import com.kb.shop.domain.Seller;
import com.kb.shop.service.PromotionService;
import com.kb.shop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// 클래스 선언 및 애노테이션:
// @RestController: 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다.
@RestController
// @RequestMapping("/seller"): 이 컨트롤러가 /seller 경로와 매핑됨을 나타낸다.
@RequestMapping("/seller")
public class SellerController {

    // 필드 선언 및 의존성 주입:
    // @Autowired: 스프링 프레임워크가 SellerService 타입의 빈을 자동으로 주입하도록 한다.
    @Autowired
    // private SellerService sellerService: SellerService 타입의 서비스 객체를 필드로 선언한다.
    private SellerService sellerService;

    // 메서드 선언:
    // @GetMapping("/{id}"): 이 메서드는 HTTP GET 요청을 /seller/{id} 경로로 매핑한다.
    @GetMapping("/{id}")
    // 이 메서드는 URL 경로에서 id 값을 추출하여 Seller 객체를 반환한다.
    public ResponseEntity<Seller> getSellerInfo(@PathVariable Long id) {
        // 객체 생성 및 서비스 호출:
        // 새로운 Seller 객체를 생성한다.
        Seller seller = new Seller();
        // sellerService의 getSellerInfo 메서드를 호출하여 id에 해당하는 판매자 정보를 가져온다.
        seller = sellerService.getSellerInfo(id);

        // 조건문 및 응답 반환:
        // 판매자 정보가 존재하면
        if (seller != null) {
            //  HTTP 상태 코드 200(OK)와 함께 seller 객체를 반환한다.
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } else { // 판매자 정보가 없으면
            // HTTP 상태 코드 404(NOT_FOUND)를 반환한다.
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 메서드 선언:
    // 이 메서드는 HTTP DELETE 요청을 /seller/{id} 경로로 매핑한다.
    @DeleteMapping("/{id}")
    // 이 메서드는 URL 경로에서 id 값을 추출하여 판매자 정보를 삭제한다.
    public void deletePromotionInfo(@PathVariable Long id) {
        // sellerService의 deleteSellerInfo 메서드를 호출하여 id에 해당하는 판매자 정보를 삭제한다.
        sellerService.deleteSellerInfo(id);
    }

    // 메서드 선언:
    // 이 메서드는 HTTP POST 요청을 /seller/ 경로로 매핑한다.
    @PostMapping("/")
    // 이 메서드는 요청 본문에서 seller 객체를 추출하여 저장한다.
    public ResponseEntity<Seller> setSellerInfo(@RequestBody Seller seller) {
        // 객체 생성 및 서비스 호출:
        // 새로운 Seller 객체를 생성한다.
        Seller newSeller = new Seller();
        // sellerService의 setSellerInfo 메서드를 호출하여 seller 정보를 저장하고 반환된 newSeller 객체를 받는다.
        newSeller = sellerService.setSellerInfo(seller);
        // 조건문 및 응답 반환:
        // 새 판매자 정보가 존재하면
        if (newSeller != null) {
            // HTTP 상태 코드 200(OK)와 함께 newSeller 객체를 반환한다.
            return new ResponseEntity<>(newSeller, HttpStatus.OK);
        } else { // 새 판매자 정보가 없으면
            // HTTP 상태 코드 404(NOT_FOUND)를 반환한다.
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
