# Integration with XML

Integration via XML is work in progress.

Example:

```xml
<maker>
  <name>myMaker</name>
</maker>

<maker-set>
  <name>myMakerSet</name>
</maker-set>

<taker>
  <name>myTaker</name>
</taker>

<taker-set>
  <name>myTakerSet</name>
</taker-set>

<matcher>
  <name>myMatcher</name>
  <maker>
    <name>myMaker</name>
  </maker>
  <taker>
    <name>myTaker</name>
  </taker>
</matcher>

<solution>
  <name>mySolution</name>
  <score>
    <initScore>0</initScore>
    <hardScore>0</hardScore>
    <softScore>0</softScore>
  </score>
  <makers>
    <maker>
      <name>myMaker</name>
    </maker>
  </makers>
  <takers>
    <taker>
      <name>myTaker</name>
    </taker>
  </takers>
</solution>
```

