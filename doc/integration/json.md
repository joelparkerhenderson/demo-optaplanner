# Integration with JSON

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
  },
  "makers": {
    "maker": {
      "name": "myMaker"
    }
  },
  "takers": {
    "taker": {
      "name": "myTaker"
    }
  }
}
```
