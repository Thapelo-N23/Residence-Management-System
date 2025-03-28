package za.ac.cput.domain.repository;
import za.ac.cput.domain.entities.Student;

import java.util.*;

public class StudentRepository implements IStudentRepository {

    private static IStudentRepository repository = null;
    private final List<Student> studentList;

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
        studentList.add(student);
        return student;
    }

    @Override
    public Student read(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        if (delete(student.getStudentId())) {
            studentList.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        return studentList.removeIf(student -> student.getStudentId().equals(studentId));
    }

    @Override
    public Set<Student> getAll() {
        return new HashSet<>(studentList);
    }
}
