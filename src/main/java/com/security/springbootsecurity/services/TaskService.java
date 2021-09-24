package com.security.springbootsecurity.services;

import com.security.springbootsecurity.dto.TaskDto;
import com.security.springbootsecurity.dto.transformation.TaskTransformation;
import com.security.springbootsecurity.models.Tag;
import com.security.springbootsecurity.models.Task;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.TagRepository;
import com.security.springbootsecurity.repository.TaskRepository;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserService userService;


    public TaskDto getById(String id) {
        Task task = repository.getById(id);
        return TaskTransformation.fromEntity(task);
    }


//    public List<TaskDto> getTasksByUserId(String userId, Boolean complete, int page) {
//
//        Pageable pageable = PageRequest.of(page, 5);
//
//     //   Page<Task> tasks = repository.findAllByUserIdAndIsCompleteAndFlag(userId, complete, false, pageable);
//
//        return TaskTransformation.fromEntity(tasks);
//    }


    public TaskDto newTask(TaskDto taskDTO) {

        Task task = taskDTO.getId() == null ? new Task() :  repository.getById(taskDTO.getId());

         User user = userService.getCurrentUser();
//
//        List<String> tagIds = taskDTO.getTagIds();
//
//        List<Tag> tags = new ArrayList<Tag>();

//        for(int i=0; i<tagIds.size(); i++)
//        {
//            Tag tag = tagRepository.getById(tagIds.get(i));
//
//            tags.add(tag);
//        }

        task.setTitle(taskDTO.getTitle());
        task.setDesc(taskDTO.getDesc());
        task.setTag(taskDTO.getTag());
        task.setPriority(taskDTO.getPriority());
        task.setUser(user);
//        task.setDateCreated();
//        task.setLastUpdated();

//        task.setTags(tags);

        repository.save(task);

        return TaskTransformation.fromEntity(task);
    }

    public TaskDto updateTask(TaskDto taskDTO) {

        return newTask(taskDTO);

    }

    public String updateComplete(String id) {
        Task task = repository.getById(id);
        task.setComplete(true);
        return "task completed";
    }


    public String updateDelete(String id) {
        Task task = repository.getById(id);
        task.setFlag(true);
        return "soft deleted";
    }


    public void deleteTask(String id) {
        Task task = repository.getById(id);
        repository.delete(task);
    }


    public List<Task> getAllTask() {
        return repository.findAll();
    }

    public Task getTaskById(String id) {
        Optional< Task > optional = repository.findById(id);
        Task task = null;
        if (optional.isPresent()) {
            task = optional.get();
        } else {
            throw new RuntimeException(" Task not found for id :: " + id);
        }
        return task;
    }
}
