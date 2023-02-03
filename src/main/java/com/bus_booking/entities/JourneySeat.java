package com.bus_booking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "journey_seats")
public class JourneySeat implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;


    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @ManyToOne
    @JoinColumn(name = "stop_id_from")
    private Stop from;

    @ManyToOne
    @JoinColumn(name = "stop_id_to")
    private Stop to;

    @Column(name = "timestamp_from")
    private Timestamp timestampFrom;

    @Column(name = "timestamp_to")
    private Timestamp timestampTo;
}
