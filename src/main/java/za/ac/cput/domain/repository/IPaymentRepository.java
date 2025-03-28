package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Payment;
import java.util.Set;


public interface IPaymentRepository extends IRepository<Payment, String> {

   Set<Payment> getAll();

}
