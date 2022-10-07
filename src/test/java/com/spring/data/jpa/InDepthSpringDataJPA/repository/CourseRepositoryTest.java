package com.spring.data.jpa.InDepthSpringDataJPA.repository;

import com.spring.data.jpa.InDepthSpringDataJPA.entity.Course;
import com.spring.data.jpa.InDepthSpringDataJPA.entity.Guardian;
import com.spring.data.jpa.InDepthSpringDataJPA.entity.Student;
import com.spring.data.jpa.InDepthSpringDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Sneha")
                .lastName("Prasad")
                .build();

        Course course = Course.builder()
                .title("PHP")
                .teacher(teacher)
                .credit(7)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){

        PageRequest firstPageWithThreeRecord = PageRequest.of(0,3);
        PageRequest secondPageWithTwoRecord = PageRequest.of(1,2);

        List<Course> courses  =courseRepository.findAll(firstPageWithThreeRecord).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();


        long totalElementswithTwoRec = courseRepository.findAll(secondPageWithTwoRecord).getTotalElements();
        long totalPagesWithTwoRec = courseRepository.findAll(secondPageWithTwoRecord).getTotalPages();
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        PageRequest sortByTitle = PageRequest.of(0,2
        ,Sort.by("title")
        );

        PageRequest sortByCredit = PageRequest.of(0,2
                , Sort.by("credit").descending()
        );

        Page<Course> courses = courseRepository.findAll(sortByCredit);

        System.out.println("courses = " + courses.toString());
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Guardian guardian = Guardian.builder()
                .name("Ajay")
                .email("ajay123@gmail.com")
                .mobile("8784520066")
                .build();
        Student student = Student.builder()
                .firstName("Amar")
                .lastName("Das")
                .emailId("dasamar@gmail.com")
                .guardian(guardian)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Deepak")
                .lastName("Jamwal")
                .build();

        Course course  = Course.builder()
                .title("AI")
                .credit(5)
                .teacher(teacher)

                .build();



        course.addStudents(student);

        courseRepository.save(course);
    }
}