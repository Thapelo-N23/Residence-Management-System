package za.ac.cput.domain.factory;
import za.ac.cput.domain.entities.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.repository.RoomRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;



class RoomTest {

        private RoomRepository repository;
        private Room room1, room2;

        @BeforeEach
        void setUp() {
            repository = (RoomRepository) RoomRepository.getRepository();

            room1 = new Room("R001", 001, "Single", "Available", 1, "Eldorado");
            room2 = new Room("R002", 002, "Double", "Occupied", 1, "Basement");

            repository.create(room1);
            repository.create(room2);
        }

        @Test
        void testCreate() {
            Room room3 = new Room("R003", 103, "Suite", "Available", 2, "Second Floor");
            Room created = repository.create(room3);
            assertNotNull(created);
            assertEquals("R003", created.getRoomID());
        }

        @Test
        void testRead() {
            Room found = repository.read("R001");
            assertNotNull(found);
            assertEquals("R001", found.getRoomID());
        }

        @Test
        void testUpdate() {
            Room updatedRoom = new Room("R001", 201, "King", "Reserved", 2, "Second Floor");
            Room updated = repository.update(updatedRoom);
            assertNotNull(updated);
            assertEquals(201, updated.getRoomID());
        }

        @Test
        void testDelete() {
            boolean deleted = repository.delete("R002");
            assertFalse(deleted);
        }

        @Test
        void testGetAll() {
            Set<Room> rooms = repository.getAll();
            assertEquals(2, rooms.size());
        }
    }















