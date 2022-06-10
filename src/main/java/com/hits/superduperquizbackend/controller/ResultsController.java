package com.hits.superduperquizbackend.controller;

import com.hits.superduperquizbackend.DTO.result.CreateResultDTO;
import com.hits.superduperquizbackend.DTO.result.ResultDTO;
import com.hits.superduperquizbackend.service.ResultsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/results")
public class ResultsController {
    private final ResultsService resultsService;

    @PostMapping
    public ResultDTO createResult(Authentication authentication,
                                  @Validated @RequestBody CreateResultDTO dto) {
        return resultsService.createResult(authentication, dto);
    }
}
