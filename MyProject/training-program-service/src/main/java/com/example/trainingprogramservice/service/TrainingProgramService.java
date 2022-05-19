package com.example.trainingprogramservice.service;

import com.example.trainingprogramservice.dto.req.TrainingProgramReq;
import com.example.trainingprogramservice.dto.res.TrainingProgramRes;

public interface TrainingProgramService {

    TrainingProgramRes getTrainingProgram(TrainingProgramReq req);
}
