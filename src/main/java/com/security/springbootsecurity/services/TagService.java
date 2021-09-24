package com.security.springbootsecurity.services;

import com.security.springbootsecurity.models.Tag;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.TagRepository;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;


    public Tag getById(String id) {
        return tagRepository.getById(id);
    }

    public String createTag(String title, String color, String userId) {
        Tag tag = new Tag();
        User user = userRepository.getById(userId);

        tag.setTitle(title);
        tag.setColor(color);
        //	tag.setTasks(null);

        tagRepository.save(tag);

        return "created";
    }

    public String updateTag(String id, String title, String color) {

        Tag tag = tagRepository.getById(id);

        tag.setTitle(title);
        tag.setColor(color);

        tagRepository.save(tag);

        return "updated";
    }

    public String deleteTag(String id) {

        Tag tag = tagRepository.getById(id);
        tagRepository.delete(tag);

        return "deleted";
    }


}

