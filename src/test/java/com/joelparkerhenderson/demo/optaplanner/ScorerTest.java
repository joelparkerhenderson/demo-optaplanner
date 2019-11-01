package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class ScorerTest 
{
    @Test
    public void calculateScoreWithSolution()
    {
        final Scorer o = new Scorer();
        final Solution solution = new Solution();
        solution.setMakers(new HashSet<Maker>());
        solution.setTakers(new HashSet<Taker>());
        solution.setMatchers(new HashSet<Matcher>());
        final HardSoftScore score = HardSoftScore.of(0,0);
        assertEquals(score, o.calculateScore(solution));
    }

    @Test
    public void calculateScoreWithMatcherWithMakerNameTakerNameEqual()
    {
        final Scorer o = new Scorer();
        final String makerName = "alpha";
        final String takerName = "alpha";
        final Matcher matcher = new Matcher();
        final Maker maker = new Maker(); maker.setName(makerName); matcher.setMaker(maker);
        final Taker taker = new Taker(); taker.setName(takerName); matcher.setTaker(taker);
        final HardSoftScore exp = HardSoftScore.of(0,1);
        final HardSoftScore act = o.calculateScoreWithMatcher(matcher);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMatcherWithMakerNameTakerNameUnequal()
    {
        final Scorer o = new Scorer();
        final String makerName = "alpha";
        final String takerName = "bravo";
        final Matcher matcher = new Matcher();
        final Maker maker = new Maker(); maker.setName(makerName); matcher.setMaker(maker);
        final Taker taker = new Taker(); taker.setName(takerName); matcher.setTaker(taker);
        final HardSoftScore exp = HardSoftScore.of(0,-1);
        final HardSoftScore act = o.calculateScoreWithMatcher(matcher);
        assertEquals(exp, act);
    }

}
