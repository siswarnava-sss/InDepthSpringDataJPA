package com.spring.data.jpa.InDepthSpringDataJPA.repository;

import com.spring.data.jpa.InDepthSpringDataJPA.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByGuardianName(String name);

    //JPQL
    @Query(
            "select s.firstName from Student s where s.emailId = ?1"
    )
    String getStudentByEmailAddress(String emailId);

    //Native Query
    @Query(
            value = "SELECT * FROM student s where s.email_address = ?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailId(String emailId);


    //using @Param Native named Parameter
    @Query(
            value = "SELECT * FROM student s where s.email_address = :emailId",
            nativeQuery = true
    )
    String getStudentFirstNameByParamEmailId(@Param(value = "emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
