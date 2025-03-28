package za.ac.cput.domain.entities;

public class Student {
    private final String studentId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Boolean status;
    private final String roomID;
    private final String leaderId;

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.status = builder.status;
        this.roomID = builder.roomID;
        this.leaderId = builder.leaderId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getLeaderId() {
        return leaderId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + (status ? "Active" : "Inactive") +
                ", roomId='" + roomID + '\'' +
                ", leaderId='" + leaderId + '\'' +
                '}';
    }

    public static class Builder {
        private String studentId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Boolean status;
        private String roomID;
        private String leaderId;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder status(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder roomId(String roomID) {
            this.roomID = roomID;
            return this;
        }

        public Builder leaderId(String leaderId) {
            this.leaderId = leaderId;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
