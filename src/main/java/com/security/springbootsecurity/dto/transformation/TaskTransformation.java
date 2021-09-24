package com.security.springbootsecurity.dto.transformation;

import com.security.springbootsecurity.dto.TaskDto;
import com.security.springbootsecurity.models.Tag;
import com.security.springbootsecurity.models.Task;
import com.security.springbootsecurity.models.User;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class TaskTransformation {
    public static TaskDto fromEntity(Task task) {

        TaskDto taskDTO = new TaskDto();

        taskDTO.setTitle(task.getTitle());
        taskDTO.setDesc(task.getDesc());
        taskDTO.setTag(task.getTag());
        taskDTO.setPriority(task.getPriority());

//        List<Tag> tags = task.getTags();
//        List<String> tagIds = new ArrayList<String>();
//
//        for(int i=0; i<tags.size(); i++)
//        {
//            Tag tag = tags.get(i);
//            tagIds.add(tag.getId());
//        }
//
//        taskDTO.setTagIds(tagIds);

        return taskDTO;
    }

    public static List<TaskDto> fromEntity(Page<Task> page) {

        List<Task> list = page.getContent();

        List<TaskDto> listDTO = new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {

            Task task = list.get(i);
            TaskDto taskDTO = fromEntity(task);
            listDTO.add(taskDTO);
        }

        return listDTO;
    }
}

