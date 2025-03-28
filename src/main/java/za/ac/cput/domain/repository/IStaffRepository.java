package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Staff;

import java.util.Set;

public interface IStaffRepository extends IRepository<Staff, String> {
    Set<Staff> getAll();
}
