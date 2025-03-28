package za.ac.cput.domain.factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.Staff;
import za.ac.cput.domain.repository.StaffRepository;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffFactoryTest {
    private StaffRepository repository;
    private Staff staff;

    @BeforeEach
    void setUp(){
            repository = (StaffRepository) StaffRepository.getIRepository();

            staff = new Staff.Builder()
                    .setStaffID("STA230666")
                    .setFirstName("Tsireledzo")
                    .setLastName("Mbedzi")
                    .setEmail("tsireledzombedzi93@gmail.com")
                    .setRole("cleaner")
                    .build();
            repository.create(staff);
        }

    @Test
    void testCreate() {
        Staff created = repository.create(staff);
        assertNotNull(created);
        assertEquals(staff.getStaffID(), created.getStaffID());

    }

    @Test
    void testRead() {
        Staff found = repository.read(staff.getStaffID());
        assertNotNull(found);
        assertEquals(staff.getStaffID(), found.getStaffID());
}

    @Test
    void testUpdate() {
        Staff updatedStaff = new Staff.Builder()
                .setStaffID(staff.getStaffID())
                .setFirstName("John") 
                .setLastName("Black")// Changed Name
                .setEmail("JohnBlack@gmail.com")
                .setRole(staff.getRole())
                .build();

        Staff updated = repository.update(updatedStaff);
        assertNotNull(updated);
        assertEquals("John", updated.getFirstName());
    }

    @Test
    void testDelete() {
        boolean success = repository.delete(staff.getStaffID());
        assertTrue(success);
        assertNull(repository.read(staff.getStaffID()));
    }

    @Test
    void testGetAll() {
        Set<Staff> staffSet = repository.getAll();
        assertFalse(staffSet.isEmpty());
        assertTrue(staffSet.contains(staff));
    }
}
