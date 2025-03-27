package za.ac.cput.domain;

import za.ac.cput.domain.entities.*;
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
            System.out.println("Leader created: " + leader);
        } else {
            System.out.println("Leader is null");
        }

        // Create student before using it in Payment
        Student student = StudentFactory.createStudent(
                "STU230640", "Lisa", "Ngozi", "lisa.ngozi@gmail.com",
                "0812345678", true, "R002", leader != null ? leader.getLeaderID() : null);

        if (student != null) {
            System.out.println("Student created: " + student);
        } else {
            System.out.println("Student is null");
        }

        // Create staff
        Staff staff = null;
        if (leader != null) {
            staff = StaffFactory.createStaff("STA654321", "Tsireledzo", "Mbedzi", "tsireledzombedzi@gmail.com", "worker");
        }

        if (staff != null) {
            System.out.println("Staff created: " + staff);
        } else {
            System.out.println("Staff is null");
        }

        // Create payment
        Payment payment = null;
        if (student != null) {
            payment = PaymentFactory.createPayment("PAY123456", 2500.89, true, "2025-03-28", student.getStudentId());
        }

        if (payment != null) {
            System.out.println("Payment successfully created: " + payment);
        } else {
            System.out.println("Failed to create Payment");
        }



        // Create room (Fixed incorrect room number formatting)
        Room room = RoomFactory.createRoom("R002", 2, "Single", "Occupied", 2, "Eldorado");

        if (room != null) {
            System.out.println("Room successfully created: " + room);
        } else {
            System.out.println("Failed to create Room.");
        }
        // Create maintenance request (Fixed status to boolean)
        LocalDateTime requestDate = LocalDateTime.now();
        LocalDateTime completionDate = requestDate.plusDays(2);

        MaintenanceRequest request = null;
        if (student != null && staff != null) {
            request = MaintenanceRequestFactory.createMaintenanceRequest(
                    "REQ123456", student.getStudentId(), room.getRoomID(), "Broken door",
                    requestDate, "Completed",  // Boolean status instead of string
                    staff.getStaffID(), "Resolved by replacing the door handle", completionDate);
        }

        if (request != null) {
            System.out.println("Maintenance Request successfully created: " + request);
        } else {
            System.out.println("Failed to create Maintenance Request");
        }
    }
}