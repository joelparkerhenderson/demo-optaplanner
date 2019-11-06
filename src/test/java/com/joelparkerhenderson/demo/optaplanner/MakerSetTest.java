package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class MakerSetTest
{

    protected MakerSet _o() {
        final MakerSet makerSet = new MakerSet();
        return makerSet;
    }

    protected MakerSet _makerSet() {
        final MakerSet makerSet = new MakerSet();
        makerSet.setName("myMakerSet");
        return makerSet;
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
    public void toXMLStringWithDefault()
    {
        final MakerSet o = _o();
        final String exp =
            "<maker-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final MakerSet o = _makerSet();
        final String exp =
            "<maker-set>\n" +
            "  <name>myMakerSet</name>\n" +
            "</maker-set>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<maker-set>\n" +
            "  <name>myMakerSet</name>\n" +
            "</maker-set>";
        final MakerSet o = MakerSet.fromXMLString(xml);
        assertEquals("myMakerSet", o.getName());
    }

    @Test
    public void elements()
    {
        final MakerSet o = _o();
        final Set<Maker> elements = new HashSet<Maker>();
        o.setElements(elements);
        assertSame(elements, o.getElements());
    }

}
