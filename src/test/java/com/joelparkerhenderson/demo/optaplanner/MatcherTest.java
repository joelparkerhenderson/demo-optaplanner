package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatcherTest
{

    protected Matcher _o() {
        final Matcher matcher = new Matcher();
        return matcher;
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

    @Test
    public void toStringWithDefault()
    {
        final Matcher o = _o();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Matcher o = _matcher();
        assertEquals("name:myMatcher", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Matcher o = _o();
        assertEquals("name:null,maker:{null},taker:{null}", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Matcher o = _matcher();
        final Maker maker = _maker(); o.setMaker(maker);
        final Taker taker = _taker(); o.setTaker(taker);
        assertEquals("name:myMatcher,maker:{name:myMaker},taker:{name:myTaker}", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Matcher o = _o();
        final String exp =
            "<matcher/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Matcher o = _matcher();
        final Maker maker = _maker();
        o.setMaker(maker);
        final Taker taker = _taker();
        o.setTaker(taker);
        final String exp =
            "<matcher>\n" +
            "  <name>myMatcher</name>\n" +
            "  <maker>\n" +
            "    <name>myMaker</name>\n" +
            "  </maker>\n" +
            "  <taker>\n" +
            "    <name>myTaker</name>\n" +
            "  </taker>\n" +
            "</matcher>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<matcher>\n" +
            "  <name>myMatcher</name>\n" +
            "</matcher>";
        final Matcher o = Matcher.fromXMLString(xml);
        assertEquals("myMatcher", o.getName());
    }

    @Test
    public void maker()
    {
        final Matcher o = _o();
        final Maker maker = _maker();
        o.setMaker(maker);
        assertSame(maker, o.getMaker());
    }

    @Test
    public void taker()
    {
        final Matcher o = _o();
        final Taker taker = _taker();
        o.setTaker(taker);
        assertSame(taker, o.getTaker());
    }

}
