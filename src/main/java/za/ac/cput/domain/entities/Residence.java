package za.ac.cput.domain.entities;

public class Residence {

    private  String leaderID;
    private  String name;
    private  String email;
    private  String assignedBlock;

    private Residence(Builder builder) {
        this.leaderID = builder.leaderID;
        this.name = builder.name;
        this.email = builder.email;
        this.assignedBlock = builder.assignedBlock;
    }


    public Object getleaderId() {
        return leaderID;
    }


    public String getLeaderID() {
        return leaderID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAssignedBlock() {
        return assignedBlock;
    }

    public static class Builder {
        private String leaderID;
        private String name;
        private String email;
        private String assignedBlock;

        public Builder setLeaderID(String leaderID) {
            this.leaderID = leaderID;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setAssignedBlock(String assignedBlock) {
            this.assignedBlock = assignedBlock;
            return this;
        }

        public Residence build() {
            return new Residence(this);
        }


    }
    @Override
    public String toString() {
        return "Builder{" +
                "leaderID='" + leaderID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", assignedBlock='" + assignedBlock + '\'' +
                '}';
    }
}