package org.nonprofitnetworks.homer;

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
}
