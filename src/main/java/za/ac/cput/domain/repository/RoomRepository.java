package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Room;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoomRepository implements IRoomRepository {
    private static IRoomRepository repository = null;
    private List<Room> roomList;

    private RoomRepository() {
        roomList = new ArrayList<>();
    }

    public static IRoomRepository getRepository() {
        if (repository == null) {
            repository = new RoomRepository();
        }
        return repository;
    }

    @Override
    public Room create(Room room) {
        boolean success = roomList.add(room);  // ✅ Fixed: Now adding to roomList
        return success ? room : null;
    }

    @Override
    public Room read(String roomId) {
        for (Room r : roomList) {
            if (r.getRoomID().equals(roomId)) {  // ✅ Fixed: Now correctly compares with input ID
                return r;
            }
        }
        return null;
    }

    @Override
    public Room update(Room room) {
        String id = room.getRoomID();
        Room existingRoom = read(id);
        if (existingRoom == null) {
            return null;  // ✅ Return null if the room does not exist
        }

        boolean removed = delete(id);  // ✅ Remove old entry
        if (removed) {
            roomList.add(room);  // ✅ Add updated room
            return room;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return roomList.removeIf(room -> room.getRoomID().equals(id));  // ✅ Fixed: Now removes correctly
    }

    @Override
    public Set<Room> getAll() {
        return new HashSet<>(roomList);
    }
}
