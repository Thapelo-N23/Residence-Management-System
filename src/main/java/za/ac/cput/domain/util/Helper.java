package za.ac.cput.domain.util;

import java.util.UUID;

public class Helper {
public  static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
}

    public static String generateId() {
        return UUID.randomUUID().toString().substring( 9); // Generate a 9-char ID
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
}
