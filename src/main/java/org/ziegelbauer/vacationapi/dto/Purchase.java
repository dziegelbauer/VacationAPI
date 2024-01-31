package org.ziegelbauer.vacationapi.dto;

import org.ziegelbauer.vacationapi.entities.Cart;
import org.ziegelbauer.vacationapi.entities.CartItem;
import org.ziegelbauer.vacationapi.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Cart cart;
    private Set<CartItem> cartItems;
    private Customer customer;
}