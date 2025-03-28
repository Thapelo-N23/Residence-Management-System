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
        roomList = new ArrayList<Room>();

    }

    public static IRoomRepository getRepository() {
        if (repository == null) {
            repository = new RoomRepository();
        }
        return repository;
    }

    public static Object getIRepository() {
        return false;
    }

    @Override
    public Room create(Room room) {
        boolean success = room.add(room);
        if (success) {
            return room;
        }
        return null;
    }

    @Override
    public Room read(String s) {
        for (Room r : roomList) {

            if (r.getRoomID().equals(r.getRoomID())) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Room update(Room room) {
        String id = room.getRoomID();
        Room roomID = read(id);
        if (roomID == null)

            return null;

        return roomID;
    }

    @Override
    public boolean delete(String id) {
    Room roomToDelete = read(id);
    if(roomToDelete==null)
        return false;
        return false;
    }

    @Override
    public Set<Room> getAll() {
        return new HashSet<>(roomList);
    }
}
