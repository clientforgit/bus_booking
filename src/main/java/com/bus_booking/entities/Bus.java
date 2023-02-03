package com.bus_booking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "buses",
        uniqueConstraints = {@UniqueConstraint(name = "licence_plate_constraint", columnNames = "licence_plate_number")}
)
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false, columnDefinition = "INT")
    private BusModel model;

    @Column(name = "color", nullable = false, columnDefinition = "TEXT")
    private String color;

    @Column(name = "licence_plate_number", nullable = false, columnDefinition = "TEXT")
    private String licencePlateNumber;

    @Override
    public String toString() {
        return this.color + " " + this.model.getName() + ", " + this.licencePlateNumber;
    }
}