FIND PATH
=========
Create algorithm which is able to find path from start position to target position in any given maze based on those rules:
1. maze is rectangular 2d grid of mase elements
2. maze element is free '.' or blocked '#'
3. maze contains one start position marker 'S'
4. maze contains target position 'X'
Input into algorithm is maze data as described above. Output from algorithm is series of steps from 
position 'S' to reach position 'X' or error in case that there is no direct path between them.
Allowed steps are one position up 'u', down 'd', left 'l', right 'r'. Diagonal steps are not allowed.
Program must be able to read inputs from file as well as from standard input and each option
should be designed/implemented as extra class, e.g:
1. class FindPathInputReaderStdIn extends AbstractFindPathInputReader { ...
2. class FindPathInputReaderFile extends AbstractFindPathInputReader { ...
It is mandatory to implement at least one unittest which verifies resulting path.

How to
============
To build project use maven "mvn verify" will run tests and JMH benchmarks. 


