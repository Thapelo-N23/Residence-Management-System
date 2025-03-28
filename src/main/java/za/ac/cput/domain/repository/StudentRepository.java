package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Student;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepository implements IStudentRepository {

    private static IStudentRepository repository = null;
    private List<Student> studentList;

    private StudentRepository() {
        studentList = new ArrayList<>();
    }

    public static IStudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        boolean success = studentList.add(student);
        if (success) {
            return student;
        }
        return null;
    }

    @Override
    public Student read(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId))
                return student;
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        String id = student.getStudentId();
        Student existingStudent = read(id);

        if (existingStudent == null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (studentList.add(student))
                return student;
        }
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        Student studentToDelete = read(studentId);
        if (studentToDelete == null)
            return false;
        return studentList.remove(studentToDelete);
    }

    @Override
    public Set<Student> getAll() {
        return new HashSet<>(studentList);
    }
}
