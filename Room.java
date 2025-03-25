package za.ac.cput.domain;

public class Room {

        private String roomID;
        private Integer roomNumber;
        private String roomType;
        private String roomStatus;
        private Integer floorNumber;
        private String floorName;

        public Room(String roomID, Integer roomNumber, String roomType,
                    String roomStatus, Integer floorNumber, String floorName) {
            this.roomID = roomID;
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.roomStatus = roomStatus;
            this.floorNumber = floorNumber;
            this.floorName = floorName;
        }
    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", floorNumber=" + floorNumber +
                ", floorName='" + floorName + '\'' +
                '}';
    }

    public boolean isRoomIdEmpty() {
            return false;
    }

    public String getRoomID() {
            return roomID;
    }

    public Room setRoomID(String r001) {
            this.roomID = roomID;
            return this;
    }

    public static class Builder {
            private String roomID;
            private Integer roomNumber;
            private String roomType;
            private String roomStatus;
            private Integer floorNumber;
            private String floorName;

            public Builder copy(Room room) {
                this.roomID = room.roomID;
                this.roomNumber = room.roomNumber;
                this.roomType = room.roomType;
                this.roomStatus = room.roomStatus;
                this.floorNumber = room.floorNumber;
                this.floorName = room.floorName;
                return this;
            }

            public Room build(){

                return new Room(roomID, roomNumber, roomType, roomStatus, floorNumber, floorName);
            }

            public String getRoomID() {
                return roomID;
            }

            public Builder setRoomID(String roomID) {
                this.roomID = roomID;
                return this;
            }

            public Integer getRoomNumber() {
                return roomNumber;
            }

            public Builder setRoomNumber(Integer roomNumber) {
                this.roomNumber = roomNumber;
                return this;
            }

            public String getRoomType() {
                return roomType;
            }

            public Builder setRoomType(String roomType) {
                this.roomType = roomType;
                return this;
            }

            public String getRoomStatus() {
                return roomStatus;
            }

            public Builder setRoomStatus(String roomStatus) {
                this.roomStatus = roomStatus;
                return this;
            }

            public Integer getFloorNumber() {
                return floorNumber;
            }

            public Builder setFloorNumber(Integer floorNumber) {
                this.floorNumber = floorNumber;
                return this;
            }

            public String getFloorName() {
                return floorName;
            }

            public Builder setFloorName(String floorName) {
                this.floorName = floorName;
                return this;
            }


            public Builder setRoomId(String roomID) {
                this.roomID = roomID;
                return this;
            }
        }
    }


