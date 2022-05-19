package com.example.trainingprogramservice.service.impl;

import com.example.trainingprogramservice.dao.model.ExerciseWeights;
import com.example.trainingprogramservice.dao.repository.TrainingProgramRepository;
import com.example.trainingprogramservice.dto.req.TrainingProgramReq;
import com.example.trainingprogramservice.dto.res.TrainingProgramRes;
import com.example.trainingprogramservice.service.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;

    @Override
    public TrainingProgramRes getTrainingProgram(TrainingProgramReq req) {

        List<Double> keyWeights = new ArrayList<>();

        for (int i = 0; i < req.getWeeksCount(); i++) {

            keyWeights.add(req.getSquatsAmount() + (2.5 * i));
            keyWeights.add(req.getPressAmount() + (2.5 * i));
            keyWeights.add(req.getPullAmount() + (2.5 * i));
        }

        Map<Double, ExerciseWeights> exerciseWeightsMap = trainingProgramRepository.getExerciseWeightsByKeyWeightIn(keyWeights)
                .stream().collect(Collectors.toMap(ExerciseWeights::getKeyWeight, Function.identity()));

        TrainingProgramRes res = new TrainingProgramRes();
        List<TrainingProgramRes.WeekProgram> weekPrograms = new ArrayList<>();

        for (int i = 0; i < req.getWeeksCount(); i++) {

            ExerciseWeights squatsWeights = exerciseWeightsMap.get(req.getSquatsAmount() + (2.5 * i));
            ExerciseWeights pressWeights = exerciseWeightsMap.get(req.getPressAmount() + (2.5 * i));
            ExerciseWeights pullsWeights = exerciseWeightsMap.get(req.getPullAmount() + (2.5 * i));

            TrainingProgramRes.WeekProgram weekProgram = new TrainingProgramRes.WeekProgram();

            TrainingProgramRes.MondayProgram mondayProgram = new TrainingProgramRes.MondayProgram();
            mondayProgram.setStrongSquatsWeights(List.of(squatsWeights.getThirdWeight(), squatsWeights.getForthWeight(), squatsWeights.getFifthWeight(), squatsWeights.getKeyWeight()));
            mondayProgram.setWeakPullsWeights(List.of(pullsWeights.getFirstWeight(), pullsWeights.getSecondWeight(), pullsWeights.getThirdWeight(), pullsWeights.getForthWeight()));
            weekProgram.setMondayProgram(mondayProgram);

            TrainingProgramRes.WednesdayProgram wednesdayProgram = new TrainingProgramRes.WednesdayProgram();
            wednesdayProgram.setStrongPressWeights(List.of(pressWeights.getThirdWeight(), pressWeights.getForthWeight(), pressWeights.getFifthWeight(), pressWeights.getKeyWeight()));
            wednesdayProgram.setWeakSquatsWeights(List.of(squatsWeights.getFirstWeight(), squatsWeights.getSecondWeight(), squatsWeights.getThirdWeight(), squatsWeights.getForthWeight()));
            weekProgram.setWednesdayProgram(wednesdayProgram);

            TrainingProgramRes.FridayProgram fridayProgram = new TrainingProgramRes.FridayProgram();
            fridayProgram.setStrongPullsWeights(List.of(pullsWeights.getThirdWeight(), pullsWeights.getForthWeight(), pullsWeights.getFifthWeight(), pullsWeights.getKeyWeight()));
            fridayProgram.setWeakPressWeights(List.of(pressWeights.getFirstWeight(), pressWeights.getSecondWeight(), pressWeights.getThirdWeight(), pressWeights.getForthWeight()));
            weekProgram.setFridayProgram(fridayProgram);

            weekPrograms.add(weekProgram);
        }
        res.setWeekPrograms(weekPrograms);
        return res;
    }

}
