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
        return _scorer("562fe584-0b95-4906-9f24-24cb72c39ed9", "myScorer");
    }

    protected Scorer _scorer(String uuidString, String name) {
        final Scorer scorer = new Scorer();
        scorer.setUUID(UUID.fromString("562fe584-0b95-4906-9f24-24cb72c39ed9"));
        scorer.setName("myScorer");
        return scorer;
    }


    protected Solution _solution() {
        return _solution("e270cf62-c704-4806-8d7a-69d3bc7d06d4", "mySolution");
    }

    protected Solution _solution(String uuidString, String name) {
        final Solution solution = new Solution();
        solution.setUUID(UUID.fromString(uuidString));
        solution.setName(name);
        return solution;
    }

    protected Matcher _matcher() {
        return _matcher("85a61bb4-996f-4498-a447-aabfe1069a65", "myMatcher");
    }

    protected Matcher _matcher(String uuidString, String name){
        final Matcher matcher = new Matcher(); 
        matcher.setUUID(UUID.fromString(uuidString));
        matcher.setName(name);
        return matcher;
    }

    protected Maker _maker() {
        return _maker("6a03f2f6-527a-4b35-bc7b-bf291a08a35f", "myMaker");
    }

    protected Maker _maker(String uuidString, String name){
        final Maker maker = new Maker();
        maker.setUUID(UUID.fromString(uuidString));
        maker.setName(name);
        return maker;
    }

    protected Taker _taker() {
        return _taker("7f6f5003-1c43-4607-9fb4-890a02f2bc2a", "myTaker");
    }

    protected Taker _taker(String uuidString, String name){
        final Taker taker = new Taker();
        taker.setUUID(UUID.fromString(uuidString));
        taker.setName(name);
        return taker;
    }

    protected Tag _tag(){
        return _tag("myTag");
    }

    protected Tag _tag(String name){
        final Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    protected TagSet _tagSet() {
        return _tagSet("myTagSet");
    }

    protected TagSet _tagSet(String name) {
        final TagSet tagSet = new TagSet();
        tagSet.setName(name);
        return tagSet;
    }

    protected TagScore _tagScore(){
        return _tagScore("myTagScore", _score());
    }

    protected TagScore _tagScore(String name, HardSoftScore score){
        final TagScore tagScore = new TagScore();
        tagScore.setName(name);
        tagScore.setScore(score);
        return tagScore;
    }

    protected TagScoreSet _tagScoreSet() {
        return _tagScoreSet("myTagScoreSet");
    }

    protected TagScoreSet _tagScoreSet(String name) {
        final TagScoreSet tagScoreSet = new TagScoreSet();
        tagScoreSet.setName(name);
        return tagScoreSet;
    }

    protected HardSoftScore _score() {
        final HardSoftScore score = HardSoftScore.of(123,456);
        return score;
    }

    @Test
    public void toStringWithDefault()
    {
        final Scorer o = _o();
        assertEquals("uuid:null,name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Scorer o = _scorer();
        assertEquals("uuid:562fe584-0b95-4906-9f24-24cb72c39ed9,name:myScorer", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Scorer o = _o();
        assertEquals("uuid:null,name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Scorer o = _scorer();
        assertEquals("uuid:562fe584-0b95-4906-9f24-24cb72c39ed9,name:myScorer", o.toStringDeep());
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
            "  <uuid>562fe584-0b95-4906-9f24-24cb72c39ed9</uuid>\n" +
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
            "  <uuid>562fe584-0b95-4906-9f24-24cb72c39ed9</uuid>\n" +
            "  <name>myScorer</name>\n" +
            "</scorer>";
        final Scorer o = Scorer.fromXMLString(xml);
        assertEquals("myScorer", o.getName());
    }

    @Test
    public void calculateScore_WithSolutionWithDefaults()
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
    public void calculateScore_WithSolutionWithMatchersExample()
    {
        final Scorer o = _o();
        final Solution solution = _solution();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);
        
        final Set<Maker> makers = new HashSet<Maker>();
        final Set<Taker> takers = new HashSet<Taker>();
        final Set<Matcher> matchers = new HashSet<Matcher>();

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet("myTagSet");
        tags.add(tag);
        tagSet.setElements(tags);

        final TagScore tagScore = _tagScore(name, score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        final TagScoreSet tagScoreSet = _tagScoreSet();
        tagScores.add(tagScore);
        tagScoreSet.setElements(tagScores);

        final Maker makerA = _maker(); makerA.setName("A"); makerA.setTagSet(tagSet); makerA.setTagScoreSet(tagScoreSet); makers.add(makerA);
        final Maker makerB = _maker(); makerB.setName("B"); makerB.setTagSet(tagSet); makerB.setTagScoreSet(tagScoreSet); makers.add(makerB);

        final Taker takerA = _taker(); takerA.setName("A"); takerA.setTagSet(tagSet); takerA.setTagScoreSet(tagScoreSet);  takers.add(takerA);
        final Taker takerB = _taker(); takerB.setName("B"); takerB.setTagSet(tagSet); takerB.setTagScoreSet(tagScoreSet); takers.add(takerB);

        final Matcher matcherA = _matcher(); matcherA.setName("A"); matcherA.setMaker(makerA); matcherA.setTaker(takerA); matchers.add(matcherA);
        final Matcher matcherB = _matcher(); matcherA.setName("B"); matcherB.setMaker(makerB); matcherB.setTaker(takerB); matchers.add(matcherB);

        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        final HardSoftScore exp = score.multiply(4);
        final HardSoftScore act = o.calculateScore(solution);
        assertEquals(exp, act);
    }

    //// calculateScoreWithTrackables() → Null | Joint | Disjoint

    @Test
    public void calculateScoreWithTrackables_Null()
    {
        final Scorer o = _o();
        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithTrackables(null, null);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTrackables_Joint()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet();
        tags.add(tag);
        tagSet.setElements(tags);

        final TagScore tagScore = _tagScore(name, score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        final TagScoreSet tagScoreSet = _tagScoreSet();
        tagScores.add(tagScore);
        tagScoreSet.setElements(tagScores);

        final Maker maker = new Maker(); maker.setTagSet(tagSet); maker.setTagScoreSet(tagScoreSet);
        final Taker taker = new Taker(); taker.setTagSet(tagSet); taker.setTagScoreSet(tagScoreSet);

        final HardSoftScore exp = score;
        final HardSoftScore act = o.calculateScoreWithTrackables(maker, taker);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTrackables_Disjoint()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet();
        tags.add(tag);
        tagSet.setElements(tags);

        final TagScore tagScore = _tagScore(name + "chaff", score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        final TagScoreSet tagScoreSet = _tagScoreSet();
        tagScores.add(tagScore);
        tagScoreSet.setElements(tagScores);

        final Maker maker = new Maker(); maker.setTagSet(tagSet); maker.setTagScoreSet(tagScoreSet);
        final Taker taker = new Taker(); taker.setTagSet(tagSet); taker.setTagScoreSet(tagScoreSet);

        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithTrackables(maker, taker);
        assertEquals(exp, act);
    }

    //// calculateScoreWithTagSetAndTagScoreSet() → Null | Joint | Disjoint

    @Test
    public void calculateScoreWithTagSetAndTagScoreSet_withNull()
    {
        final Scorer o = _o();
        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithTrackables(null, null);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagSetAndTagScoreSet_withJoint()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet();
        tags.add(tag);
        tagSet.setElements(tags);

        final TagScore tagScore = _tagScore(name, score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        final TagScoreSet tagScoreSet = _tagScoreSet();
        tagScores.add(tagScore);
        tagScoreSet.setElements(tagScores);

        final HardSoftScore exp = score;
        final HardSoftScore act = o.calculateScoreWithTagsAndTagScores(tags, tagScores);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagSetAndTagScoreSet_withDisjoint()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        final TagSet tagSet = _tagSet();
        tags.add(tag);
        tagSet.setElements(tags);

        final TagScore tagScore = _tagScore(name + "chaff", score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        final TagScoreSet tagScoreSet = _tagScoreSet();
        tagScores.add(tagScore);
        tagScoreSet.setElements(tagScores);

        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithTagSetAndTagScoreSet(tagSet, tagScoreSet);
        assertEquals(exp, act);
    }

    //// calculateScoreWithTagsAndTagScores() → Null | Joint | Disjoint

    @Test
    public void calculateScoreWithTagsAndTagScores_withNulls()
    {
        final Scorer o = _o();

        final Set<Tag> tags = null;
        final Set<TagScore> tagScores = null;

        final HardSoftScore exp = HardSoftScore.of(-1,0);
        final HardSoftScore act = o.calculateScoreWithTagsAndTagScores(tags, tagScores);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagsAndTagScores_withJointNames()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        tags.add(tag);

        final TagScore tagScore = _tagScore(name, score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        tagScores.add(tagScore);

        final HardSoftScore exp = score;
        final HardSoftScore act = o.calculateScoreWithTagsAndTagScores(tags, tagScores);
        assertEquals(exp, act);
    }

    @Test
    public void calculateScoreWithTagsAndTagScores_withDisjointNames()
    {
        final Scorer o = _o();
        final String name = "alpha";
        final HardSoftScore score = HardSoftScore.of(123,456);

        final Tag tag = _tag(name);
        final Set<Tag> tags = new HashSet<Tag>();
        tags.add(tag);

        final TagScore tagScore = _tagScore(name + "chaff", score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        tagScores.add(tagScore);

        final HardSoftScore exp = HardSoftScore.ZERO;
        final HardSoftScore act = o.calculateScoreWithTagsAndTagScores(tags, tagScores);
        assertEquals(exp, act);
    }

}
