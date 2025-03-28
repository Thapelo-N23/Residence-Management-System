
//Mengezi Junior Ngwenya 230023967
package za.ac.cput.domain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.Payment;
import za.ac.cput.domain.repository.PaymentRepository;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFactoryTest {
    private PaymentRepository repository;
    private Payment payment;

    @BeforeEach
    void setUp(){
        repository = (PaymentRepository) PaymentRepository.getRepository();

        payment = new Payment.Builder()
                .paymentID("PAY230666")
                .amount(1500.00)
                .status(true)
                .paymentDate(LocalDate.of(2025, 3, 28))
                .studentId("STU123456")
                .build();
        repository.create(payment);
    }

    @Test
    void testCreate() {
        Payment created = repository.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentID(), created.getPaymentID());
    }

    @Test
    void testRead() {
        Payment found = repository.read(payment.getPaymentID());
        assertNotNull(found);
        assertEquals(payment.getPaymentID(), found.getPaymentID());
    }

    @Test
    void testUpdate() {
        Payment updatedPayment = new Payment.Builder()
                .paymentID(payment.getPaymentID())
                .amount(2000.00) // Updated amount
                .status(false)   // Updated status
                .paymentDate(payment.getPaymentDate())
                .studentId(payment.getStudentId())
                .build();

        Payment updated = repository.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(2000.00, updated.getAmount());
        assertFalse(updated.getStatus());
    }

    @Test
    void testDelete() {
        boolean success = repository.delete(payment.getPaymentID());
        assertTrue(success);
        assertNull(repository.read(payment.getPaymentID()));
    }

    @Test
    void testGetAll() {
        Set<Payment> paymentSet = repository.getAll();
        assertFalse(paymentSet.isEmpty());
        assertTrue(paymentSet.contains(payment));
    }
}
