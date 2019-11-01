package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class Scorer implements EasyScoreCalculator<Solution> {

    public HardSoftScore calculateScore(Solution solution) {
        int hardScore = 0;
        int softScore = 0;
        return HardSoftScore.valueOf(hardScore, softScore);
    }

}