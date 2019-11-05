package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TagScoreTest
{
    @Test
    public void toStringWithDefault()
    {
        final TagScore o = new TagScore();
        assertEquals("name:null,score:(0hard/0soft)", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final TagScore o = new TagScore();
        final String name = "myTagScore";
        o.setName(name);
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        assertEquals("name:myTagScore,score:(123hard/456soft)", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final TagScore o = new TagScore();
        assertEquals("name:null,score:(0hard/0soft)", o.toString());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final TagScore o = new TagScore();
        final String name = "myTagScore";
        o.setName(name);
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        assertEquals("name:myTagScore,score:(123hard/456soft)", o.toString());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final TagScore o = new TagScore();
        final String exp =
            "<tag-score>\n" +
            "  <score>\n" +
            "    <initScore>0</initScore>\n" +
            "    <hardScore>0</hardScore>\n" +
            "    <softScore>0</softScore>\n" +
            "  </score>\n" +
            "</tag-score>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TagScore o = new TagScore();
        final String name = "myTagScore";
        o.setName(name);
        final HardSoftScore score = HardSoftScore.of(123,456);
        o.setScore(score);
        final String exp =
            "<tag-score>\n" +
            "  <name>myTagScore</name>\n" +
            "  <score>\n" +
            "    <initScore>0</initScore>\n" +
            "    <hardScore>123</hardScore>\n" +
            "    <softScore>456</softScore>\n" +
            "  </score>\n" +
            "</tag-score>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<tag-score>\n" +
            "  <name>myTagScore</name>\n" +
            "  <score>\n" +
            "    <initScore>0</initScore>\n" +
            "    <hardScore>123</hardScore>\n" +
            "    <softScore>456</softScore>\n" +
            "  </score>\n" +
            "</tag-score>";
        final TagScore o = TagScore.fromXMLString(xml);
        assertEquals("myTagScore", o.getName());
    }

    @Test
    public void name()
    {
        final TagScore o = new TagScore();
        final String name = "myTagScore";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void compareToWithLesserName()
    {
        final TagScore o = new TagScore(); o.setName("A");
        final TagScore x = new TagScore(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreaterName()
    {
        final TagScore o = new TagScore(); o.setName("B");
        final TagScore x = new TagScore(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

    @Test
    public void compareToWithEqualNameAndLesserScore()
    {
        final TagScore o = new TagScore(); o.setName("A"); o.setScore(HardSoftScore.of(1,1));
        final TagScore x = new TagScore(); x.setName("A"); x.setScore(HardSoftScore.of(2,2));
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithEqualNameAndGreaterScore()
    {
        final TagScore o = new TagScore(); o.setName("A"); o.setScore(HardSoftScore.of(2,2));
        final TagScore x = new TagScore(); x.setName("A"); x.setScore(HardSoftScore.of(1,1));
        assertEquals(1, o.compareTo(x));
    }

    @Test
    public void compareToWithEqualNameAndEqualScore()
    {
        final TagScore o = new TagScore(); o.setName("A"); o.setScore(HardSoftScore.ZERO);
        final TagScore x = new TagScore(); x.setName("A"); x.setScore(HardSoftScore.ZERO);
        assertEquals(0, o.compareTo(x));
    }

}
