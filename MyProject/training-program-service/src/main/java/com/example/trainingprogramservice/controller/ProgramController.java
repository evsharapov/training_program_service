package com.example.trainingprogramservice.controller;

import com.example.trainingprogramservice.builder.ResponseBuilder;
import com.example.trainingprogramservice.dto.req.TrainingProgramReq;
import com.example.trainingprogramservice.service.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("${spring.application.name}")
@RequiredArgsConstructor
public class ProgramController {

    private final TrainingProgramService trainingProgramService;

    @GetMapping("/program")
    public ResponseEntity<?> getProgram (@RequestBody TrainingProgramReq req) {
        return ResponseBuilder.build(trainingProgramService.getTrainingProgram(req));
    }
}
