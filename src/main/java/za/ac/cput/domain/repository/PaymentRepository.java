package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Payment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaymentRepository implements IPaymentRepository {

    private static IPaymentRepository repository = null;
    private List<Payment> paymentList;

    private PaymentRepository() {
        paymentList = new ArrayList<>();
    }

    public static IPaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        if (paymentList.add(payment)) {
            return payment;
        }
        return null;
    }

    @Override
    public Payment read(String ID) {
        return paymentList.stream()
                .filter(payment -> payment.getPaymentID().equals(ID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getPaymentID().equals(payment.getPaymentID())) {
                paymentList.set(i, payment); // ✅ Replace the existing payment
                return payment;
            }
        }
        return null; // ❌ ID not found
    }

    @Override
    public boolean delete(String ID) {
        return paymentList.removeIf(payment -> payment.getPaymentID().equals(ID));
    }

    @Override
    public Set<Payment> getAll() {
        return new HashSet<>(paymentList);
    }
}
