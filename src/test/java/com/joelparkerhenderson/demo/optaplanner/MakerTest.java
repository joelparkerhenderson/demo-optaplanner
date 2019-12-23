package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class MakerTest
{

    protected Maker _o() {
        final Maker maker = new Maker();
        return maker;
    }

    protected Maker _maker() {
        final Maker maker = new Maker();
        maker.setUUID(UUID.fromString("6a03f2f6-527a-4b35-bc7b-bf291a08a35f"));
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
        assertEquals("uuid:null,name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Maker o = _maker();
        assertEquals("uuid:6a03f2f6-527a-4b35-bc7b-bf291a08a35f,name:myMaker", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Maker o = _o();
        assertEquals("uuid:null,name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Maker o = _maker();
        assertEquals("uuid:6a03f2f6-527a-4b35-bc7b-bf291a08a35f,name:myMaker", o.toStringDeep());
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
            "  <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>\n" +
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
            "  <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>\n" +
            "  <name>myMaker</name>\n" +
            "</maker>";
        final Maker o = Maker.fromXMLString(xml);
        assertEquals("myMaker", o.getName());
    }

}
