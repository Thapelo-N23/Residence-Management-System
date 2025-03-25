package za.ac.cput.domain.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.util.Helper;

public class StudentFactory {

    public static Student createStudent(String studentId, String firstName, String lastName, String email,
                                        String phoneNumber, Boolean status, String roomId, String leaderId) {

        if (Helper.isNullOrEmpty(studentId)) {
            System.out.println("Warning: Provided Student ID is missing or Invalid. Generating a new ID...");
            studentId = Helper.generateId();
        }

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(phoneNumber) || status == null || Helper.isNullOrEmpty(roomId) || Helper.isNullOrEmpty(leaderId)) {
            System.out.println("Warning: Some required fields are missing.");
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return null;
        }

        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number format.");
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