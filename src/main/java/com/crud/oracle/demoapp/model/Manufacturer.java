package com.crud.oracle.demoapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Manufacturers", uniqueConstraints = { @UniqueConstraint(columnNames = "manufacturerName") })
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String manufacturerName;

    @Column(nullable = false)
    private String countryOfOrigin;
}
