package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class HasTagsTest
{
    private Class<HasTags> klass;

    public HasTagsTest(Class<HasTags> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethods() {
        try {
            assertSame(Set.class, klass.getMethod("getTags").getReturnType());
            assertSame(Void.TYPE, klass.getMethod("setTags", Set.class).getReturnType());
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
                    new Object[]{TakerSet.class}
        );
    }
}
