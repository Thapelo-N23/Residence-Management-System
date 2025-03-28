//222260971 Thapelo Ngwenya
//230640893 Phindile Lisa Ngozi
//230023967 Mengezi Junior Ngwenya
//230666426 Tsireledzo Netshilonwe
//230741754 Onako Ntsaluba
// 230277845 Olwethu Nene

package za.ac.cput.domain.factory;

import za.ac.cput.domain.entities.Residence;
import za.ac.cput.domain.util.Helper;

public class ResidenceFactory {

    public static Residence createResidence(String leaderId, String name, String email, String assignedBlock) {

        if (Helper.isNullOrEmpty(leaderId) || !Helper.isValidId(leaderId)) {
            System.out.println("⚠️ Warning: Provided ID is invalid or missing. Generating a new ID...");
            leaderId = String.valueOf(Helper.isValidId("222260971")); // Generate a new valid ID
        }

        if (Helper.isNullOrEmpty(leaderId)  || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(assignedBlock) ) {
            return null;


        }    if (!Helper.isValidEmail(email))
            return null;

        return new Residence.Builder()
                .setLeaderID(leaderId)
                .setName(name)
                .setEmail(email)
                .setAssignedBlock(assignedBlock).build();

    }

}