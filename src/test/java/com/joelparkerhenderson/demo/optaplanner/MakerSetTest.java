package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class MakerSetTest
{
    @Test
    public void toXML()
    {
        final MakerSet o = new MakerSet();
        final String name = "foo";
        o.setName(name);
        final String exp =
            "<makerSet>\n" +
            "  <name>foo</name>\n" +
            "</makerSet>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXML()
    {
        final String xml =
            "<makerSet>\n" +
            "  <name>foo</name>\n" +
            "</makerSet>";
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
    public void makers()
    {
        final MakerSet o = new MakerSet();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }
}
