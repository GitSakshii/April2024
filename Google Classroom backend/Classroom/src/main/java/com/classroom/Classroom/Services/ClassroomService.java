package com.classroom.Classroom.Services;

import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClassroomService   {
    @Autowired
    private ClassroomRepository classroomRepository;
    public void createClassroom(Classroom classroom){
        classroomRepository.save(classroom);
    }
    public List<Classroom> getAllClassrooms()
    {
        List<Classroom>Classrooms =new ArrayList<>();
        classroomRepository.findAll().forEach(classroom->Classrooms.add(classroom));
        return Classrooms;
    }
    public Classroom addClassroom(Classroom Classroom){
       Classroom classroom= classroomRepository.save(Classroom);
       return classroom;
    }
    public Student enrollStudent(Long classroomId, Student student){
        Optional<Classroom> classroom=classroomRepository.findById(classroomId);



     return student;
    }
}
