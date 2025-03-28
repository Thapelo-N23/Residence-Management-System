package za.ac.cput.domain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.Residence;
import za.ac.cput.domain.repository.ResidenceRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceRepositoryTest {
    private ResidenceRepository repository;
    private Residence residence;

    @BeforeEach
    void setUp() {
        repository = (ResidenceRepository) ResidenceRepository.getIRepository();

        residence = new Residence.Builder()
                .setLeaderID("222260971")
                .setName("Thapelo Ngwenya")
                .setEmail("thapelo_n@icloud.com")
                .setAssignedBlock("Cape Town")
                .build();

        repository.create(residence);
    }

    @Test
    void testCreate() {
        Residence created = repository.create(residence);
        assertNotNull(created);
        assertEquals(residence.getLeaderID(), created.getLeaderID());
    }

    @Test
    void testRead() {
        Residence found = repository.read(residence.getLeaderID());
        assertNotNull(found);
        assertEquals(residence.getLeaderID(), found.getLeaderID());
    }

    @Test
    void testUpdate() {
        Residence updatedResidence = new Residence.Builder()
                .setLeaderID(residence.getLeaderID())
                .setName("Sunset Hall") // Changed Name
                .setAssignedBlock("Cape Town")
                .build();

        Residence updated = repository.update(updatedResidence);
        assertNotNull(updated);
        assertEquals("Sunset Hall", updated.getName());
    }

    @Test
    void testDelete() {
        boolean success = repository.delete(residence.getLeaderID());
        assertTrue(success);
        assertNull(repository.read(residence.getLeaderID()));
    }

    @Test
    void testGetAll() {
        Set<Residence> residenceSet = repository.getAll();
        assertFalse(residenceSet.isEmpty());
        assertTrue(residenceSet.contains(residence));
    }
}
