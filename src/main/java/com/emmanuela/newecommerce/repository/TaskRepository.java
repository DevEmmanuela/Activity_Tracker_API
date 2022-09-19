package com.emmanuela.newecommerce.repository;

import com.emmanuela.newecommerce.entities.Task;
import com.emmanuela.newecommerce.entities.Users;
import com.emmanuela.newecommerce.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTaskByStatus(TaskStatus status);

//    @Query("SELECT task FROM Task task WHERE task.user1.id = ?1")
//    Task findTaskByTaskId(Long taskid);

    Task findTaskById(Long taskId);

    List<Task> findTaskByUser1(Users users);
    Task findTaskByTitle(String title);

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Task task WHERE task.id = ?1")
//    void deleteTaskById(Long taskId);
}
