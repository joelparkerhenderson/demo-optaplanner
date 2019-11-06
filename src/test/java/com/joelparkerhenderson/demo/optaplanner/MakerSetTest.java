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
        makerSet.setUUID(UUID.fromString("9e55c698-4674-4d88-8199-23727ffeef53"));
        makerSet.setName("myMakerSet");
        return makerSet;
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
            "  <uuid>9e55c698-4674-4d88-8199-23727ffeef53</uuid>\n" +
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
            "  <uuid>9e55c698-4674-4d88-8199-23727ffeef53</uuid>\n" +
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
