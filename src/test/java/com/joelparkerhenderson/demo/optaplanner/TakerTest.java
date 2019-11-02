package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class TakerTest
{
    @Test
    public void toStringWithDefault()
    {
        final Taker o = new Taker();
        assertEquals("Taker name:null", o.toString());
    }

    @Test
    public void toStringWithName()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        assertEquals("Taker name:foo", o.toString());
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
