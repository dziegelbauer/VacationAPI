package org.ziegelbauer.vacationapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Data
@EqualsAndHashCode(exclude = "vacation")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;
    private String excursion_title;
    private BigDecimal excursion_price;
    @Column(name = "image_url")
    private String image_URL;
    @CreationTimestamp
    private Date create_date;
    @UpdateTimestamp
    private Date last_update;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;
    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            inverseJoinColumns = @JoinColumn(name = "cart_item_id"),
            joinColumns = @JoinColumn(name = "excursion_id"))
    private Set<CartItem> cartItems;
}
