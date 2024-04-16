package com.classroom.Classroom.Repositories;

import com.classroom.Classroom.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student>findByClassrooms_ClassroomId(Long classroomId);
}
