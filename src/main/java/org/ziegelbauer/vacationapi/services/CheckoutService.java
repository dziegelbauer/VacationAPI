package org.ziegelbauer.vacationapi.services;

import org.ziegelbauer.vacationapi.dto.Purchase;
import org.ziegelbauer.vacationapi.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
