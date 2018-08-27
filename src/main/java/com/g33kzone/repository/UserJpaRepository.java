package com.g33kzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.g33kzone.model.ToDo;

@Service
public interface UserJpaRepository extends JpaRepository<ToDo, Long>{

}
