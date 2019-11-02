package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatcherTest
{
    @Test
    public void toStringWithDefault()
    {
        final Maker o = new Maker();
        assertEquals("Maker name:null", o.toString());
    }

    @Test
    public void toStringWithName()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        assertEquals("Maker name:foo", o.toString());
    }

    @Test
    public void name()
    {
        final Matcher o = new Matcher();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void maker()
    {
        final Matcher o = new Matcher();
        final Maker maker = new Maker();
        o.setMaker(maker);
        assertSame(maker, o.getMaker());
    }

    @Test
    public void taker()
    {
        final Matcher o = new Matcher();
        final Taker taker = new Taker();
        o.setTaker(taker);
        assertSame(taker, o.getTaker());
    }

    @Test
    public void compareToWithEqual()
    {
        final Matcher o = new Matcher(); o.setName("A");
        final Matcher x = new Matcher(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Matcher o = new Matcher(); o.setName("A");
        final Matcher x = new Matcher(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Matcher o = new Matcher(); o.setName("B");
        final Matcher x = new Matcher(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
