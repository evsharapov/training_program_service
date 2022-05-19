package com.example.trainingprogramservice.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class TrainingProgramRes {

    private List<WeekProgram> weekPrograms;

    @Data
    public static class WeekProgram{
        private MondayProgram mondayProgram;
        private WednesdayProgram wednesdayProgram;
        private FridayProgram fridayProgram;
    }

    @Data
    public static class MondayProgram{
        private List<Double> strongSquatsWeights;
        private List<Double> weakPullsWeights;
    }

    @Data
    public static class WednesdayProgram{
        private List<Double> strongPressWeights;
        private List<Double> weakSquatsWeights;
    }

    @Data
    public static class FridayProgram{
        private List<Double> strongPullsWeights;
        private List<Double> weakPressWeights;
    }
}
