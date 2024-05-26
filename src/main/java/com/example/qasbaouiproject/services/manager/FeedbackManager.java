package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Feedback;

import java.util.List;

public interface FeedbackManager {
    void saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    void deleteFeedbackById(Long id);

}
