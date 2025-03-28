//222260971 Thapelo Ngwenya
//230640893 Phindile Lisa Ngozi
//230023967 Mengezi Junior Ngwenya
//230666426 Tsireledzo Netshilonwe
//230741754 Onako Ntsaluba
// 230277845 Olwethu Nene

package za.ac.cput.domain.factory;
import za.ac.cput.domain.util.Helper;
import za.ac.cput.domain.entities.Room;

public class RoomFactory {
    public static Room createRoom(String roomID, Integer roomNumber, String roomType,
                                  String roomStatus, Integer floorNumber, String floorName) {

        if (Helper.isNullOrEmpty(roomID)) {
            System.out.println("This roomID is empty");
            roomID = Helper.generateId();

            if (Helper.isNullOrEmpty(roomStatus) || Helper.isNullOrEmpty(roomType) ||
                    Helper.isNullOrEmpty(floorName)) {
                System.out.println("Warning: Some required fields are missing.");
                return null;

            }
        }

        return new Room.Builder()
                .setRoomID(roomID)
                .setRoomNumber(roomNumber)
                .setRoomType(roomType)
                .setRoomStatus(roomStatus)
                .setFloorNumber(floorNumber)
                .setFloorName(floorName)
                .build();

    }
}