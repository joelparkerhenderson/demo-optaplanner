package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class HasUUIDTest
{
    private Class<HasUUID> klass;

    public HasUUIDTest(Class<HasUUID> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethods() {
        try {
            assertSame(UUID.class, klass.getMethod("getUUID").getReturnType());
            assertSame(Void.TYPE, klass.getMethod("setUUID", UUID.class).getReturnType());
        } 
        catch(final java.lang.NoSuchMethodException e) {
            fail();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                    new Object[]{Maker.class},
                    new Object[]{MakerSet.class},
                    new Object[]{Taker.class},
                    new Object[]{TakerSet.class},
                    new Object[]{Matcher.class},
                    new Object[]{Solution.class}
        );
    }
}
