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
            "<takerSet/>";
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
            "<takerSet>\n" +
            "  <name>myTakerSet</name>\n" +
            "</takerSet>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<takerSet>\n" +
            "  <name>foo</name>\n" +
            "</takerSet>";
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
    public void takers()
    {
        final TakerSet o = new TakerSet();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }
}
