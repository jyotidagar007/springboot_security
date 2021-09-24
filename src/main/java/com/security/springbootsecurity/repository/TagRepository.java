package com.security.springbootsecurity.repository;

import com.security.springbootsecurity.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, String> {

}

