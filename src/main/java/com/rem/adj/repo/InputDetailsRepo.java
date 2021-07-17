package com.rem.adj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rem.adj.entity.InputDetailsEntity;

@Repository
public interface InputDetailsRepo extends JpaRepository<InputDetailsEntity, Long>  {

	List<InputDetailsEntity> findAll();
}
