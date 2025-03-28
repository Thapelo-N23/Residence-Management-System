//222260971 Thapelo Ngwenya
//230640893 Phindile Lisa Ngozi
//230023967 Mengezi Junior Ngwenya
//230666426 Tsireledzo Netshilonwe
//230741754 Onako Ntsaluba
// 230277845 Olwethu Nene


package za.ac.cput.domain.factory;
import za.ac.cput.domain.entities.Staff;
import za.ac.cput.domain.util.Helper;



public class StaffFactory {
    public static Staff createStaff(String staffID, String firstName, String lastName, String email, String role) {
        if (Helper.isNullOrEmpty(staffID) || !Helper.isValidStaffID(staffID)) {
            System.out.println("⚠️ Warning: Provided ID is invalid or missing. Generating a new ID...");
            staffID = Helper.generateId(); // Generate a new valid ID
        }


        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(role)){
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
                .build();
    }
}
