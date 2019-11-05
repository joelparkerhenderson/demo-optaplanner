# Integration with XML, JSON, etc.


## XML

Integration via XML is work in progress.

Example:

```xml
<maker>
  <name>myMaker</name>
</maker>

<makerSet>
  <name>myMakerSet</name>
</makerSet>

<taker>
  <name>myTaker</name>
</taker>

<takerSet>
  <name>myTakerSet</name>
</takerSet>

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
</solution>
```


## JSON

Integration via JSON is TODO.

Example:

```json
"maker": {
  "name": "myMaker"
}

"makerSet": {
  "name": "myMakerSet"
}

"taker": {
  "name": "myTaker"
}

"takerSet": {
  "name": "myTakerSet"
}

"matcher": {
  "name": "myMatcher",
  "maker": {
    "name": "myMaker"
  },
  "taker": {
    "name": "myTaker"
  }
}

"solution": {
  "name": "mySolution",
  "score": {
    "initScore": 0,
    "hardScore": 0,
    "softScore": 0
  }
}
```
