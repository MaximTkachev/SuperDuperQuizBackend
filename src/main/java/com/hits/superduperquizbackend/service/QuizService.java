package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.quiz.CreateQuizDTO;
import com.hits.superduperquizbackend.DTO.quiz.QuizDTO;
import com.hits.superduperquizbackend.converter.QuizConverter;
import com.hits.superduperquizbackend.entity.AnswerOptionEntity;
import com.hits.superduperquizbackend.entity.QuestionEntity;
import com.hits.superduperquizbackend.entity.QuizEntity;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final AnswerOptionRepository answerOptionRepository;

    @Transactional
    public QuizDTO createQuiz(Authentication authentication, CreateQuizDTO dto) {
        var user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        var category = categoryRepository.findById(dto.getCategory())
                .orElseThrow(() -> new NotFoundException("Category didn't found"));

        var quiz = new QuizEntity(dto.getName(), dto.getDescription(), dto.getDifficulty(), user, category);
        var savedEntity = quizRepository.save(quiz);
        for (var question : dto.getQuestions()) {
            var questionEntity = new QuestionEntity(question.getText(), savedEntity);

            var savedQuestion = questionRepository.save(questionEntity);
            for (var answer : question.getAnswers()) {
                var answerEntity = new AnswerOptionEntity(
                        UUID.randomUUID().toString(),
                        answer.getText(),
                        answer.getIsRight(),
                        savedQuestion
                );

                answerOptionRepository.save(answerEntity);
            }
        }

        System.out.println("!");

        savedEntity = quizRepository.findById(savedEntity.getId())
                .orElseThrow(() -> new NotFoundException(""));

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
