package com.bus_booking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journey_stops")
public class JourneyStop {
    @EmbeddedId
    private JourneyStopPrimaryKey id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "timestamp")
    private Timestamp timestamp;
}
