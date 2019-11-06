# Integration with JSON

Integration via JSON is TODO.

Example:

```json
"maker": {
  "uuid": "6a03f2f6-527a-4b35-bc7b-bf291a08a35f",
  "name": "myMaker"
}

"makerSet": {
  "uuid": "9e55c698-4674-4d88-8199-23727ffeef53",
  "name": "myMakerSet"
}

"taker": {
  "uuid": "7f6f5003-1c43-4607-9fb4-890a02f2bc2a",
  "name": "myTaker"
}

"takerSet": {
  "uuid": "da953f4c-dd22-4d3c-a7c7-f50e90e41647",
  "name": "myTakerSet"
}

"matcher": {
  "uuid": "85a61bb4-996f-4498-a447-aabfe1069a65",
  "name": "myMatcher",
  "maker": {
    "uuid": "6a03f2f6-527a-4b35-bc7b-bf291a08a35f",
    "name": "myMaker"
  },
  "taker": {
    "uuid": "7f6f5003-1c43-4607-9fb4-890a02f2bc2a",
    "name": "myTaker"
  }
}

"scorer": {
  "uuid": "562fe584-0b95-4906-9f24-24cb72c39ed9",
  "name": "myScorer"
}

"tag": {
  "uuid": "5270c2ae-ec1f-4fc4-a97e-fc78dc148461",
  "name": "myTag"
}

"tagSet": {
  "uuid": "d0d8c675-b825-4c30-bb3d-649762f82a59",
  "name": "myTagSet"
}

"solution": {
  "uuid": "e270cf62-c704-4806-8d7a-69d3bc7d06d4",
  "name": "mySolution",
  "score": {
    "initScore": 0,
    "hardScore": 0,
    "softScore": 0
  },
  "makers": {
    "maker": {
      "uuid": "6a03f2f6-527a-4b35-bc7b-bf291a08a35f",
      "name": "myMaker"
    }
  },
  "takers": {
    "taker": {
      "uuid": "7f6f5003-1c43-4607-9fb4-890a02f2bc2a",
      "name": "myTaker"
    }
  }
}
```
