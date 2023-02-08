package com.bus_booking.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false, columnDefinition = "INT")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false, columnDefinition = "INT")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false, columnDefinition = "INT")
    private Driver driver;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE")
    private Date startDate;
}
