package com.joelparkerhenderson.demo.optaplanner.interfaces;

import com.joelparkerhenderson.demo.optaplanner.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class ToStringDeepTest
{
    private Class<ToStringDeep> klass;

    public ToStringDeepTest(Class<ToStringDeep> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethod() {
        try {
            assertSame(String.class, klass.getMethod("toStringDeep").getReturnType());
        } 
        catch(final java.lang.NoSuchMethodException e) {
            fail();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{Maker.class},
                    new Object[]{Taker.class},
                    new Object[]{Matcher.class},
                    new Object[]{Solution.class}
        );
    }
}
