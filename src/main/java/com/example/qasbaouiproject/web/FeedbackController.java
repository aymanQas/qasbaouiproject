package com.example.qasbaouiproject.web;

import com.example.qasbaouiproject.dao.entities.Feedback;
import com.example.qasbaouiproject.services.manager.FeedbackManager;
import com.example.qasbaouiproject.services.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackManager feedbackManager;

    @PostMapping("/submit")
    public String submitFeedback(@RequestParam("satisfaction") String satisfaction,
                                 @RequestParam("email") String email,
                                 @RequestParam("commentaire") String commentaire,
                                 Model model) {
        Feedback feedback = new Feedback();
        feedback.setSatisfaction(satisfaction);
        feedback.setEmail(email);
        feedback.setCommentaire(commentaire);
        feedbackManager.saveFeedback(feedback);

        model.addAttribute("message", "Thank you for your feedback");

        return "feedback";
    }

    @GetMapping("")
    public String feedbackPage() {
        return "feedback";
    }
    @GetMapping("/indexfeed")
    public String indexFeed(Model model) {
        List<Feedback> feedbacks = feedbackManager.getAllFeedbacks();
        model.addAttribute("listFeedbacks", feedbacks);
        return "indexfeed";
    }
    @PostMapping("/delete")
    public String deleteFeedback(@RequestParam("id") Long id) {
        feedbackManager.deleteFeedbackById(id);
        return "redirect:/feedback/indexfeed";
    }

}
