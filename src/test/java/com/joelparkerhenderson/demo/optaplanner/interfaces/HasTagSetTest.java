package com.joelparkerhenderson.demo.optaplanner.interfaces;

import com.joelparkerhenderson.demo.optaplanner.*;
import com.joelparkerhenderson.demo.optaplanner.tag.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class HasTagSetTest
{
    private Class<HasTagSet> klass;

    public HasTagSetTest(Class<HasTagSet> klass) {
        this.klass = klass;
    }

    @Test
    public final void hasMethods() {
        try {
            assertSame(TagSet.class, klass.getMethod("getTagSet").getReturnType());
            assertSame(Void.TYPE, klass.getMethod("setTagSet", TagSet.class).getReturnType());
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
