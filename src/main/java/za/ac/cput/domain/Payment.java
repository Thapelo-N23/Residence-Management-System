package za.ac.cput.domain;

import java.time.LocalDate;

public class Payment {
    private String paymentID; // PK
    private Double amount;
    private Boolean status;
    private LocalDate paymentDate;
    private String studentId; // FK References Student


    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.status = builder.status;
        this.paymentDate = builder.paymentDate;
        this.studentId = builder.studentId;
    }


    public String getPaymentID() {
        return paymentID;
    }

    public Double getAmount() {
        return amount;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", paymentDate=" + paymentDate +
                ", studentID='" + studentId + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentID;
        private Double amount;
        private Boolean status;
        private LocalDate paymentDate;
        private String studentId;

        public Builder paymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
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
        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
