package edu.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Data
@EqualsAndHashCode(exclude = "country")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;
    @Column(name = "division")
    private String division_name;
    @CreationTimestamp
    private Date create_date;
    @UpdateTimestamp
    private Date last_update;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;
    @OneToMany(mappedBy = "division")
    private Set<Customer> customers;
}
