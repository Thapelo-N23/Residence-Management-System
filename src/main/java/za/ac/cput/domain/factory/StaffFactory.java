package za.ac.cput.domain.factory;
import za.ac.cput.domain.Staff;
import za.ac.cput.domain.util.Helper;



public class StaffFactory {
    public static Staff createStaff(String staffID, String firstName, String lastName, String email, String role, String leaderID) {
        if (Helper.isNullOrEmpty(staffID) || !Helper.isValidId(staffID)) {
            System.out.println("⚠️ Warning: Provided ID is invalid or missing. Generating a new ID...");
            staffID = Helper.generateId(); // Generate a new valid ID
        }


        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(role) || Helper.isNullOrEmpty(leaderID)) {
            return null;

        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        return new Staff.Builder()
                .setStaffID(staffID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setRole(role)
                .setLeaderID(leaderID)
                .build();
    }
}
