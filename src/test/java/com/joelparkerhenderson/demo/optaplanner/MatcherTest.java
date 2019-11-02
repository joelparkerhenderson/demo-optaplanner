package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatcherTest
{
    @Test
    public void toStringWithDefault()
    {
        final Matcher o = new Matcher();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Matcher o = new Matcher();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Matcher o = new Matcher();
        assertEquals("name:null,maker:{null},taker:{null}", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Matcher o = new Matcher();
        final String name = "A";
        o.setName(name);
        final Maker maker = new Maker(); maker.setName("B"); o.setMaker(maker);
        final Taker taker = new Taker(); taker.setName("C"); o.setTaker(taker);
        assertEquals("name:A,maker:{name:B},taker:{name:C}", o.toStringDeep());
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
