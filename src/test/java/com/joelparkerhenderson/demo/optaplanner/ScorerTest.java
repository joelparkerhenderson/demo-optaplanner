package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class ScorerTest
{
    @Test
    public void calculateScoreWithSolutionWithDefaults()
    {
        final Scorer o = new Scorer();
        final Solution solution = new Solution();

        solution.setMakers(new HashSet<Maker>());
        solution.setTakers(new HashSet<Taker>());
        solution.setMatchers(new HashSet<Matcher>());

        final HardSoftScore exp = HardSoftScore.of(0,0);
        final HardSoftScore act = o.calculateScore(solution);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithSolutionWithMatchersExample()
    {
        final Scorer o = new Scorer();
        final Solution solution = new Solution();
        final Set<Maker> makers = new HashSet<Maker>();
        final Set<Taker> takers = new HashSet<Taker>();
        final Set<Matcher> matchers = new HashSet<Matcher>();

        final Maker makerA = new Maker(); makerA.setName("A"); makers.add(makerA);
        final Maker makerB = new Maker(); makerB.setName("B"); makers.add(makerB);

        final Taker takerA = new Taker(); takerA.setName("A"); takers.add(takerA);
        final Taker takerB = new Taker(); takerB.setName("B"); takers.add(takerB);

        final Matcher matcherA = new Matcher(); matcherA.setName("A"); matcherA.setMaker(makerA); matcherA.setTaker(takerA); matchers.add(matcherA);
        final Matcher matcherB = new Matcher(); matcherB.setName("B"); matcherB.setMaker(makerB); matcherB.setTaker(takerB); matchers.add(matcherB);

        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        final HardSoftScore matcherAScore = o.calculateScoreWithMatcher(matcherA); assertNotEquals(HardSoftScore.of(0,0), matcherAScore);
        final HardSoftScore matcherBScore = o.calculateScoreWithMatcher(matcherB); assertNotEquals(HardSoftScore.of(0,0), matcherBScore);

        final HardSoftScore exp = HardSoftScore.of(0,0).add(matcherAScore).add(matcherBScore);
        final HardSoftScore act = o.calculateScore(solution);
        assertEquals(exp, act);
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

    @Test
    public void calculateScoreWithMaker()
    {
        final Scorer o = new Scorer();
        final Maker maker = new Maker();
        final HardSoftScore exp = HardSoftScore.of(0,0);
        final HardSoftScore act = o.calculateScoreWithMaker(maker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTaker()
    {
        final Scorer o = new Scorer();
        final Taker taker = new Taker();
        final HardSoftScore exp = HardSoftScore.of(0,0);
        final HardSoftScore act = o.calculateScoreWithTaker(taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNull()
    {
        final Scorer o = new Scorer();
        final Maker maker = null;
        final Taker taker = null;
        final HardSoftScore exp = HardSoftScore.of(0,0);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNameNull()
    {
        final Scorer o = new Scorer();
        final String makerName = null;
        final String takerName = null;
        final Maker maker = new Maker(); maker.setName(makerName);
        final Taker taker = new Taker(); taker.setName(takerName);
        final HardSoftScore exp = HardSoftScore.of(0,0);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNameEqual()
    {
        final Scorer o = new Scorer();
        final String makerName = "alpha";
        final String takerName = "alpha";
        final Maker maker = new Maker(); maker.setName(makerName);
        final Taker taker = new Taker(); taker.setName(takerName);
        final HardSoftScore exp = HardSoftScore.of(0,1);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNameUnequal()
    {
        final Scorer o = new Scorer();
        final String makerName = "alpha";
        final String takerName = "bravo";
        final Maker maker = new Maker(); maker.setName(makerName);
        final Taker taker = new Taker(); taker.setName(takerName);
        final HardSoftScore exp = HardSoftScore.of(0,-1);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

}
