package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class SolutionTest
{
    @Test
    public void toStringWithDefault()
    {
        final Solution o = new Solution();
        assertEquals("name:null,score:(0hard/0soft)", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Solution o = new Solution();
        final String name = "foo";
        o.setName(name);
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        assertEquals("name:foo,score:(123hard/456soft)", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Solution o = new Solution();
        assertEquals("name:null,score:(0hard/0soft),matchers:[]", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Solution o = new Solution();
        o.setName("A");
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        final Matcher matcher = new Matcher();
        matcher.setName("B");
        final Maker maker = new Maker(); maker.setName("C"); matcher.setMaker(maker);
        final Taker taker = new Taker(); taker.setName("D"); matcher.setTaker(taker);
        final Set<Matcher> matchers = new HashSet<Matcher>();
        matchers.add(matcher);     
        o.setMatchers(matchers);
        assertEquals("name:A,score:(123hard/456soft),matchers:[matcher:{name:B,maker:{name:C},taker:{name:D}}]", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Solution o = new Solution();
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
        final Solution o = new Solution();
        final String name = "mySolution";
        o.setName(name);
        final Maker maker = new Maker();
        maker.setName("myMaker");
        final Set<Maker> makers = new HashSet<Maker>();
        makers.add(maker);
        o.setMakers(makers);
        final Taker taker = new Taker();
        taker.setName("myTaker");
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
            "  <name>foo</name>\n" +
            "</solution>";
        final Solution o = Solution.fromXMLString(xml);
        assertEquals("foo", o.getName());
    }

    @Test
    public void name()
    {
        final Solution o = new Solution();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void score()
    {
        final Solution o = new Solution();
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        assertSame(score, o.getScore());
    }

    @Test
    public void makers()
    {
        final Solution o = new Solution();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }

    @Test
    public void takers()
    {
        final Solution o = new Solution();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }

    @Test
    public void matchers()
    {
        final Solution o = new Solution();
        final Set<Matcher> matchers = new HashSet<Matcher>();
        o.setMatchers(matchers);
        assertSame(matchers, o.getMatchers());
    }

}