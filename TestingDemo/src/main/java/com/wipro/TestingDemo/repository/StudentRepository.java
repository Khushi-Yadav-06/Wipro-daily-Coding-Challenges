
package com.wipro.TestingDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.TestingDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
