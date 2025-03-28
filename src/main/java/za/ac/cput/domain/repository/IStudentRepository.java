package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Student;
import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String> {
    Set<Student> getAll();
}
