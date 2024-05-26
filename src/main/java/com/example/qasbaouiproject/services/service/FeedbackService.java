package com.example.qasbaouiproject.services.service;

import com.example.qasbaouiproject.dao.entities.Feedback;
import com.example.qasbaouiproject.dao.repositories.FeedbackRepository;
import com.example.qasbaouiproject.services.manager.FeedbackManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements FeedbackManager {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    @Override
    public void deleteFeedbackById(Long id) {
        feedbackRepository.deleteById(id);
    }

}
