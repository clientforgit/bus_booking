package com.bus_booking.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false, columnDefinition = "INT")
    private Journey journey;

    @Column(name = "seat_number", nullable = false, columnDefinition = "INT")
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "stop_number_from", nullable = false, columnDefinition = "INT")
    private Stop from;

    @ManyToOne
    @JoinColumn(name = "stop_number_to", nullable = false, columnDefinition = "INT")
    private Stop to;

    @Column(name = "price", nullable = false, columnDefinition = "INT")
    private int price;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    private Timestamp createdAt;
}
