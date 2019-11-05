package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.*;

public class MakerTest
{

    protected Maker _o() {
        final Maker maker = new Maker();
        return maker;
    }

    protected Maker _maker() {
        final Maker maker = new Maker();
        maker.setName("myMaker");
        return maker;
    }

    protected TagSet _tagSet() {
        final TagSet tagSet = new TagSet();
        tagSet.setName("myTagSet");
        return tagSet;
    }

    @Test
    public void toStringWithDefault()
    {
        final Maker o = _o();
        assertEquals("name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Maker o = _maker();
        assertEquals("name:myMaker", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Maker o = _o();
        assertEquals("name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Maker o = _maker();
        assertEquals("name:myMaker", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Maker o = _o();
        final String exp =
            "<maker/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Maker o = _maker();
        final String exp =
            "<maker>\n" +
            "  <name>myMaker</name>\n" +
            "</maker>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<maker>\n" +
            "  <name>myMaker</name>\n" +
            "</maker>";
        final Maker o = Maker.fromXMLString(xml);
        assertEquals("myMaker", o.getName());
    }

    @Test
    public void name()
    {
        final Maker o = _o();
        final String name = "myMaker";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tags()
    {
        final Maker o = _o();
        final TagSet tagSet = _tagSet();
        o.setTagSet(tagSet);
        assertSame(tagSet, o.getTagSet());
    }

    @Test
    public void compareToWithEqual()
    {
        final Maker o = _o(); o.setName("A");
        final Maker x = _o(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Maker o = _o(); o.setName("A");
        final Maker x = _o(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Maker o = _o(); o.setName("B");
        final Maker x = _o(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
