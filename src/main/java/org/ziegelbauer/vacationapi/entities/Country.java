package org.ziegelbauer.vacationapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;
    @Column(name = "country")
    private String country_name;
    @CreationTimestamp
    private Date create_date;
    @UpdateTimestamp
    private Date last_update;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions;
}
