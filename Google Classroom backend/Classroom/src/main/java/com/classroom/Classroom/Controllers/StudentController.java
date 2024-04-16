package com.classroom.Classroom.Controllers;


import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Services.StudentService;
import com.classroom.Classroom.Services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class StudentController {
    private ClassroomRepository classroomRepository;
    private StudentService studentService;
    private TaskService taskService;
    @GetMapping("/classroom/{classroomId}/students")
    public ResponseEntity<List<Student>>getAllStudentsOfClassroom(@PathVariable(value="classroomId")Long classroomId){
        if(!classroomRepository.existsById(classroomId))
        {return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        List<Student> students=studentService.getAllStudents( classroomId);
        return ResponseEntity.of((Optional.of(students)));
    }
    @PostMapping("/signup")
    private ResponseEntity<Student>RegisterStudent(@RequestBody Student student)
    {
        Student student1=studentService.registerStudent(student);
        return ResponseEntity.ok(student1);
    }




}
