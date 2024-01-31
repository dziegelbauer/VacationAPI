package org.ziegelbauer.vacationapi.controllers;

import org.ziegelbauer.vacationapi.dto.Purchase;
import org.ziegelbauer.vacationapi.dto.PurchaseResponse;
import org.ziegelbauer.vacationapi.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
