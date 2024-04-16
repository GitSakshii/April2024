package com.classroom.Classroom.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String courseName;

    @ManyToMany
    @JoinTable(
            name = "students_classrooms",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private List<Student> enrolledStudents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "atc_id",referencedColumnName="classroomId")
    private List<Task>assignedTasks;

    public Long getClassroomId() {
        return classroomId;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
