package org.ziegelbauer.vacationapi.services;

import org.ziegelbauer.vacationapi.dao.CustomerRepository;
import org.ziegelbauer.vacationapi.dto.Purchase;
import org.ziegelbauer.vacationapi.dto.PurchaseResponse;
import org.ziegelbauer.vacationapi.entities.Cart;
import org.ziegelbauer.vacationapi.entities.CartItem;
import org.ziegelbauer.vacationapi.entities.Customer;
import org.ziegelbauer.vacationapi.entities.StatusType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Input validation here
        if(purchase.getCustomer() == null
            || purchase.getCart() == null
            || purchase.getCartItems() == null
            || purchase.getCartItems().isEmpty()) {
            return new PurchaseResponse("Invalid purchase request");
        }

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::addCartItem);

        Customer customer = purchase.getCustomer();
        customer.addCart(cart);

        cart.setStatus(StatusType.ordered);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
