package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.result.CreateResultDTO;
import com.hits.superduperquizbackend.DTO.result.ResultDTO;
import com.hits.superduperquizbackend.converter.ResultConverter;
import com.hits.superduperquizbackend.entity.ResultEntity;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.QuizRepository;
import com.hits.superduperquizbackend.repository.ResultRepository;
import com.hits.superduperquizbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResultsService {

    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public ResultDTO createResult(Authentication authentication, CreateResultDTO dto) {
        var author = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        var quiz = quizRepository.findById(dto.getQuizId())
                .orElseThrow(() -> new NotFoundException("Викторина не найдена"));

        var result = ResultConverter.DTOToEntity(dto, author, quiz);
        var savedEntity = resultRepository.save(result);
        return ResultConverter.entityToDTO(savedEntity);
    }

    public List<ResultDTO> getAllResults(String quizId) {
        Page<ResultEntity> pageRequest;
        List<ResultEntity> list;
        if (Objects.equals(quizId, "")) {
            pageRequest = resultRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "quantity")));
            list = pageRequest.getContent();
        }
        else {
            var quiz = quizRepository.findById(quizId)
                    .orElseThrow(() -> new NotFoundException("Викторина не найдена"));
            list = resultRepository.findTop10ByQuizOrderByQuantityDesc(quiz);
        }
        var result = new ArrayList<ResultDTO>();
        for(var entity : list) {
            result.add(ResultConverter.entityToDTO(entity));
        }
        return result;
    }
}
