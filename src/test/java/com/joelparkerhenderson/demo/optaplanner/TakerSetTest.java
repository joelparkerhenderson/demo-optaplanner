package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TakerSetTest
{
    @Test
    public void toXML()
    {
        final TakerSet o = new TakerSet();
        final String name = "foo";
        o.setName(name);
        final String exp =
            "<takerSet>\n" +
            "  <name>foo</name>\n" +
            "</takerSet>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
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
