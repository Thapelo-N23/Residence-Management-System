package za.ac.cput.domain;




public class StaffEntity {
    private String staffID;
    private String firstName;
    private String lastName;
    private String email;
    private String role;



    public StaffEntity(String staffID, String firstName, String lastName, String email, String role) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;

    }

    public StaffEntity(Builder builder) {
    }

    public String getStaffID() {
        return staffID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "StaffEntity{" +
                "staffID='" + staffID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }
    public static class Builder{
        private String staffID;
        private String firstName;
        private String lastName;
        private String email;
        private String role;

        public Builder staffID(String staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder firstNAme(String firstName) {
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

        public Builder role (String role) {
            this.role = role;
            return this;
        }
        public StaffEntity build(){
            return new StaffEntity(this);
        }
    }

}
