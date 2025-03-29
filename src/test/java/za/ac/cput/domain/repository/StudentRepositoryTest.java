package za.ac.cput.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entities.Student;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setUp() {
        studentRepository = StudentRepository.getRepository(); // Singleton pattern
        student1 = new Student.Builder()
                .studentId("S001")
                .firstName("Phindile")
                .lastName("Lisa Ngozi")
                .email("Lisangozi@gmail.com")
                .phoneNumber("0723324418")
                .status(true)
                .roomId("R001")
                .leaderId("123456789")
                .build();

        student2 = new Student.Builder()
                .studentId("S002")
                .firstName("Onako")
                .lastName("Ntsaluba")
                .email("Onakontsaluba@gmail.com")
                .phoneNumber("0687654321")
                .status(true)
                .roomId("R002")
                .leaderId("123456789")
                .build();
    }

    @Test
    public void testCreate() {
        assertNotNull(studentRepository.create(student1));
        assertNotNull(studentRepository.create(student2));
    }

    @Test
    public void testRead() {
        studentRepository.create(student1);
        Student foundStudent = studentRepository.read(student1.getStudentId());
        assertNotNull(foundStudent);
        assertEquals(student1.getStudentId(), foundStudent.getStudentId());
    }

    @Test
    public void testUpdate() {
        studentRepository.create(student1);
        Student updatedStudent = new Student.Builder()
                .studentId(student1.getStudentId())
                .firstName("Phindile Updated")
                .lastName(student1.getLastName())
                .email(student1.getEmail())
                .phoneNumber(student1.getPhoneNumber())
                .status(student1.getStatus())
                .roomId(student1.getRoomID())
                .leaderId(student1.getLeaderId())
                .build();

        assertNotNull(studentRepository.update(updatedStudent));
        assertEquals("Phindile Updated", studentRepository.read(student1.getStudentId()).getFirstName());
    }

    @Test
    public void testDelete() {
        studentRepository.create(student1);
        assertTrue(studentRepository.delete(student1.getStudentId()));
        assertNull(studentRepository.read(student1.getStudentId()));
    }

    @Test
    public void testGetAll() {
        studentRepository.create(student1);
        studentRepository.create(student2);

        Set<Student> allStudents = studentRepository.getAll();
        assertEquals(2, allStudents.size());
    }

    @Test
    public void testReadNonExistentStudent() {
        assertNull(studentRepository.read("NonExistentId"));
    }

    @Test
    public void testDeleteNonExistentStudent() {
        assertFalse(studentRepository.delete("NonExistentId"));
    }
}

