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
        final TakerSet TakerSet = new TakerSet();
        TakerSet.setName("myTakerSet");
        return TakerSet;
    }
    protected Taker _taker() {
        final Taker Taker = new Taker();
        Taker.setName("myTaker");
        return Taker;
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
            "  <name>myTakerSet</name>\n" +
            "</taker-set>";
        final TakerSet o = TakerSet.fromXMLString(xml);
        assertEquals("myTakerSet", o.getName());
    }

    @Test
    public void name()
    {
        final TakerSet o = _o();
        final String name = "myTakerSet";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tags()
    {
        final TakerSet o = _o();
        final TagSet tagSet =_tagSet();
        o.setTagSet(tagSet);
        assertSame(tagSet, o.getTagSet());
    }

    @Test
    public void takers()
    {
        final TakerSet o = _o();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }
}
