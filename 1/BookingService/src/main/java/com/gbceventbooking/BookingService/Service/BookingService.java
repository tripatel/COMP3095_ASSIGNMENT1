package com.gbceventbooking.BookingService.Service;

import com.gbceventbooking.BookingService.Model.Booking;
import com.gbceventbooking.BookingService.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(String id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(String id, Booking booking) {
        Booking existingBooking = getBookingById(id);
        if (existingBooking != null) {
            existingBooking.setRoomId(booking.getRoomId());
            existingBooking.setUserId(booking.getUserId());
            existingBooking.setStartDate(booking.getStartDate());
            existingBooking.setEndDate(booking.getEndDate());
            return bookingRepository.save(existingBooking);
        }
        return null;
    }

    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }
}
