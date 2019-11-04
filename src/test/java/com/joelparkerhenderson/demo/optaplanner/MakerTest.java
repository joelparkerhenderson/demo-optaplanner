package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MakerTest
{
    @Test
    public void toStringWithDefault()
    {
        final Maker o = new Maker();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Maker o = new Maker();
        assertEquals("name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        assertEquals("name:foo", o.toStringDeep());
    }

    @Test
    public void toXML()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        final String exp =
            "<maker>\n" +
            "  <name>foo</name>\n" +
            "</maker>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }
    
    @Test
    public void name()
    {
        final Maker o = new Maker();
        final String name = "foo";
        o.setName(name);
        assertEquals(name, o.getName());
    }

    @Test
    public void compareToWithEqual()
    {
        final Maker o = new Maker(); o.setName("A");
        final Maker x = new Maker(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Maker o = new Maker(); o.setName("A");
        final Maker x = new Maker(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Maker o = new Maker(); o.setName("B");
        final Maker x = new Maker(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
