package com.boot.app.repository;

import com.boot.app.entity.Task;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
