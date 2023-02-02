package com.bus_booking.services;

public interface EmailSender {
    void sendHtml(String text, String toEmail);
}
