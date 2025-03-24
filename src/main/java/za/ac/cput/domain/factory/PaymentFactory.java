package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.util.Helper;
import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentID, String amount, boolean status, String paymentDate, String studentId) {
        // Validate paymentID (must be 'PAY' followed by 6 digits)
        if (!Helper.isValidPaymentId(paymentID)) {
            System.out.println("❌ Invalid payment ID. Could not create payment.");
            return null;
        }

        // Validate required fields
        if (Helper.isNullOrEmpty(amount) || Helper.isNullOrEmpty(paymentDate) || Helper.isNullOrEmpty(studentId)) {
            System.out.println("⚠️ Warning: Some required fields are empty.");
            return null;
        }

        // Validate the amount (positive value)
        if (!Helper.isValidAmount(amount)) {
            System.out.println("❌ Invalid payment amount: " + amount + " (Must be a positive decimal number).");
            return null;
        }

        // Validate the status (true or false)
        if (!Helper.isValidStatus(String.valueOf(status))) {
            System.out.println("❌ Invalid status: " + status + " (Must be true or false).");
            return null;
        }

        // Convert paymentDate to LocalDate
        LocalDate date = Helper.parseDate(paymentDate);
        if (date == null) {
            return null;
        }

        return new Payment.Builder()
                .paymentID(paymentID)
                .amount(Double.parseDouble(amount)) // Amount to be paid or paid
                .status(status) // True if paid, false if not paid
                .paymentDate(date)
                .studentId(studentId)
                .build();
    }
}