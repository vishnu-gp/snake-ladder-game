# Snake and Ladder Game

A classic multi-player Snake and Ladder game written in Java.

## Installation

1. Clone the repository.
2. Update Main class with board size and define snakes and ladders in the board.
3. Run main() to start a new game or load already saved game.

## Usage

```java
// Initialize board with custom snakes and ladders
Map<Integer, Integer> snakes = Map.of(16, 6, 47, 26, 49, 11, 56, 53, 62, 19, 64, 60, 87, 24, 93, 73, 95, 75, 98, 78);
Map<Integer, Integer> ladders = Map.of(1, 38, 4, 14, 9, 31, 21, 42, 28, 84, 36, 44, 51, 67, 71, 91, 80, 100);
Board board = new Board(100, snakes, ladders);
```

## Unit Tests

Use the following command to run the unit tests.
```java
mvn test
```