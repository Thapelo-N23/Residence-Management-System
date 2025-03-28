// 230666426 Tsireledzo Netshilonwe
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
                .filter(staff -> staff.getStaffID().equals(staffId)) // ✅ Fixed lambda parameter
                .findFirst()
                .orElse(null);
    }

    @Override
    public Staff update(Staff staff) {  // ✅ Changed parameter name from "payment" to "staff"
        String ID = staff.getStaffID();
        Staff oldStaff = read(ID);
        if (oldStaff == null) {
            return null;
        }

        boolean success = delete(ID);
        if (success) {
            staffList.add(staff);
            return staff;
        }
        return null;
    }

    @Override

    public boolean delete(String ID) {
        Staff staffToDelete = read(ID);
        if (staffToDelete == null)
            return false;
        return (staffList.remove(staffToDelete));

    public boolean delete(String id) {
        return staffList.removeIf(staff -> staff.getStaffID().equals(id));

    }
    @Override
    public Set<Staff> getAll() {
        return new HashSet<>(staffList);
    }
}
