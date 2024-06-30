package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public ShippingInfo createShipping(ShippingInfo shippingInfo) {
        return shippingRepository.save(shippingInfo);
    }

    public ShippingInfo getShippingInfo(Long id) {
        return shippingRepository.findById(id).orElse(null);
    }

    public ShippingInfo updateShippingStatus(Long id, String status) {
        ShippingInfo shippingInfo = shippingRepository.findById(id).orElse(null);
        if (shippingInfo != null) {
            shippingInfo.setShippingStatus(status);
            shippingRepository.save(shippingInfo);
        }
        return shippingInfo;
    }
}
