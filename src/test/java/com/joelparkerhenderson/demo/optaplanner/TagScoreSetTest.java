package com.joelparkerhenderson.demo.optaplanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TagScoreSetTest
{

    protected TagScoreSet _o() {
        final TagScoreSet tagScoreSet = new TagScoreSet();
        return tagScoreSet;
    }

    protected TagScoreSet _tagScoreSet() {
        final TagScoreSet tagScoreSet = new TagScoreSet();
        tagScoreSet.setName("myTagScoreSet");
        return tagScoreSet;
    }

    protected TagScore _tagScore() {
        final TagScore tagScore = new TagScore();
        tagScore.setName("myTagScore");
        return tagScore;
    }

    protected Tag _tag() {
        final Tag tag = new Tag();
        tag.setName("myTag");
        return tag;
    }

    protected HardSoftScore _score() {
        final HardSoftScore score = HardSoftScore.of(123,456);
        return score;
    }

    @Test
    public void toXMLStringWithDefault()
    {
        final TagScoreSet o = _o();
        final String exp =
            "<tag-score-set/>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void toXMLStringWithTypical()
    {
        final TagScoreSet o = _tagScoreSet();
        final Tag tag = _tag();
        final TagScore tagScore = _tagScore();
        final HardSoftScore score = _score();
        tagScore.setScore(score);
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        tagScores.add(tagScore);
        o.setTagScores(tagScores);
        final String exp =
            "<tag-score-set>\n" +
            "  <name>myTagScoreSet</name>\n" +
            "  <tagScores>\n" +
            "    <tag-score>\n" +
            "      <name>myTagScore</name>\n" +
            "      <score>\n" +
            "        <initScore>0</initScore>\n" +
            "        <hardScore>123</hardScore>\n" +
            "        <softScore>456</softScore>\n" +
            "      </score>\n" +
            "    </tag-score>\n" +
            "  </tagScores>\n" +
            "</tag-score-set>";
        final String act = o.toXMLString();
        assertEquals(exp, act);
    }

    @Test
    public void fromXMLString()
    {
        final String xml =
            "<tag-score-set>\n" +
            "  <name>myTagScoreSet</name>\n" +
            "</tag-score-set>";
        final TagScoreSet o = TagScoreSet.fromXMLString(xml);
        assertEquals("myTagScoreSet", o.getName());
    }

    @Test
    public void name()
    {
        final TagScoreSet o = _o();
        final String name = "myTagScoreSet";
        o.setName(name);
        assertSame(name, o.getName());
    }

    @Test
    public void tagScores()
    {
        final TagScoreSet o = _o();
        final Set<TagScore> tagScores = new HashSet<TagScore>();
        o.setTagScores(tagScores);
        assertSame(tagScores, o.getTagScores());
    }
}
