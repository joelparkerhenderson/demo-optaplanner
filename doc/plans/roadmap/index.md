# Roadmap

* [For scale](#for-scale)
* [For represenation](#for-represenation)
* [For scores](#for-scores)
* [For integration](#for-integration)



## For scale

Currently this demo runs these objects:

  * 10 makers
  * 10 takers
  * 1 soft constraint 
  * 1 hard constraint (coming soon)

2020-Q1: Scale ~2x.

2020-Q2: Scale ~5x.

2020-Q3: Scale ~10x.

2020-Q4: Scale ~20x.


## For represenation

Currently the representation is trivial, such as names that are 0, 1, 2, etc. String names are coming soon.

2020-Q1: Add names and more fields that can all be meaningful, such as strings that a user can understand.

2020-Q2: Add secure random identifiers, suitable for distributed computing and confidential anonymization.


## For scores

Currently scores are based on name equality.

2020-Q1: Add tag set intersection using simple strings and single-value soft contraints.

2020-Q2: Add tag set weights including any-value soft contraints and any-value hard constraints.

2020-Q3: Import/export tags, weights, contstraints, etc. in XML and JSON.


## For integration

2020-Q1: Read/write XML files for solutions.

2020-Q2: Read/write JSON files for solutions.
  
2020-Q3: Read/write RESTful API for solutions.

2020-Q4: Read/write GraphQL API for solutions.
