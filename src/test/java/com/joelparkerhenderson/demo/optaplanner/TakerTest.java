package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TakerTest
{
    protected Taker _o() {
        final Taker taker = new Taker();
        return taker;
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
        final Taker o = _o();
        assertEquals("uuid:null,name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Taker o = _taker();
        assertEquals("uuid:7f6f5003-1c43-4607-9fb4-890a02f2bc2a,name:myTaker", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Taker o = _o();
        assertEquals("uuid:null,name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Taker o = _taker();
        assertEquals("uuid:7f6f5003-1c43-4607-9fb4-890a02f2bc2a,name:myTaker", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Taker o = _o();
        final String exp =
            "<taker/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }
    
    @Test
    public void toXMLStringWithTypical()
    {
        final Taker o = _taker();
        final String exp =
            "<taker>\n" +
            "  <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>\n" +
            "  <name>myTaker</name>\n" +
            "</taker>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<taker>\n" +
            "  <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>\n" +
            "  <name>myTaker</name>\n" +
            "</taker>";
        final Taker o = Taker.fromXMLString(xml);
        assertEquals("myTaker", o.getName());
    }

}
