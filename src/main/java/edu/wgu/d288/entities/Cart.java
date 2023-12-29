package edu.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Data
@EqualsAndHashCode(exclude = "customer")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;
    private BigDecimal package_price;
    private int party_size;
    @Enumerated(EnumType.STRING)
    private StatusType status;
    @CreationTimestamp
    private Date create_date;
    @UpdateTimestamp
    private Date last_update;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem;

    public void addCartItem(CartItem item) {
        if(item != null) {
            if(cartItem == null) {
                cartItem = new HashSet<>();
            }

            cartItem.add(item);
            item.setCart(this);
        }
    }
}
