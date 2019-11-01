package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class TakerTest
{
    @Test
    public void name()
    {
        final Taker o = new Taker();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }
}
