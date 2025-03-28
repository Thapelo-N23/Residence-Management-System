package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Residence;

import java.util.*;
import java.util.stream.Collectors;

public class ResidenceRepository implements IResidenceRepository {

    private static IResidenceRepository repository = null;
    private List<Residence> residenceList;

    private ResidenceRepository() {
        residenceList = new ArrayList<>();
    }

    public static IResidenceRepository getIRepository() {
        if (repository == null) {
            repository = new ResidenceRepository();
        }
        return repository;
    }

    @Override
    public Residence create(Residence residence) {
        boolean success = residenceList.add(residence);
        return success ? residence : null;
    }

    // ✅ Lambda Expression Used Here
    @Override
    public Residence read(String leaderId) {
        return residenceList.stream()
                .filter(residence -> residence.getleaderId().equals(leaderId))
                .findFirst()
                .orElse(null);
    }

    // ✅ Lambda for update
    public Residence update(Residence residence) {
        boolean removed = delete(residence.getLeaderID()); // ✅ Delete old entry
        if (removed) {
            residenceList.add(residence); // ✅ Add updated entry
            return residence;
        }
        return null; // ✅ Return null if update fails
    }

    // ✅ Lambda for delete
    @Override
    public boolean delete(String id) {
        return residenceList.removeIf(residence -> residence.getleaderId().equals(id));
    }

    // ✅ Lambda for getAll
    @Override
    public Set<Residence> getAll() {
        return new HashSet<>(residenceList);
    }
}
