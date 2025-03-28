package za.ac.cput.domain.entities;

import java.time.LocalDateTime;

public class MaintenanceRequest {
    private String requestId;
    private String studentId;
    private String roomId;
    private String issueDescription;
    private LocalDateTime requestDate;
    private boolean status; // Changed from String to boolean
    private String staffId;
    private String resolutionNotes;
    private LocalDateTime completionDate;

    private MaintenanceRequest(Builder builder) {
        this.requestId = builder.requestId;
        this.studentId = builder.studentId;
        this.roomId = builder.roomId;
        this.issueDescription = builder.issueDescription;
        this.requestDate = builder.requestDate;
        this.status = builder.status;
        this.staffId = builder.staffId;
        this.resolutionNotes = builder.resolutionNotes;
        this.completionDate = builder.completionDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public boolean isCompleted() { // Updated getter for status
        return status;
    }

    public String getStatusString() { // Converts boolean status to a readable format
        return status ? "Completed" : "Pending";
    }

    public String getStaffId() {
        return staffId;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "requestId='" + requestId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + getStatusString() + '\'' + // Converts boolean to "Completed"/"Pending"
                ", staffId='" + staffId + '\'' +
                ", resolutionNotes='" + resolutionNotes + '\'' +
                ", completionDate=" + completionDate +
                '}';
    }

    public boolean add(MaintenanceRequest request) {
        return false;
    }

    public String getRequestID() {

        return null;
    }

    public static class Builder {
        private String requestId;
        private String studentId;
        private String roomId;
        private String issueDescription;
        private LocalDateTime requestDate;
        private boolean status;
        private String staffId;
        private String resolutionNotes;
        private LocalDateTime completionDate;

        public Builder(String requestId, String studentId, String roomId, String issueDescription, LocalDateTime requestDate) {
            this.requestId = requestId;
            this.studentId = studentId;
            this.roomId = roomId;
            this.issueDescription = issueDescription;
            this.requestDate = requestDate;
            this.status = false; // Default to "Pending" (false)
        }

        public Builder status(boolean status) {
            this.status = status;
            return this;
        }

        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder resolutionNotes(String resolutionNotes) {
            this.resolutionNotes = resolutionNotes;
            return this;
        }

        public Builder completionDate(LocalDateTime completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public MaintenanceRequest build() {
            return new MaintenanceRequest(this);
        }
    }
}
