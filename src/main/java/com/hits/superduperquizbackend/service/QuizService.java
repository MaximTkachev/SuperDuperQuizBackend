package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.quiz.CreateQuizDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.entity.QuizEntity;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.CategoryRepository;
import com.hits.superduperquizbackend.repository.QuizRepository;
import com.hits.superduperquizbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public QuizDTO createQuiz(Authentication authentication, CreateQuizDTO dto) {
        var user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        var category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category didn't found"));

        var quiz = new QuizEntity(dto.getName(), dto.getDescription(), dto.getDifficult(), user, category);

        var savedEntity = quizRepository.save(quiz);

        return new QuizDTO(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getDescription(),
                savedEntity.getDifficult(),
                savedEntity.getCategory().getId(),
                new HashSet<>());
    }
}
