package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SolutionTest 
{
    @Test
    public void name()
    {
        final Solution o = new Solution();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void score()
    {
        final Solution o = new Solution();
        final int score = 123;
        o.setScore(score);
        assertSame(score, o.getScore());
    }

    @Test
    public void makers()
    {
        final Solution o = new Solution();
        final Set<Maker> makers = new HashSet<Maker>();
        o.setMakers(makers);
        assertSame(makers, o.getMakers());
    }

    @Test
    public void takers()
    {
        final Solution o = new Solution();
        final Set<Taker> takers = new HashSet<Taker>();
        o.setTakers(takers);
        assertSame(takers, o.getTakers());
    }

    @Test
    public void matchers()
    {
        final Solution o = new Solution();
        final Set<Matcher> matchers = new HashSet<Matcher>();
        o.setMatchers(matchers);
        assertSame(matchers, o.getMatchers());
    }

}