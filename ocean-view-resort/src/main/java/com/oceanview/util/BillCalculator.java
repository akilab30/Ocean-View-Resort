package com.oceanview.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BillCalculator {

    public static double calculateBill(
            LocalDate checkIn,
            LocalDate checkOut,
            String roomType) {

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        if (nights <= 0) {
            throw new IllegalArgumentException("Invalid dates");
        }

        double rate;
        switch (roomType) {
            case "Single":
            case "Standard": // Treat Standard as Single rate for compatibility
                rate = 5000;
                break;
            case "Double":
                rate = 10000;
                break;
            case "Deluxe":
                rate = 12000;
                break;
            default:
                throw new IllegalArgumentException("Invalid room type");
        }

        return nights * rate;
    }
}