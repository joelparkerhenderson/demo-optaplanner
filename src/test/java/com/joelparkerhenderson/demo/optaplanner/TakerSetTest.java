package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TakerSetTest
{

    protected TakerSet _o() {
        final TakerSet TakerSet = new TakerSet();
        return TakerSet;
    }

    protected TakerSet _takerSet() {
        final TakerSet takerSet = new TakerSet();
        takerSet.setUUID(UUID.fromString("da953f4c-dd22-4d3c-a7c7-f50e90e41647"));
        takerSet.setName("myTakerSet");
        return takerSet;
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
    public void toXMLStringWithDefault()
    {
        final TakerSet o = _o();
        final String exp =
            "<taker-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TakerSet o = _takerSet();
        final String exp =
            "<taker-set>\n" +
            "  <uuid>da953f4c-dd22-4d3c-a7c7-f50e90e41647</uuid>\n" +
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
            "  <uuid>da953f4c-dd22-4d3c-a7c7-f50e90e41647</uuid>\n" +
            "  <name>myTakerSet</name>\n" +
            "</taker-set>";
        final TakerSet o = TakerSet.fromXMLString(xml);
        assertEquals("myTakerSet", o.getName());
    }

    @Test
    public void elements()
    {
        final TakerSet o = _o();
        final Set<Taker> elements = new HashSet<Taker>();
        o.setElements(elements);
        assertSame(elements, o.getElements());
    }

}
