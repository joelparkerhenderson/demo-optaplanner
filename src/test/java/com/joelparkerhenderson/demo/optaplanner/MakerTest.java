package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MakerTest
{
    @Test
    public void name()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void compareToWithEqual()
    {
        final Maker o = new Maker(); o.setName("A");
        final Maker x = new Maker(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Maker o = new Maker(); o.setName("A");
        final Maker x = new Maker(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Maker o = new Maker(); o.setName("B");
        final Maker x = new Maker(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
