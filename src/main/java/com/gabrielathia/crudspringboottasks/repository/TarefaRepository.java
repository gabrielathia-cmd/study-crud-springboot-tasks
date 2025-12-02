package com.gabrielathia.crudspringboottasks.repository;

import com.gabrielathia.crudspringboottasks.enums.Status;
import com.gabrielathia.crudspringboottasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Task, Long>{
    List<Task> findByStatus(String status);
}
