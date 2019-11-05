package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class SolutionTest
{
    protected Solution _o() {
        final Solution solution = new Solution();
        return solution;
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
        final Solution o = _o();
        assertEquals("name:null,score:(0hard/0soft)", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Solution o = _solution();
        final HardSoftScore score = _score();
        o.setScore(score);
        assertEquals("name:mySolution,score:(123hard/456soft)", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Solution o = _o();
        assertEquals("name:null,score:(0hard/0soft),matchers:[]", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Solution o = _solution();
        final HardSoftScore score = _score();
        o.setScore(score);
        final Matcher matcher = _matcher();
        final Maker maker = _maker(); matcher.setMaker(maker);
        final Taker taker = _taker(); matcher.setTaker(taker);
        final Set<Matcher> matchers = new HashSet<Matcher>();
        matchers.add(matcher);     
        o.setMatchers(matchers);
        assertEquals("name:mySolution,score:(123hard/456soft),matchers:[matcher:{name:myMatcher,maker:{name:myMaker},taker:{name:myTaker}}]", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Solution o = _o();
        final String exp =
            "<solution>\n" +
            "  <score>\n" +
            "    <initScore>0</initScore>\n" +
            "    <hardScore>0</hardScore>\n" +
            "    <softScore>0</softScore>\n" +
            "  </score>\n" +
            "</solution>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Solution o = _solution();
        final Maker maker = _maker();
        final Set<Maker> makers = new HashSet<Maker>();
        makers.add(maker);
        o.setMakers(makers);
        final Taker taker = _taker();
        final Set<Taker> takers = new HashSet<Taker>();
        takers.add(taker);
        o.setTakers(takers);
        final String exp =
            "<solution>\n" +
            "  <name>mySolution</name>\n" +
            "  <score>\n" +
            "    <initScore>0</initScore>\n" +
            "    <hardScore>0</hardScore>\n" +
            "    <softScore>0</softScore>\n" +
            "  </score>\n" +
            "  <makers>\n" +
            "    <maker>\n" +
            "      <name>myMaker</name>\n" +
            "    </maker>\n" +
            "  </makers>\n" +
            "  <takers>\n" +
            "    <taker>\n" +
            "      <name>myTaker</name>\n" +
            "    </taker>\n" +
            "  </takers>\n" +
            "</solution>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<solution>\n" +
            "  <name>mySolution</name>\n" +
            "</solution>";
        final Solution o = Solution.fromXMLString(xml);
        assertEquals("mySolution", o.getName());
    }

    @Test
    public void name()
    {
        final Solution o = new Solution();
        final String name = "mySolution";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void score()
    {
        final Solution o = _o();
        final HardSoftScore score = _score();
        o.setScore(score);
        assertSame(score, o.getScore());
    }

    @Test
    public void makers()
    {
        final Solution o = _o();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }

    @Test
    public void takers()
    {
        final Solution o = _o();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }

    @Test
    public void matchers()
    {
        final Solution o = _o();
        final Set<Matcher> matchers = new HashSet<Matcher>();
        o.setMatchers(matchers);
        assertSame(matchers, o.getMatchers());
    }

}