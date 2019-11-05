package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TagSetTest
{

    protected TagSet _o() {
        final TagSet tagSet = new TagSet();
        return tagSet;
    }

    protected TagSet _tagSet() {
        final TagSet tagSet = new TagSet();
        tagSet.setName("myTagSet");
        return tagSet;
    }

    protected Tag _tag() {
        final Tag tag = new Tag();
        tag.setName("myTag");
        return tag;
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final TagSet o = _o();
        final String exp =
            "<tag-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TagSet o = _tagSet();
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
        final TagSet o = _o();
        final String name = "myTagSet";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tags()
    {
        final TagSet o = _o();
        final Tag tag = _tag();
        final Set<Tag> tags = new HashSet<Tag>();
        o.setTags(tags);
        assertSame(tags, o.getTags());
    }
}
