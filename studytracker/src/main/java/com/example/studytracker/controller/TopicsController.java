package com.example.studytracker.controller;

import java.util.Date;
import java.util.List;
import com.example.studytracker.entity.TopicsEntity;
import com.example.studytracker.service.TopicsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/topics")
public class TopicsController {
    
    @Autowired
    private TopicsService service;

    @GetMapping 
    public List<TopicsEntity> getTopics(){
        return service.getAllTopics();
    }

    @PostMapping
    public void postTopic(@RequestBody TopicsEntity entity) {
        service.addTopic(entity);        
    }

    @GetMapping("/{id}")
    public TopicsEntity getTopicById(@PathVariable long id){
        return service.getTopicById(id);
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable long id, @RequestBody TopicsEntity updaTopicsEntity) {
        service.updateTopic(id, updaTopicsEntity);;
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable long id){
        service.deleteTopic(id);
    }
    
}
