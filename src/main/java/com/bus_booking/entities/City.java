package com.bus_booking.entities;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "cities",
        uniqueConstraints = {@UniqueConstraint(name = "name_constraint", columnNames = "name")}
)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;
}