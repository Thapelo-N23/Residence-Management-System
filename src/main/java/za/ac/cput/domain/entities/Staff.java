package za.ac.cput.domain.entities;

public class Staff {
    private String staffID; // Removed static modifier
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    // Private constructor to enforce Builder pattern
    private Staff(Builder builder) {
        this.staffID = builder.staffID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.role = builder.role;
    }

    // Getter methods
    public String getStaffID() {
        return staffID;
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

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private String staffID;
        private String firstName;
        private String lastName;
        private String email;
        private String role;

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
            return this;
        }

        // Build method to create a Staff object
        public Staff build() {
            return new Staff(this);
        }
    }
}
