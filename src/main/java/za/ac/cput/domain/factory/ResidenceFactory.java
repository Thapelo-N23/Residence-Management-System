package za.ac.cput.domain.factory;

import za.ac.cput.domain.entities.Residence;
import za.ac.cput.domain.util.Helper;

public class ResidenceFactory {

    public static Residence createResidence(String leaderId, String name, String email, String assignedBlock) {

        if (Helper.isNullOrEmpty(leaderId) || !Helper.isValidId(leaderId)) {
            System.out.println("⚠️ Warning: Provided ID is invalid or missing. Generating a new ID...");
            leaderId = Helper.generateId(); // Generate a new valid ID
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
