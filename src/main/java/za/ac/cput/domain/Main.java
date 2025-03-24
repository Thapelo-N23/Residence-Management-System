package za.ac.cput.domain;

import za.ac.cput.domain.factory.ResidenceFactory;
import za.ac.cput.domain.factory.StaffFactory;
//import za.ac.cput.factory.PaymentFactory;


public class Main {

    public static void main(String[] args){
        Residence leader = ResidenceFactory.createResidence("123456789", "Thapelo", "thape@gmail.com", "Block D");
        if (leader != null){
          System.out.println("leader is created: " + leader);}
          else {
          System.out.println("leader is null");
          }

        Staff staff = StaffFactory.createStaff("213213","Tsireledzo","Mbedzi","tsireledzombedzi@gmail.com","worker");
          if(staff != null){
              System.out.println("staff was created: " + staff);
          }
          else{
              System.out.println("Staff is null");
          }
//        Payment payment = PaymentFactory.createPayment(
//                "PAY123456", "2500", false, "2005-03-04", "1001");
//
//        if (payment != null) {
//            System.out.println("Payment successfully created: " + payment);
//        } else {
//            System.out.println("Failed to create Payment");
//        }
    }
}




