package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class ScorerTest 
{
    @Test
    public void name()
    {
        final Scorer o = new Scorer();
        final Solution solution = new Solution();
        final HardSoftScore score = HardSoftScore.of(0,0);
        assertEquals(score, o.calculateScore(solution));
    }
}
