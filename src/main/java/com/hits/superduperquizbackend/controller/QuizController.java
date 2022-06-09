package com.hits.superduperquizbackend.controller;

import com.hits.superduperquizbackend.DTO.quiz.CreateQuizDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    public QuizDTO createQuiz(Authentication authentication, @Validated @RequestBody CreateQuizDTO dto) {
        return quizService.createQuiz(authentication, dto);
    }

    @GetMapping("/{id}")
    public QuizDTO getQuizById(@PathVariable UUID id) {
        return quizService.getQuizById(id.toString());
    }
}
