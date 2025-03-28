package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Payment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaymentRepository implements IPaymentRepository{


    private static IPaymentRepository repository = null;
    private List<Payment> paymentList;


    private PaymentRepository(){
        paymentList = new ArrayList<>();
    }
   public static IPaymentRepository getRepository(){
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
   }


    @Override

    public Payment create(Payment payment) {
        boolean success = paymentList.add(payment);
        if (success){
            return payment;
        }
        return null;
    }

    @Override
    public Payment read(String ID) {
        for(Payment p : paymentList){
            if (p.getPaymentID().equals(ID))
                return p;
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {

      String ID  = payment.getPaymentID();
      Payment paymentOld = read(ID);
      if(paymentOld == null )

        return null;

      boolean success = delete(ID);
      if (success ){
          if (paymentList.add(payment))
              return payment;
      }
        return null;
    }

    @Override
    public boolean delete(String ID) {
        Payment paymentToDelete = read(ID);
        if (paymentToDelete == null)
        return false;
        return (paymentList.remove(paymentToDelete));
    }

    @Override
    public Set<Payment> getAll() {
        return null;

    }
}
