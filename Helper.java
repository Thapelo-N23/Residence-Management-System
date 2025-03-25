package za.ac.cput.domain.util;

import za.ac.cput.domain.factory.RoomFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 9); // Generate a 9-char ID
    }

    public static boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("❌ Invalid email format: " + email);
            return false;
        }
        return true;


    }

    public static boolean isValidId(String leaderId) {
        if (leaderId == null || !leaderId.matches("\\d{9}")) { // Only numbers, length 9
            System.out.println("❌ Invalid ID: " + leaderId + " (Must be 6-9 digits)");
            return false;
        }
        return true;
    }

    //Staff Helper
    public static boolean isValid(String staffId) {
        if (staffId == null || !staffId.matches("STF\\d{6}")) { // Format: STF123456
            System.out.println("❌ Invalid Staff ID: " + staffId + " (Must follow 'STF' + 6 digits)");
            return false;
        }
        return true;
    }

    //Payment Helper
    // Validate payment ID format (must be 'PAY' followed by exactly 6 digits)
    public static boolean isValidPaymentId(String paymentId) {
        if (paymentId == null || !paymentId.matches("^PAY\\d{6}$")) { // Must be 'PAY' followed by exactly 6 digits
            System.out.println("❌ Invalid Payment ID: " + paymentId + " (Must be 'PAY' followed by 6 digits).");
            return false;
        }
        return true;
    }

    // Validate the amount (must be a positive value)
    public static boolean isValidAmount(String amount) {
        if (isNullOrEmpty(amount)) {
            return false;
        }
        try {
            double amountValue = Double.parseDouble(amount);
            return amountValue > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate if status is "true" (Paid) or "false" (Not Paid)
    public static boolean isValidStatus(String status) {
        return "true".equalsIgnoreCase(status) || "false".equalsIgnoreCase(status);
    }

    // Parse the payment date string into LocalDate (validate format)
    public static LocalDate parseDate(String paymentDate) {
        try {
            return LocalDate.parse(paymentDate);
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid date format: " + paymentDate + ". Expected format: YYYY-MM-DD.");
            return null;
        }
    }

}








