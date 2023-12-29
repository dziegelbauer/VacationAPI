package edu.wgu.d288.services;

import edu.wgu.d288.dao.CustomerRepository;
import edu.wgu.d288.dto.Purchase;
import edu.wgu.d288.dto.PurchaseResponse;
import edu.wgu.d288.entities.Cart;
import edu.wgu.d288.entities.CartItem;
import edu.wgu.d288.entities.Customer;
import edu.wgu.d288.entities.StatusType;
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
