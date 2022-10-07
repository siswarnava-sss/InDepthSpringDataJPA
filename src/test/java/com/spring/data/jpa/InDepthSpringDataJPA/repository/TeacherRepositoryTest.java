package com.spring.data.jpa.InDepthSpringDataJPA.repository;

import com.spring.data.jpa.InDepthSpringDataJPA.entity.Course;
import com.spring.data.jpa.InDepthSpringDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course coursePy = Course.builder()
                .title("Python")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Amol")
                .lastName("Pal")
//                .courses(Arrays.asList(coursePy, courseJava))
                .build();

        teacherRepository.save(teacher);
    }

}