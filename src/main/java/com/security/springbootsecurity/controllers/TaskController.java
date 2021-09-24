package com.security.springbootsecurity.controllers;

import com.security.springbootsecurity.dto.TaskDto;
import com.security.springbootsecurity.models.Task;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.services.TaskService;
import com.security.springbootsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/list")
    public String getList(Model model) {
             List<Task> allTasks = taskService.getAllTask();
             model.addAttribute("listTask", allTasks);
        return "task/list.html";
  }

    @GetMapping( "/create")
    public String createTask() {
       return "task/create.html";
    }

    @PostMapping("/new")
    public String newTask(TaskDto taskDto)
    {
        taskService.newTask(taskDto);
        return "task/list.html";
    }


    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable(value = "id") String id, Model model)
    {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task/updateTask.html";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") String id)
    {
        taskService.deleteTask(id);
        return "task/list.html";
    }
}

