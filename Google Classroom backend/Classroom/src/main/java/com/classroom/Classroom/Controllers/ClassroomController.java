package com.classroom.Classroom.Controllers;

import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.StudentRepository;
import com.classroom.Classroom.Services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassroomController {
    @Autowired
    private StudentRepository student;
    @Autowired
    private ClassroomService classroomService;
    @GetMapping("/Classrooms")
    public ResponseEntity<List<Classroom>>getOfferedCourses()
    {
       List<Classroom>Classrooms=classroomService.getAllClassrooms();
       if(Classrooms.size()<=0){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.of((Optional.of(Classrooms)));

    }
    @PostMapping("/addClassroom")
    public ResponseEntity<String>createClassroom(@RequestBody Classroom Classroom){
        try {
           classroomService.addClassroom(Classroom);
           return ResponseEntity.status(HttpStatus.CREATED).body("Classroom created Successfuly");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create Classroom");
        }

    }
    @PutMapping("/joinClassroom/{classroomId}")
    public ResponseEntity<String> enrollStudent(@RequestBody Student student, @PathVariable("classroomId") Long classroomId) {
        try {
            Student student1 = classroomService.enrollStudent(classroomId, student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Classroom joined Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create Classroom");
        }
    }

}
