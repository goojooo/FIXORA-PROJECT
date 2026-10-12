package com.localservice.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.localservice.model.Booking;
import com.localservice.model.ServicePartner;
import com.localservice.model.User;
import com.localservice.repository.BookingRepository;
import com.localservice.repository.ServicePartnerRepository;
import com.localservice.repository.UserRepository;

@RestController
public class BookingController {

    @Autowired private BookingRepository bookingRepository;
    @Autowired private ServicePartnerRepository servicePartnerRepository;
    @Autowired private UserRepository userRepository;

    @PostMapping("/booking/create")
    public ResponseEntity<?> createBooking(
            @RequestParam Long partnerId,
            @RequestParam String customerName,
            @RequestParam String bookingDate,
            @RequestParam String timeSlot,
            @RequestParam String userEmail
    ) {
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            return ResponseEntity.status(401).body("User not found. Please log in with a user account.");
        }

        Booking booking = new Booking();
        booking.setPartnerId(partnerId);
        booking.setCustomerName(customerName);
        booking.setBookingDate(bookingDate);
        booking.setTimeSlot(timeSlot);
        booking.setUserEmail(user.getEmail());
        booking.setCity(user.getCity());
        booking.setStreetAddress(user.getStreetAddress());
        booking.setLandmark(user.getLandmark());
        booking.setPincode(user.getPincode());
        booking.setStatus("PENDING");
        booking.setPaymentStatus("UNPAID");

        ServicePartner partner = servicePartnerRepository
                .findById(partnerId)
                .orElseThrow();
        booking.setServiceType(partner.getServiceType());

        bookingRepository.save(booking);

        return ResponseEntity.ok(Map.of("bookingId", booking.getId()));
    }
}