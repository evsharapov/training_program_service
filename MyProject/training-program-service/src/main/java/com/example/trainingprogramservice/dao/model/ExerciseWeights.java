package com.example.trainingprogramservice.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EXERCISEWEIGHTS")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseWeights {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "KEYWEIGHT")
    private Double keyWeight;

    @Column(name = "FIRSTWEIGHT")
    private Double firstWeight;

    @Column(name = "SECONDWEIGHT")
    private Double secondWeight;

    @Column(name = "THIRDWEIGHT")
    private Double thirdWeight;

    @Column(name = "FORTHWEIGHT")
    private Double forthWeight;

    @Column(name = "FIFTHWEIGHT")
    private Double fifthWeight;
}
