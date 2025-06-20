package com.practice.management.respository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.management.entity.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

}
