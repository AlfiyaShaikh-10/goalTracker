package com.example.studytracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studytracker.entity.TopicsEntity;
import com.example.studytracker.repository.TopicsRepo;

@Service
public class TopicsService {
    
    @Autowired
    private TopicsRepo repo;

    public List<TopicsEntity> getAllTopics(){
        return repo.findAll(); 
    }
    
    public TopicsEntity getTopicById(long id){
        return repo.findById(id).orElseThrow(); 
    }

    public void addTopic(TopicsEntity topicsEntity){
        repo.save(topicsEntity);
    }

    public void toggleTopic(long id,Boolean complete){
        TopicsEntity existing = repo.findById(id).orElseThrow();
        if((existing != null)){
            existing.setComplete(complete);
            repo.save(existing);
        }
    }
    public void updateTopic(long id,TopicsEntity updatedValue){
        TopicsEntity existing = repo.findById(id).orElseThrow();
        if((existing != null)){
            existing.setTitle(updatedValue.getTitle());
            existing.setSubject(updatedValue.getSubject());
            existing.setComplete(updatedValue.isComplete());
            existing.setCreatedAt(new Date() );
            repo.save(existing);
        }
        
    }

    public void deleteTopic(long id){
        repo.deleteById(id);

    }
}
