package edu.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Data
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;
    private String vacation_title;
    private String description;
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;
    @Column(name = "image_url")
    private String image_URL;
    @CreationTimestamp
    private Date create_date;
    @UpdateTimestamp
    private Date last_update;
    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;
}
