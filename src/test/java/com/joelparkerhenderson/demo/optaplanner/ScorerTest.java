package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class ScorerTest
{
    protected Scorer _o() {
        final Scorer scorer = new Scorer();
        return scorer;
    }

    protected Scorer _scorer() {
        final Scorer scorer = new Scorer();
        scorer.setName("myScorer");
        return scorer;
    }

    protected Solution _solution() {
        final Solution solution = new Solution();
        solution.setName("mySolution");
        return solution;
    }

    protected Matcher _matcher() {
        final Matcher matcher = new Matcher();
        matcher.setName("myMatcher");
        return matcher;
    }

    protected Maker _maker() {
        final Maker maker = new Maker();
        maker.setName("myMaker");
        return maker;
    }

    protected Taker _taker() {
        final Taker taker = new Taker();
        taker.setName("myTaker");
        return taker;
    }

    protected TagSet _tagSet() {
        final TagSet tagSet = new TagSet();
        tagSet.setName("myTagSet");
        return tagSet;
    }

    protected HardSoftScore _score() {
        final HardSoftScore score = HardSoftScore.of(123,456);
        return score;
    }

    @Test
    public void toStringWithDefault()
    {
        final Scorer o = _o();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Scorer o = _scorer();
        assertEquals("name:myScorer", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Scorer o = _o();
        assertEquals("name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Scorer o = _scorer();
        assertEquals("name:myScorer", o.toStringDeep());
    }

    @Test
    public void name()
    {
        final Scorer o = _o();
        final String name = "myScorer";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void calculateScoreWithSolutionWithDefaults()
    {
        final Scorer o = _o();
        final Solution solution = _solution();

        solution.setMakers(new HashSet<Maker>());
        solution.setTakers(new HashSet<Taker>());
        solution.setMatchers(new HashSet<Matcher>());

        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScore(solution);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithSolutionWithMatchersExample()
    {
        final Scorer o = _o();
        final Solution solution = _solution();
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

        final HardSoftScore matcherAScore = o.calculateScoreWithMatcher(matcherA); assertNotEquals(HardSoftScore.ZERO, matcherAScore);
        final HardSoftScore matcherBScore = o.calculateScoreWithMatcher(matcherB); assertNotEquals(HardSoftScore.ZERO, matcherBScore);

        final HardSoftScore exp = HardSoftScore.ZERO.add(matcherAScore).add(matcherBScore);
        final HardSoftScore act = o.calculateScore(solution);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMatcherWithMakerNameTakerNameEqual()
    {
        final Scorer o = _o();
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
        final Scorer o = _o();
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
        final Scorer o = _o();
        final Maker maker = new Maker();
        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithMaker(maker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTaker()
    {
        final Scorer o = _o();
        final Taker taker = new Taker();
        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithTaker(taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNull()
    {
        final Scorer o = _o();
        final Maker maker = null;
        final Taker taker = null;
        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNameNull()
    {
        final Scorer o = _o();
        final String makerName = null;
        final String takerName = null;
        final Maker maker = new Maker(); maker.setName(makerName);
        final Taker taker = new Taker(); taker.setName(takerName);
        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNameEqual()
    {
        final Scorer o = _o();
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
        final Scorer o = _o();
        final String makerName = "alpha";
        final String takerName = "bravo";
        final Maker maker = new Maker(); maker.setName(makerName);
        final Taker taker = new Taker(); taker.setName(takerName);
        final HardSoftScore exp = HardSoftScore.of(0,-1);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

}
