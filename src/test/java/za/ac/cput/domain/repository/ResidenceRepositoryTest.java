package za.ac.cput.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.Residence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

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
                .setAssignedBlock("Block D")
                .build();
    }

    @Test
    void testCreate() {
        Residence created = repository.create(residence);
        assertNotNull(created);
        assertEquals(residence.getLeaderID(), created.getLeaderID());
    }

    @Test
    void testRead() {
        repository.create(residence);
        Residence read = repository.read("222260971");
        assertNotNull(read);
        assertEquals("Thapelo", read.getName());
    }

    @Test
    void testUpdate() {
        repository.create(residence);
        Residence updatedResidence = new Residence.Builder()
                .setLeaderID("222260971")
                .setName("chill guy Thapelo")
                .setEmail("thapelo@icloud.com")
                .setAssignedBlock("Block D")
                .build();

        Residence updated = repository.update(updatedResidence);
        assertNotNull(updated);
        assertEquals("chill guy Thapelo", updated.getName());
    }

    @Test
    void testDelete() {
        repository.create(residence);
        boolean deleted = repository.delete("222260971");
        assertTrue(deleted);
    }

    @Test
    void testGetAll() {
        repository.create(residence);
        Set<Residence> allResidences = repository.getAll();
        assertFalse(allResidences.isEmpty());
    }
}
