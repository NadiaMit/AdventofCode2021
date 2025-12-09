![](https://img.shields.io/badge/stars%20⭐-20-yellow)
![](https://img.shields.io/badge/days%20completed%20📅-10-blue)

# Advent of Code 2021 in Java [![Java](https://skillicons.dev/icons?i=java)](https://skillicons.dev)

This is my try on the Advent of code of 2021 challanges with Java!

## My Progress 20/50⭐

- Day 1 - [Sonar Sweep](https://adventofcode.com/2021/day/1): ⭐⭐
- Day 2 - [Dive!](https://adventofcode.com/2021/day/2): ⭐⭐
- Day 3 - [Binary Diagnostic](https://adventofcode.com/2021/day/3): ⭐⭐
- Day 4 - [Giant Squid](https://adventofcode.com/2021/day/4): ⭐⭐
- Day 5 - [Hydrothermal Venture](https://adventofcode.com/2021/day/5): ⭐⭐
- Day 6 - [Lanternfish](https://adventofcode.com/2021/day/6): ⭐⭐
- Day 7 - [The Treachery of Whales](https://adventofcode.com/2021/day/7): ⭐⭐
- Day 8 - [Seven Segment Search](https://adventofcode.com/2021/day/8): ⭐⭐
- Day 9 - [Smoke Basin](https://adventofcode.com/2021/day/9): ⭐⭐
- Day 10 - [Syntax Scoring](https://adventofcode.com/2021/day/10): ⭐⭐
- ...

## Structure
- `Main.java`: in this file you can find the main, that calls the days code. to call the right code, you need to add the right number here:
```java
  Days day = new DayX(reader.readInput("test.txt"));//exchange X for the number of the day
```
- `days`: the code for each day will be in the days folder as a `.java` file. I used `Days.java` to create an Interface, that I then could implement every day to be faster in writing the code for every day.
- `Inputs`: all my input data for each day is saved the inputs folder as a `.txt` file. I also have a `test.txt` file, that I use for the example input of each days puzzle.
- `Reader.java`: This class helps to read the input data.
