package com.example.qasbaouiproject.dao.repositories;

import com.example.qasbaouiproject.dao.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
