package za.ac.cput.domain.repository;
import za.ac.cput.domain.entities.Room;

import java.util.Set;

public interface IRoomRepository extends IRepository<Room,String> {
    Set<Room> getAll();



}
