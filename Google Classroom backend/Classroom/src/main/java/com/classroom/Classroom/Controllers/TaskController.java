package com.classroom.Classroom.Controllers;

import com.classroom.Classroom.Entities.Task;
import com.classroom.Classroom.Repositories.ClassroomRepository;
import com.classroom.Classroom.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/{classroomId}")
    public ResponseEntity<List<Task>>getTasks(@PathVariable("classroomId")Long classroomId){
        if(!classroomRepository.existsById(classroomId))
        {return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        List<Task> tasks=taskService.getAllTasks( classroomId);
        return ResponseEntity.of((Optional.of(tasks)));
    }
    @PutMapping("/assignTasks/{classroomId}")
    public ResponseEntity<String> assignTask(@RequestBody Task task, @PathVariable("classroomId") Long classroomId) {
        try {
            Task task1 = taskService.assignTask(classroomId,task );
            return ResponseEntity.status(HttpStatus.CREATED).body("Task Assigned Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Assign Task");
        }
    }


}
