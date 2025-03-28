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
        Residence leader = ResidenceFactory.createResidence("60971", "Thapelo", "thapelo_nicloud.com", "Block D");
        if (leader != null) {


            if (leader != null) {
                System.out.println("Leader created: " + leader);
            } else {
                System.out.println("Leader is null");
            }


        }
    }
}