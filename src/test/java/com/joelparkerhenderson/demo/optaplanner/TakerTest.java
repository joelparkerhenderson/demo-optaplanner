package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class TakerTest
{
    @Test
    public void toStringWithDefault()
    {
        final Taker o = new Taker();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Taker o = new Taker();
        assertEquals("name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toStringDeep());
    }

    @Test
    public void toXMLString()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        final String exp =
            "<taker>\n" +
            "  <name>foo</name>\n" +
            "</taker>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }
    
    @Test
    public void fromXMLString()
    {
        final String xml =
            "<taker>\n" +
            "  <name>foo</name>\n" +
            "</taker>";
        final Taker o = Taker.fromXMLString(xml);
        assertEquals("foo", o.getName());
    }

    @Test
    public void name()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void compareToWithEqual()
    {
        final Taker o = new Taker(); o.setName("A");
        final Taker x = new Taker(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Taker o = new Taker(); o.setName("A");
        final Taker x = new Taker(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Taker o = new Taker(); o.setName("B");
        final Taker x = new Taker(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
