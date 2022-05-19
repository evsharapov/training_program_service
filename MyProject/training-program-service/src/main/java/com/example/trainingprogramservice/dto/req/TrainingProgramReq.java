package com.example.trainingprogramservice.dto.req;

import lombok.Data;

@Data
public class TrainingProgramReq {
    private Integer weeksCount;
    private Double squatsAmount;
    private Double pressAmount;
    private Double pullAmount;
}
