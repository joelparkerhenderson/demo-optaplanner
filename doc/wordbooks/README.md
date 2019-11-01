# Wordbook WIP

* [Constraints](#constraints)
* [Score](#score)
* [Solution](#solution)


## Constraint

Constraint: a condition of an optimization problem that a solution must satisfy. For example "X must Y" or "X should Y".

Positive constraint: a constraint you want to maximize. For example "A person should be healthy".

Negative constraint: a constraint you want to minimize. For example "A person should not be sick".

Hard constraint: a constraint that is a must, such as a requirement, or need, or unbreakable rule. For example "X must Y", "X requires Y", "X needs Y", "X always is Y". A hard constraint can be either a "positive hard constraint" or "negative hard constraint".

Soft constraint: a constraint that is a should, such as a preference, or like, or flexible rule. For example "X should Y", "X prefers Y", "X likes Y", "X ideally is Y". A soft constraint can be either a "positive soft constraint" or "negative soft constraint".


## Score

Score: a rankable value, such as a number on a scale of -1000 (worst) to 1000 (best).

Sscore rule: an explanation of how to change a score, such as "if X then increase score by Y".


## Solution

Solution: in constraint programming, a solution is a potential total answer to a constraint problem.

Solution score: the score calculated for a given solution, using all the relevant score rules.