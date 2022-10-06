package com.spring.data.jpa.InDepthSpringDataJPA.repository;

import com.spring.data.jpa.InDepthSpringDataJPA.entity.Guardian;
import com.spring.data.jpa.InDepthSpringDataJPA.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Guardian guardian = Guardian.builder()
                .name("MUKU")
                .email("sf@gmail.com")
                .mobile("8585855858")
                .build();
        Student student = Student.builder()
                .emailId("bc@gmail.com")
                .firstName("Swarnava")
                .lastName("Sinha")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){

        List<Student> studentList = studentRepository.findAll();
                System.out.println("studentList = " + studentList );
        }

    @Test
    public void findStudentByName(){

        System.out.println(studentRepository.findByFirstName("Swarnava"));
    }

    @Test
    public void findStudentByFirstNameContaining(){

        System.out.println(studentRepository.findByFirstNameContaining("Sw"));
    }

    @Test
    public void findStudentByGuardianName(){
        System.out.println(studentRepository.findByGuardianName("MUKU"));
    }
    @Test
    public void findStudentByEmailId(){
        System.out.println(studentRepository.getStudentByEmailAddress("bc@gmail.com"));
    }
    @Test
    public void findStudentFirstNameByEmailId(){
        System.out.println(studentRepository.getStudentFirstNameByEmailId("bc@gmail.com"));
    }

    @Test
    public void findStudentFirstNameByParamEmailId(){
        System.out.println(studentRepository.getStudentFirstNameByParamEmailId("bc@gmail.com"));
    }
    @Test

    public void updateStudentByEmailId(){
        System.out.println(studentRepository.updateStudentNameByEmailId("Deep","bc@gmail.com"));
    }

}

