package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class TagTest
{
    @Test
    public void toStringWithDefault()
    {
        final Tag o = new Tag();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Tag o = new Tag();
        final String name = "myTag";
        o.setName(name);
        assertEquals("name:myTag", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Tag o = new Tag();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Tag o = new Tag();
        final String name = "myTag";
        o.setName(name);
        assertEquals("name:myTag", o.toString());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Tag o = new Tag();
        final String exp =
            "<tag/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Tag o = new Tag();
        final String name = "myTag";
        o.setName(name);
        final String exp =
            "<tag>\n" +
            "  <name>myTag</name>\n" +
            "</tag>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<tag>\n" +
            "  <name>myTag</name>\n" +
            "</tag>";
        final Tag o = Tag.fromXMLString(xml);
        assertEquals("myTag", o.getName());
    }

    @Test
    public void name()
    {
        final Tag o = new Tag();
        final String name = "myTag";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void compareToWithLesserName()
    {
        final Tag o = new Tag(); o.setName("A");
        final Tag x = new Tag(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreaterName()
    {
        final Tag o = new Tag(); o.setName("B");
        final Tag x = new Tag(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

    @Test
    public void compareToWithEqualName()
    {
        final Tag o = new Tag(); o.setName("A");
        final Tag x = new Tag(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }
}
