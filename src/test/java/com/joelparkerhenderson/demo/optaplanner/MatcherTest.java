package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatcherTest
{
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

}
