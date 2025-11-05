package com.example.studytracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studytracker.entity.TopicsEntity;

@Repository
public interface TopicsRepo extends JpaRepository<TopicsEntity, Long>{
    
}
