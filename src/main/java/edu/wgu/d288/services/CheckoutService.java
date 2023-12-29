package edu.wgu.d288.services;

import edu.wgu.d288.dto.Purchase;
import edu.wgu.d288.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
