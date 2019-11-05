package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TagSetTest
{
    @Test
    public void toXMLStringWithDefault()
    {
        final TagSet o = new TagSet();
        final String exp =
            "<tag-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TagSet o = new TagSet();
        final String name = "myTagSet";
        o.setName(name);
        final String exp =
            "<tag-set>\n" +
            "  <name>myTagSet</name>\n" +
            "</tag-set>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<tag-set>\n" +
            "  <name>myTagSet</name>\n" +
            "</tag-set>";
        final TagSet o = TagSet.fromXMLString(xml);
        assertEquals("myTagSet", o.getName());
    }

    @Test
    public void name()
    {
        final TagSet o = new TagSet();
        final String name = "myTagSet";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tags()
    {
        final TagSet o = new TagSet();
        final Tag tag = new Tag();
        final Set<Tag> tags = new HashSet<Tag>();
        o.setTags(tags);
        assertSame(tags, o.getTags());
    }
}
