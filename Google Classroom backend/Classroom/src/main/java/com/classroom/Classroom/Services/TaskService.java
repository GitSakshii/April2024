package com.classroom.Classroom.Services;

import com.classroom.Classroom.Entities.Classroom;
import com.classroom.Classroom.Entities.Task;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    public List<Task> getAllTasks(Long classroomId){
        List<Task> tasks=taskRepository.findByClassroom_ClassroomId(classroomId);
        return tasks;
    }
    public Task assignTask(Long classroomId,Task task){
        Optional<Classroom> optionalClassroom=classroomRepository.findById(classroomId);
        if (optionalClassroom.isPresent()) {
            Classroom classroom = optionalClassroom.get();
            Task assignedTask=taskRepository.save(task);
            if(assignedTask !=null){
                List<Task> assignedTasks = classroom.getAssignedTasks();
                assignedTasks.add(assignedTask);
                classroom.setAssignedTasks(assignedTasks);

                classroomRepository.save(classroom);

                return assignedTask;
            }else
            {
                return null;

            }
        } else {
            return null;
        }
    }
}
