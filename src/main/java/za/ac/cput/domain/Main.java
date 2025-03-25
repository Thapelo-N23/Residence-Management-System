package za.ac.cput.domain;

import za.ac.cput.domain.factory.ResidenceFactory;
import za.ac.cput.domain.factory.StaffFactory;
import za.ac.cput.domain.factory.PaymentFactory;
import za.ac.cput.domain.factory.MaintenanceRequestFactory;
import za.ac.cput.domain.factory.StudentFactory;
import za.ac.cput.domain.factory.RoomFactory;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Residence leader = ResidenceFactory.createResidence("123456789", "Thapelo", "thape@gmail.com", "Block D");
        if (leader != null) {
            System.out.println("leader is created: " + leader);
        } else {
            System.out.println("leader is null");
        }

        Staff staff = StaffFactory.createStaff("213213", "Tsireledzo", "Mbedzi", "tsireledzombedzi@gmail.com", "worker",leader.getLeaderID());
        if (staff != null) {
            System.out.println("staff was created: " + staff);
        } else {
            System.out.println("Staff is null");
        }

        Payment payment = PaymentFactory.createPayment(
                "PAY123456", "2500", false, "2005-03-04", "1001");

        if (payment != null) {
            System.out.println("Payment successfully created: " + payment);
        } else {
            System.out.println("Failed to create Payment");
        }


        Room room = RoomFactory.createRoom("R002", 002, "Single", "Occupied", 2, "Eldorado");
        System.out.println(room);

       Student student = StudentFactory.createStudent(
               "STU230640", "Lisa", "Ngozi", "lisa.ngozi@gmail.com",
"0812345678", true, room.getRoomID(), "123456789");

        if (student != null) {
            System.out.println("Student is successfully created: " + student);
        } else {
           System.out.println("Student is null");
        }
        MaintenanceRequest request = new MaintenanceRequest.Builder("MR101", student.getStudentId(), room.getRoomID(),
                "Broken door", LocalDateTime.now(), "In Progress", staff.getStaffID(), "Resolved by replacing the door handle",
                LocalDateTime.now().plusHours(2));

        if (request != null) {
            System.out.println("Maintenance Request Created Successfully:");
            System.out.println(request);
        } else {
            System.out.println("!Failed to create Maintenance Request. Please check input values.");
        }


    }
}