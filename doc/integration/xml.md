# Integration with XML

Integration via XML is work in progress.

Example:

```xml
<maker>
  <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>
  <name>myMaker</name>
</maker>

<maker-set>
  <uuid>9e55c698-4674-4d88-8199-23727ffeef53</uuid>
  <name>myMakerSet</name>
</maker-set>

<taker>
  <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>
  <name>myTaker</name>
</taker>

<taker-set>
  <uuid>da953f4c-dd22-4d3c-a7c7-f50e90e41647</uuid>
  <name>myTakerSet</name>
</taker-set>

<matcher>
  <uuid>85a61bb4-996f-4498-a447-aabfe1069a65</uuid>
  <name>myMatcher</name>
  <maker>
    <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>
    <name>myMaker</name>
  </maker>
  <taker>
    <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>
    <name>myTaker</name>
  </taker>
</matcher>

<tag>
  <uuid>5270c2ae-ec1f-4fc4-a97e-fc78dc148461</uuid>
  <name>myTag</name>
</tag>

<tag-set>
  <uuid>d0d8c675-b825-4c30-bb3d-649762f82a59</uuid>
  <name>myTagSet</name>
</tag-set>

<solution>
  <uuid>e270cf62-c704-4806-8d7a-69d3bc7d06d4</uuid>
  <name>mySolution</name>
  <score>
    <initScore>0</initScore>
    <hardScore>0</hardScore>
    <softScore>0</softScore>
  </score>
  <makers>
    <maker>
      <uuid>6a03f2f6-527a-4b35-bc7b-bf291a08a35f</uuid>
      <name>myMaker</name>
    </maker>
  </makers>
  <takers>
    <taker>
      <uuid>7f6f5003-1c43-4607-9fb4-890a02f2bc2a</uuid>
      <name>myTaker</name>
    </taker>
  </takers>
</solution>
```

