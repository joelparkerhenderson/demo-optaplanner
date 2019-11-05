package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class MakerSetTest
{
    @Test
    public void toXMLStringWithDefault()
    {
        final MakerSet o = new MakerSet();
        final String exp =
            "<maker-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final MakerSet o = new MakerSet();
        final String name = "myMakerSet";
        o.setName(name);
        final String exp =
            "<maker-set>\n" +
            "  <name>myMakerSet</name>\n" +
            "</maker-set>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<maker-set>\n" +
            "  <name>foo</name>\n" +
            "</maker-set>";
        final MakerSet o = MakerSet.fromXMLString(xml);
        assertEquals("foo", o.getName());
    }

    @Test
    public void name()
    {
        final MakerSet o = new MakerSet();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void tags()
    {
        final MakerSet o = new MakerSet();
        final TagSet tagSet = new TagSet();
        o.setTagSet(tagSet);
        assertSame(tagSet, o.getTagSet());
    }

    @Test
    public void makers()
    {
        final MakerSet o = new MakerSet();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }
}
