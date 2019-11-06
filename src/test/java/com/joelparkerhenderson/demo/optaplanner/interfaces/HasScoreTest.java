package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@RunWith(Parameterized.class)
public class HasScoreTest
{
    private Class<HasScore> klass;

    public HasScoreTest(Class<HasScore> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethods() {
        try {
            assertSame(HardSoftScore.class, klass.getMethod("getScore").getReturnType());
            assertSame(Void.TYPE, klass.getMethod("setScore", HardSoftScore.class).getReturnType());
        } 
        catch(final java.lang.NoSuchMethodException e) {
            fail();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{Solution.class},
                    new Object[]{Solution.class}
        );
    }
}
