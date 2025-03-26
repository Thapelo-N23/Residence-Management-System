package za.ac.cput.domain.factory;

import za.ac.cput.domain.MaintenanceRequest;
import za.ac.cput.domain.util.Helper;
import java.time.LocalDateTime;

public class MaintenanceRequestFactory {

    public static MaintenanceRequest createMaintenanceRequest(String requestId, String studentId, String roomId, String issueDescription, LocalDateTime requestDate, String status, String staffId, String resolutionNotes, LocalDateTime completionDate) {
        if (Helper.isNullOrEmpty(requestId) || !Helper.isValidId(requestId)) {
            System.out.println("!Warning: Provided Request ID is invalid or missing. Generating a new ID...");
            requestId = Helper.generateId();
        }

        if (Helper.isNullOrEmpty(roomId)) {
            System.out.println("!Error: Room ID must not be empty.");
            return null;
        }

        if (Helper.isNullOrEmpty(studentId) || Helper.isNullOrEmpty(issueDescription)) {
            System.out.println("!Error: Student ID and Issue Description must not be empty.");
            return null;
        }

        // Convert status String to boolean
        boolean statusBoolean = "Completed".equalsIgnoreCase(status);

        return new MaintenanceRequest.Builder(requestId, studentId, roomId, issueDescription, requestDate)
                .status(statusBoolean) // Updated to boolean
                .staffId(staffId)
                .resolutionNotes(resolutionNotes)
                .completionDate(completionDate)
                .build();
    }
}


