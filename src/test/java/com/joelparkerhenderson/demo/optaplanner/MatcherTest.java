package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class MatcherTest
{

    protected Matcher _o() {
        final Matcher matcher = new Matcher();
        return matcher;
    }

    protected Matcher _matcher() {
        final Matcher matcher = new Matcher();
        matcher.setUUID(UUID.fromString("85a61bb4-996f-4498-a447-aabfe1069a65"));
        matcher.setName("myMatcher");
        return matcher;
    }

    protected Maker _maker() {
        final Maker maker = new Maker();
        maker.setUUID(UUID.fromString("6a03f2f6-527a-4b35-bc7b-bf291a08a35f"));
        maker.setName("myMaker");
        return maker;
    }

    protected Taker _taker() {
        final Taker taker = new Taker();
        taker.setUUID(UUID.fromString("7f6f5003-1c43-4607-9fb4-890a02f2bc2a"));
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
        assertEquals("uuid:null,name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Matcher o = _matcher();
        assertEquals("uuid:85a61bb4-996f-4498-a447-aabfe1069a65,name:myMatcher", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Matcher o = _o();
        assertEquals("uuid:null,name:null,maker:{null},taker:{null}", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Matcher o = _matcher();
        final Maker maker = _maker(); o.setMaker(maker);
        final Taker taker = _taker(); o.setTaker(taker);
        assertEquals("uuid:85a61bb4-996f-4498-a447-aabfe1069a65,name:myMatcher,maker:{uuid:6a03f2f6-527a-4b35-bc7b-bf291a08a35f,name:myMaker},taker:{uuid:7f6f5003-1c43-4607-9fb4-890a02f2bc2a,name:myTaker}", o.toStringDeep());
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
            "  <uuid>85a61bb4-996f-4498-a447-aabfe1069a65</uuid>\n" +
            "  <name>myMatcher</name>\n" +
            "  <maker>\n" +
            "    <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>\n" +
            "    <name>myMaker</name>\n" +
            "  </maker>\n" +
            "  <taker>\n" +
            "    <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>\n" +
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
            "  <uuid>85a61bb4-996f-4498-a447-aabfe1069a65</uuid>\n" +
            "  <name>myMatcher</name>\n" +
            "  <maker>\n" +
            "    <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>\n" +
            "    <name>myMaker</name>\n" +
            "  </maker>\n" +
            "  <taker>\n" +
            "    <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>\n" +
            "    <name>myTaker</name>\n" +
            "  </taker>\n" +
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
