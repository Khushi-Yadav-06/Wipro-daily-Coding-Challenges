package com.wipro.TestingDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.TestingDemo.entity.Student;
import com.wipro.TestingDemo.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repo;

    @Test
    void testSaveStudent() {

        Student s = new Student();

        s.setId(1);
        s.setName("Khushi");

        Student saved = repo.save(s);

        assertEquals("Khushi", saved.getName());
    }

    @Test
    void testGetAllStudents() {

        List<Student> list = repo.findAll();

        assertFalse(list.isEmpty());
    }

    @Test
    void testGetStudentById() {

        Student s = repo.findById(1).orElse(null);

        assertEquals(1, s.getId());
    }
}