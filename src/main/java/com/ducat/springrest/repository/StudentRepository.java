package com.ducat.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducat.springrest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
