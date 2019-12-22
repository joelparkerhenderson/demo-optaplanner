package com.joelparkerhenderson.demo.optaplanner.interfaces;
import com.joelparkerhenderson.demo.optaplanner.TagScoreSet;

import com.joelparkerhenderson.demo.optaplanner.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class HasTagScoreSetTest
{
    private Class<HasTagScoreSet> klass;

    public HasTagScoreSetTest(Class<HasTagScoreSet> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethods() {
        try {
            assertSame(TagScoreSet.class, klass.getMethod("getTagScoreSet").getReturnType());
            assertSame(Void.TYPE, klass.getMethod("setTagScoreSet", TagScoreSet.class).getReturnType());
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
