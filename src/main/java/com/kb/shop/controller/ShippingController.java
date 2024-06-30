package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping
    public ResponseEntity<ShippingInfo> createShipping(@RequestBody ShippingInfo shippingInfo) {
        ShippingInfo newShippingInfo = shippingService.createShipping(shippingInfo);
        return new ResponseEntity<>(newShippingInfo, HttpStatus.CREATED);
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping/{id}/status)
    @PutMapping("/{id}/status")
    public ResponseEntity<ShippingInfo> updateShippingStatus(@PathVariable Long id, @RequestBody String status) {
        ShippingInfo updatedShippingInfo = shippingService.updateShippingStatus(id, status);
        if (updatedShippingInfo != null) {
            return new ResponseEntity<>(updatedShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 배송 정보를 확인하는 GET 호출을 생성합니다. (path : /shipping/{id})
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id) {
        ShippingInfo shippingInfo = shippingService.getShippingInfo(id);
        if (shippingInfo != null) {
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}