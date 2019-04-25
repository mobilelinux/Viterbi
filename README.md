Viterbi
========

An implementation of HMM-Viterbi Algorithm
----------------------
It's a modified version of [hackcs's][1]. For performance, reverse path matrix to get max prob path.

 - How to Use
 
```java

 int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);

```
 - About the algorithm
 
 See [Wiki][2]

  [1]: https://github.com/hankcs/Viterbi
  [2]: https://en.wikipedia.org/wiki/Viterbi_algorithm#Example
