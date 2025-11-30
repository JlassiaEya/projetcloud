package com.IOT1.__Cloud.Rep;


import org.springframework.data.jpa.repository.JpaRepository;

import com.IOT1.__Cloud.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
