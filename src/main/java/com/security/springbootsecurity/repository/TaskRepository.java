package com.security.springbootsecurity.repository;

import com.security.springbootsecurity.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {

  //  public Page<Task> findAllByUserIdAndIsCompleteAndFlag(String userId, Boolean complete, Boolean flag, Pageable pePageable);

}
