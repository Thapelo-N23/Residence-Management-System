package za.ac.cput.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.MaintenanceRequest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceRequestRepositoryTest {
    private MaintenanceRequestRepository repository;
    private MaintenanceRequest request;
    private MaintenanceRequest[] MaintenanceRequestList;

    @BeforeEach
    void setUp() {
        repository = MaintenanceRequestRepository.getRepository();
        request = new MaintenanceRequest.Builder("MR101", "STU230640", "R001", "Broken door", LocalDateTime.now())
                .staffId("STAFF123")
                .resolutionNotes("Replaced the door handle")
                .completionDate(LocalDateTime.now().plusDays(2))
                .status(false)
                .build();
    }

    @Test
    void testCreate() {
        MaintenanceRequest created = repository.create(request);
        assertNotNull(created);
        assertEquals(request.getRequestId(), created.getRequestId());
    }

    @Test
    void testRead() {
        repository.create(request);
        MaintenanceRequest read = repository.read("MR101");
        assertNotNull(read);
        assertEquals("Broken door", read.getIssueDescription());
    }

    @Test
    void testUpdate() {
        repository.create(request);
        MaintenanceRequest updatedRequest = new MaintenanceRequest.Builder("MR101", "STU230640", "R001", "Leaking pipe", request.getRequestDate())
                .staffId("STAFF456")
                .resolutionNotes("Fixed the pipe")
                .completionDate(LocalDateTime.now().plusDays(1))
                .status(true)
                .build();

        MaintenanceRequest updated = repository.update(updatedRequest);
        assertNotNull(updated);
        assertEquals("Leaking pipe", updated.getIssueDescription());
    }

    @Test
    void testDelete() {
        repository.create(request);
        boolean deleted = repository.delete("MR101");
        assertTrue(deleted);
    }

    @Test
    void testGetAll() {
        repository.create(request);
        List<MaintenanceRequest> allRequests = repository.getAll();
        assertFalse(allRequests.isEmpty());
    }

    public MaintenanceRequest read(String s) {
        for (MaintenanceRequest request : MaintenanceRequestList) {
            if (request.getRequestID().equals(s)) {
                return request;
            }
        }
        return null;
    }
}