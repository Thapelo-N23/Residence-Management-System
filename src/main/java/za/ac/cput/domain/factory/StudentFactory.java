//222260971 Thapelo Ngwenya
//230640893 Phindile Lisa Ngozi
//230023967 Mengezi Junior Ngwenya
//230666426 Tsireledzo Netshilonwe
//230741754 Onako Ntsaluba
// 230277845 Olwethu Nene

package za.ac.cput.domain.factory;

import za.ac.cput.domain.entities.Student;
import za.ac.cput.domain.util.Helper;

public class StudentFactory {

    public static Student createStudent(String studentId, String firstName, String lastName, String email,
                                        String phoneNumber, Boolean status, String roomID, String leaderId) {
        // Validate required fields
        if (Helper.isNullOrEmpty(studentId) || !Helper.isValidStudentId(studentId)) {
            studentId = Helper.generateId(); // Auto-generate ID if invalid
        }

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                status == null || Helper.isNullOrEmpty(roomID) || Helper.isNullOrEmpty(leaderId)) {
            return null; // Return null if any required field is missing
        }

        // Validate email & phone number.
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
                .roomId(roomID)
                .leaderId(leaderId)
                .build();
    }
}