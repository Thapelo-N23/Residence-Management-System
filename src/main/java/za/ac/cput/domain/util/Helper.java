package za.ac.cput.domain.util;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;


public class Helper {

    // Check if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Generate a 9-digit numeric ID
    public static String generateNumericId() {
        return String.format("%09d", Math.abs(UUID.randomUUID().getMostSignificantBits()) % 1_000_000_000);
    }

    public static boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("❌ Invalid email format: " + email);
            return false;
        }
        return true;


    }

    // Validate a 9-digit numeric ID
    public static boolean isValidId(String leaderId) {
        if (leaderId == null || !leaderId.matches("\\d{9}")) { // Only numbers, length 9
            System.out.println("❌ Invalid ID: " + leaderId + " (Must be 9 digits)");
            return false;
        }
        return true;
}

    // Validate staff ID format (Must start with 'S' followed by 4 digits)
    public static boolean isValidStaffID(String staffID) {
        return staffID != null && staffID.matches("^S\\d{4}$");
    }

    // Validate payment ID format ('PAY' followed by 6 digits)
    public static boolean isValidPaymentId(String paymentId) {
        return paymentId != null && paymentId.matches("^PAY\\d{6}$");
    }

    // Validate payment amount (Must be positive)
    public static boolean isValidAmount(String amount) {
        if (isNullOrEmpty(amount)) return false;
        try {
            return Double.parseDouble(amount) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Validate status (Must be 'true' or 'false')
    public static boolean isValidStatus(String status) {
        return "true".equalsIgnoreCase(status) || "false".equalsIgnoreCase(status);
    }

    // Parse date string into LocalDate (Validate format: YYYY-MM-DD)
    public static LocalDate parseDate(String paymentDate) {
        try {
            return LocalDate.parse(paymentDate);
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid date format: " + paymentDate + ". Expected format: YYYY-MM-DD.");
            return null;
        }
    }

    // Validate maintenance request ID ('REQ' followed by 6 digits)
    public static boolean isValidRequestId(String requestId) {
        return requestId != null && requestId.matches("REQ\\d{6}");
    }

    // Validate maintenance request status
    public static boolean isValidStatusForRequest(String status) {
        String[] validStatuses = {"Pending", "In Progress", "Completed", "Cancelled"};
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

    // Parse and validate DateTime format (YYYY-MM-DD HH:MM:SS)
    public static LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid Date-Time format: " + dateTime + ". Expected format: YYYY-MM-DD HH:MM:SS.");
            return null;
        }
    }

    // Validate student ID ('STU' followed by 6 digits)
    public static boolean isValidStudentId(String studentId) {
        return studentId != null && studentId.matches("STU\\d{6}");
    }

    // Validate phone number (Must be exactly 10 digits)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{

}

public void main() {
}

}
