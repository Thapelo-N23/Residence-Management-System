package za.ac.cput.domain;

public class Staff {
    private String staffID;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String leaderID; // FK Reference to Residence

    private Staff(Builder builder) {
        this.staffID = builder.staffID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.role = builder.role;
        this.leaderID = builder.leaderID;
    }

    public String getStaffID() { return staffID; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getLeaderID() { return leaderID; } // FK Getter

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", leaderID='" + leaderID + '\'' + // Show FK
                '}';
    }

    public static class Builder {
        private String staffID;
        private String firstName;
        private String lastName;
        private String email;
        private String role;
        private String leaderID; // FK Reference

        public Builder setStaffID(String staffID) {
            this.staffID = staffID;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setRole(String role) {
            this.role = role;
            return this; }
        public Builder setLeaderID(String leaderID) {
            this.leaderID = leaderID;
            return this;
        }

        public Builder copy(Staff staff) {
            this.staffID = staff.staffID;
            this.firstName = staff.firstName;
            this.lastName = staff.lastName;
            this.email = staff.email;
            this.role = staff.role;
            this.leaderID = staff.leaderID; // Copy FK
            return this;
        }

        public Staff build() { return new Staff(this); }
    }
}
