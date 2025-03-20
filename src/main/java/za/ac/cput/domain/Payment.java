package za.ac.cput.domain;

import java.time.LocalDate;

public class Payment {
    private String paymentID;
    private Double amountPaid;
    private Boolean status;
    private LocalDate paymentDate;
    private String studentID;


    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amountPaid = builder.amountPaid;
        this.status = builder.status;
        this.paymentDate = builder.paymentDate;
        this.studentID = builder.studentID;
    }


    public String getPaymentID() {
        return paymentID;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amountPaid=" + amountPaid +
                ", status=" + status +
                ", paymentDate=" + paymentDate +
                ", studentID='" + studentID + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentID;
        private Double amountPaid;
        private Boolean status;
        private LocalDate paymentDate;
        private String studentID;

        public Builder paymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder amountPaid(Double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder status(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder paymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }
        public Builder studentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
