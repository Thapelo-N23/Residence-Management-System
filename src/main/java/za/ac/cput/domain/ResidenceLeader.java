package za.ac.cput.domain;

import java.util.Locale;

public class ResidenceLeader {
    private  String leaderID;
    private  String name;
    private  String email;
    private  String assignedBlock;

    private ResidenceLeader(Builder builder) {
        this.leaderID = builder.leaderID;
        this.name = builder.name;
        this.email = builder.email;
        this.assignedBlock = builder.assignedBlock;
    }


    public static class Builder {
        private String leaderID;
        private String name;
        private String email;
        private String assignedBlock;

        public Builder leaderID(String leaderID) {
            this.leaderID = leaderID;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder assignedBlock(String assignedBlock) {
            this.assignedBlock = assignedBlock;
            return this;
        }
        public ResidenceLeader build() {
            return new ResidenceLeader(this);
        }
    }
}
