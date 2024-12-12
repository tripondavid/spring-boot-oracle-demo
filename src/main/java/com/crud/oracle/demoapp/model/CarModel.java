package com.crud.oracle.demoapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CarModels", uniqueConstraints = { @UniqueConstraint(columnNames = "modelName") })
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;
}
