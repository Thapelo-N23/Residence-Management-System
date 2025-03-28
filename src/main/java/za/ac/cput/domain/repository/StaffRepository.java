//230666426 Tsireledzo Netshilonwe
package za.ac.cput.domain.repository;
import za.ac.cput.domain.entities.Staff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaffRepository implements IStaffRepository {
    private static IStaffRepository repository = null;
    private List<Staff> staffList;

    private StaffRepository() {
        staffList = new ArrayList<>();

    }

    public static IStaffRepository getIRepository() {
        if (repository == null) {
            repository = new StaffRepository();

        }
        return repository;
    }

    @Override
    public Staff create(Staff staff) {
        boolean success = staffList.add(staff);
        return success ? staff : null;
    }

    @Override
    public Staff read(String staffId) {
        return staffList.stream()
                .filter(residence -> residence.getStaffID().equals(staffId))
                .findFirst()
                .orElse(null);
    }

    public Staff update(Staff payment) {

        String ID  = payment.getStaffID();
        Staff paymentOld = read(ID);
        if(paymentOld == null )

            return null;

        boolean success = delete(ID);
        if (success ){
            if (staffList.add(payment))
                return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return staffList.removeIf(residence -> Staff.getStaffID().equals(id));
    }

    @Override
    public Set<Staff> getAll() {
        return new HashSet<>(staffList);
    }
}