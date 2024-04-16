package com.classroom.Classroom.Services;

import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Student;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClassroomService   {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    StudentRepository studentRepository;
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
        Optional<Classroom> optionalClassroom=classroomRepository.findById(classroomId);
        if (optionalClassroom.isPresent()) {
            Classroom classroom = optionalClassroom.get();
            Student savedStudent=studentRepository.save(student);
            if(savedStudent !=null){
            List<Student> enrolledStudents = classroom.getEnrolledStudents();
            enrolledStudents.add(savedStudent);
            classroom.setEnrolledStudents(enrolledStudents);

            classroomRepository.save(classroom);

            return savedStudent;
        }else
        {

            return null;

        }
        } else {
            return null;
        }
    }
}
