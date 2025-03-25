package za.ac.cput.domain.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.util.Helper;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.util.Helper;

public class StudentFactory {

    public static Student createStudent(String studentId, String firstName, String lastName, String email,
                                        String phoneNumber, Boolean status, String roomId, String leaderId) {
        // Validate required fields
        if (Helper.isNullOrEmpty(studentId) || !Helper.isValidStudentId(studentId)) {
            studentId = Helper.generateId(); // Auto-generate ID if invalid
        }

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                status == null || Helper.isNullOrEmpty(roomId) || Helper.isNullOrEmpty(leaderId)) {
            return null; // Return null if any required field is missing
        }

        // Validate email & phone number
        if (!Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(phoneNumber)) {
            return null;
        }

        return new Student.Builder()
                .studentId(studentId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .status(status)
                .roomId(roomId)
                .leaderId(leaderId)
                .build();
    }
}
