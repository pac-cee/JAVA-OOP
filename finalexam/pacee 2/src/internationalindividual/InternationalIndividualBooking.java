package internationalindividual;

import tourbooking.TourBooking;
import java.time.LocalDate;
import java.time.Period;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class InternationalIndividualBooking extends TourBooking {
    private static final double BOOKING_FEE_USD = 100.0;
    private static final double EXCHANGE_RATE = 1000.0;
    private static final double INTERNATIONAL_TAX = 0.05;
    private static final double RWANDA_DISCOUNT = 0.05;
    private static final double EAST_AFRICA_DISCOUNT = 0.04;

    public InternationalIndividualBooking(String bookingId, String travelerName, LocalDate dateOfBirth,
                                        String nationality, String travelLocation, LocalDate startDate,
                                        LocalDate endDate, String passportNumber, int groupSize,
                                        String hotelName, String preferredTourGuide) {
        super(bookingId, travelerName, dateOfBirth, nationality, travelLocation, startDate,
              endDate, passportNumber, groupSize, hotelName, preferredTourGuide);
    }

    @Override
    public boolean validateTravelAge() throws Exception {
        if (dateOfBirth == null) {
            throw new Exception("Date of birth cannot be null");
        }

        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if (age < 20 || age > 50) {
            throw new Exception("Age must be between 20 and 50 years");
        }
        return true;
    }

    @Override
    public boolean validateDates() throws Exception {
        LocalDate today = LocalDate.now();


        if (ChronoUnit.DAYS.between(today, startDate) < 3) {
            throw new Exception("Booking must be made at least 3 days in advance");
        }
        if (startDate.isAfter(endDate)) {
            throw new Exception("Start date must be before end date");
        }
        if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                startDate.getDayOfWeek() == DayOfWeek.SUNDAY ||
                endDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                endDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new Exception("Booking can only be made for weekdays");
        }

        return true;
    }

    @Override
    public boolean validateBookingLocation() throws Exception {
        if (travelLocation == null || travelLocation.trim().isEmpty()) {
            throw new Exception("Travel location cannot be empty");
        }


        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new Exception("Passport number is mandatory for international bookings");
        }


        List<String> rwandaLocations = Arrays.asList("virunga", "akagera", "nyungwe");
        if (rwandaLocations.contains(travelLocation.toLowerCase())) {
            throw new Exception("International bookings must be for destinations outside Rwanda");
        }

        return true;
    }

    @Override
    public double calculateBookingFee() throws Exception {

        double fee = BOOKING_FEE_USD * EXCHANGE_RATE;


        fee = fee * (1 + INTERNATIONAL_TAX);


        if (nationality.equalsIgnoreCase("rwanda")) {
            fee = fee * (1 - RWANDA_DISCOUNT);
        } else if (Arrays.asList("kenya", "uganda", "tanzania", "burundi", "south sudan")
                .contains(nationality.toLowerCase())) {
            fee = fee * (1 - EAST_AFRICA_DISCOUNT);
        }

        return fee;
    }
} 