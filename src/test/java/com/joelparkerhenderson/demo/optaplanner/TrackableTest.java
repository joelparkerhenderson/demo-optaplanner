package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TrackableTest
{

    protected Trackable _o() {
        final Trackable trackable = new Trackable();
        return trackable;
    }

    protected Trackable _trackable() {
        final Trackable trackable = new Trackable();
        trackable.setUUID(UUID.fromString("0eb90bce-e5f7-4dab-8055-23429da62cd2"));
        trackable.setName("myTrackable");
        return trackable;
    }

    protected TagSet _tagSet() {
        final TagSet tagSet = new TagSet();
        tagSet.setName("myTagSet");
        return tagSet;
    }

    @Test
    public void toStringWithDefault()
    {
        final Trackable o = _o();
        assertEquals("uuid:null,name:null", o.toString());
    }

    @Test
    public void toStringWithTypical()
    {
        final Trackable o = _trackable();
        assertEquals("uuid:0eb90bce-e5f7-4dab-8055-23429da62cd2,name:myTrackable", o.toString());
    }

    @Test
    public void toStringDeepWithDefault()
    {
        final Trackable o = _o();
        assertEquals("uuid:null,name:null", o.toStringDeep());
    }

    @Test
    public void toStringDeepWithTypical()
    {
        final Trackable o = _trackable();
        assertEquals("uuid:0eb90bce-e5f7-4dab-8055-23429da62cd2,name:myTrackable", o.toStringDeep());
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final Trackable o = _o();
        final String exp =
            "<trackable/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final Trackable o = _trackable();
        final String exp =
            "<trackable>\n" +
            "  <uuid>0eb90bce-e5f7-4dab-8055-23429da62cd2</uuid>\n" +
            "  <name>myTrackable</name>\n" +
            "</trackable>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<trackable>\n" +
            "  <uuid>0eb90bce-e5f7-4dab-8055-23429da62cd2</uuid>\n" +
            "  <name>myTrackable</name>\n" +
            "</trackable>";
        final Trackable o = Trackable.fromXMLString(xml);
        assertEquals("myTrackable", o.getName());
    }

    @Test
    public void uuid()
    {
        final Trackable o = _o();
        final String name = "myTrackable";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void name()
    {
        final Trackable o = _o();
        final String name = "myTrackable";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tags()
    {
        final Trackable o = _o();
        final TagSet tagSet = _tagSet();
        o.setTagSet(tagSet);
        assertSame(tagSet, o.getTagSet());
    }

    @Test
    public void compareToWithEqual()
    {
        final Trackable o = _o(); o.setName("A");
        final Trackable x = _o(); x.setName("A");
        assertEquals(0, o.compareTo(x));
    }

    @Test
    public void compareToWithLesser()
    {
        final Trackable o = _o(); o.setName("A");
        final Trackable x = _o(); x.setName("B");
        assertEquals(-1, o.compareTo(x));
    }

    @Test
    public void compareToWithGreater()
    {
        final Trackable o = _o(); o.setName("B");
        final Trackable x = _o(); x.setName("A");
        assertEquals(1, o.compareTo(x));
    }

}
