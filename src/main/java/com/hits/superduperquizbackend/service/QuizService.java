package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.quiz.CreateQuizDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.converter.QuizConverter;
import com.hits.superduperquizbackend.entity.QuizEntity;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.CategoryRepository;
import com.hits.superduperquizbackend.repository.QuizRepository;
import com.hits.superduperquizbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        return QuizConverter.entityToDTO(savedEntity);
    }

    public QuizDTO getQuizById(String id) {
        var entity =  quizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Викторина не найдена"));

        return QuizConverter.entityToDTO(entity);
    }

    public List<QuizDTO> getAllQuizzes(String categoryId) {
        List<QuizEntity> quizzes;
        if (!Objects.equals(categoryId, "")) {
            var category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new NotFoundException("Категория не найдена"));
            quizzes = quizRepository.findByCategory(category);
        }
        else
            quizzes = quizRepository.findAll();

        List<QuizDTO> result = new ArrayList<>();
        for(var quiz : quizzes) {
            result.add(QuizConverter.entityToDTO(quiz));
        }

        return result;
    }
}
