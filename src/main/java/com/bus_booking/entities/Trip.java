package com.bus_booking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "trips")
public class Trip {
    @EmbeddedId
    private TripPrimaryKey id;

    @Column(name = "from_city_name")
    private String fromCityName;

    @Column(name = "to_city_name")
    private String toCityName;

    @Column(name = "from_timestamp")
    private Timestamp fromTimestamp;

    @Column(name = "to_timestamp")
    private Timestamp toTimestamp;
}
