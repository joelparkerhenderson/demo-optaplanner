package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TakerSetTest
{
    @Test
    public void toXMLStringWithDefault()
    {
        final TakerSet o = new TakerSet();
        final String exp =
            "<taker-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TakerSet o = new TakerSet();
        final String name = "myTakerSet";
        o.setName(name);
        final String exp =
            "<taker-set>\n" +
            "  <name>myTakerSet</name>\n" +
            "</taker-set>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<taker-set>\n" +
            "  <name>foo</name>\n" +
            "</taker-set>";
        final TakerSet o = TakerSet.fromXMLString(xml);
        assertEquals("foo", o.getName());
    }

    @Test
    public void name()
    {
        final TakerSet o = new TakerSet();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void tags()
    {
        final TakerSet o = new TakerSet();
        final String tag = "myTag";
        final Set<String> tags = new HashSet<String>();
        tags.add(tag);
        o.setTags(tags);
        assertEquals(tags, o.getTags());
    }

    @Test
    public void takers()
    {
        final TakerSet o = new TakerSet();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }
}
