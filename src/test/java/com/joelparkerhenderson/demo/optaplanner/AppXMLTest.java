package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppXMLTest
{
    @Test
    public void toXML()
    {
        final Maker o = new Maker();
        assertEquals("<maker/>", AppXML.toXML(o));
    }

    @Test
    public void fromXML()
    {
        final String xml = "<maker/>";
        assertEquals(Maker.class, AppXML.fromXML("<maker/>").getClass());
    }

}
