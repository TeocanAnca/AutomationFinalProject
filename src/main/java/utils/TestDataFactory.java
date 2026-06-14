package utils;

import dto.BookingDto;

import java.time.LocalDate;
import java.util.UUID;

public class TestDataFactory {

    public static BookingDto createNewBooking() {
        String uniqueSuffix = UUID.randomUUID().toString().substring(0, 6);
        int totalPrice = (int) (System.currentTimeMillis() % 1000);
        String checkIn = LocalDate.now().toString();
        String checkOut = LocalDate.now().plusDays(1).toString();

        return BookingDto.builder()
                .firstName("Anca_" + uniqueSuffix)
                .lastName("Teocan_" + uniqueSuffix)
                .totalPrice(totalPrice)
                .depositPaid(true)
                .bookingDates(
                        BookingDto.DatesDto.builder()
                                .checkIn(checkIn)
                                .checkOut(checkOut)
                                .build()
                )
                .additionalNeeds("Breakfast")
                .build();
    }
}
