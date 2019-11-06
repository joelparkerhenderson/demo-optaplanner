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

    protected Matcher _matcher(String name){
        final Matcher matcher = new Matcher(); 
        matcher.setName(name); 
        return matcher;
    }

    protected Maker _maker() {
        final Maker maker = new Maker();
        maker.setName("myMaker");
        return maker;
    }

    protected Maker _maker(String name){
        final Maker maker = new Maker();
        maker.setName(name);
        return maker;
    }

    protected Taker _taker() {
        final Taker taker = new Taker();
        taker.setName("myTaker");
        return taker;
    }

    protected Taker _taker(String name){
        final Taker taker = new Taker();
        taker.setName(name);
        return taker;
    }

    protected Tag _tag(){
        final Tag tag = new Tag();
        tag.setName("myTag");
        return tag;
    }

    protected Tag _tag(String name){
        final Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    protected TagSet _tagSet() {
        final TagSet tagSet = new TagSet();
        tagSet.setName("myTagSet");
        return tagSet;
    }

    protected TagSet _tagSet(String name) {
        final TagSet tagSet = new TagSet();
        tagSet.setName(name);
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
    public void toXMLStringWithDefault()
    {
        final Scorer o = _o();
        final String exp =
            "<scorer/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Scorer o = _scorer();
        final String exp =
            "<scorer>\n" +
            "  <name>myScorer</name>\n" +
            "</scorer>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<scorer>\n" +
            "  <name>myScorer</name>\n" +
            "</scorer>";
        final Scorer o = Scorer.fromXMLString(xml);
        assertEquals("myScorer", o.getName());
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

        final Tag tag = _tag("myTag");
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet("myTagSet");
        tagSet.setTags(tags);

        final Maker makerA = _maker("A"); makerA.setTagSet(tagSet); makers.add(makerA);
        final Maker makerB = _maker("B"); makerB.setTagSet(tagSet); makers.add(makerB);

        final Taker takerA = _taker("A"); takerA.setTagSet(tagSet); takers.add(takerA);
        final Taker takerB = _taker("B"); takerB.setTagSet(tagSet); takers.add(takerB);

        final Matcher matcherA = _matcher("A"); matcherA.setMaker(makerA); matcherA.setTaker(takerA); matchers.add(matcherA);
        final Matcher matcherB = _matcher("B"); matcherB.setMaker(makerB); matcherB.setTaker(takerB); matchers.add(matcherB);

        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        final HardSoftScore exp = HardSoftScore.of(0,2);
        final HardSoftScore act = o.calculateScore(solution);
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
    public void calculateScoreWithMakerNull()
    {
        final Scorer o = _o();
        final Maker maker = null;
        final HardSoftScore exp = HardSoftScore.of(-1,0);
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
    public void calculateScoreWithTakerNull()
    {
        final Scorer o = _o();
        final Taker taker = null;
        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithTaker(taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithMakerTakerNull()
    {
        final Scorer o = _o();
        final Maker maker = null;
        final Taker taker = null;

        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithMakerTaker(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagSetsNull()
    {
        final Scorer o = _o();

        final TagSet tagSet = null;

        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithTagSets(tagSet, tagSet);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagSetsEqual()
    {
        final Scorer o = _o();

        final Tag tag = _tag("myTag");
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet("myTagSet");
        tagSet.setTags(tags);

        final HardSoftScore exp = HardSoftScore.of(0,1);
        final HardSoftScore act = o.calculateScoreWithTagSets(tagSet, tagSet);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagSetsUnequal()
    {
        final Scorer o = _o();

        final Tag tagA = _tag("myTagA");
        final Set<Tag> tagsA = new HashSet<Tag>();
        final TagSet tagSetA = _tagSet("myTagSetA");
        tagSetA.setTags(tagsA);

        final Tag tagB = _tag("myTagB");
        final Set<Tag> tagsB = new HashSet<Tag>();
        final TagSet tagSetB = _tagSet("myTagSetB");
        tagSetB.setTags(tagsB);

        final HardSoftScore exp = HardSoftScore.of(0,-1);
        final HardSoftScore act = o.calculateScoreWithTagSets(tagSetA, tagSetB);
        assertEquals(exp, act);
    }

}
