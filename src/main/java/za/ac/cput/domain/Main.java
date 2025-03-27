package za.ac.cput.domain;

import za.ac.cput.domain.factory.ResidenceFactory;

public class Main {

    public static void main(String[] args){
        Residence leader = ResidenceFactory.createResidence("60971", "Thapelo", "thapelo_nicloud.com", "Block D");
if (leader != null){

System.out.println("leader is created: " + leader);}

    else {
        System.out.println("leader is null");
}
    }


}