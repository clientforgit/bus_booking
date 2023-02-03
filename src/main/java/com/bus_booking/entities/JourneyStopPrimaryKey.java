package com.bus_booking.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JourneyStopPrimaryKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;
}
