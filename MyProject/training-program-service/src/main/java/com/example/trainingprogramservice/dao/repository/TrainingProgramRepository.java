package com.example.trainingprogramservice.dao.repository;

import com.example.trainingprogramservice.dao.model.ExerciseWeights;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainingProgramRepository extends CrudRepository <ExerciseWeights, Long>{

    List<ExerciseWeights> getExerciseWeightsByKeyWeightIn(List<Double> keyWeights);

}
