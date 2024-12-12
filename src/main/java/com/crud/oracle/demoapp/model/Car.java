package com.crud.oracle.demoapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cars", uniqueConstraints = { @UniqueConstraint(columnNames = "vin") })
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModel carModel;

    @Column(nullable = false)
    private int yearOfProduction;

    @Override
    public String toString() {
        return "Car{" +
                "carModelDto=" + carModel +
                ", id=" + id +
                ", vin='" + vin + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
