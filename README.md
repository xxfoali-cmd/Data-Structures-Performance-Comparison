Data Structures Project
A Java project that implements and compares two data structures—an **AVL Tree** and a **Doubly Linked List**—for storing words and tracking their frequencies.

The project supports inserting, searching, removing, and traversing words while also measuring the performance of these operations on datasets of different sizes.

## Features

- AVL Tree implementation with automatic balancing
- Doubly Linked List implementation
- Case-insensitive word storage
- Word frequency counting
- Insert operations
- Search operations
- Remove operations
- Traversal and display of stored words
- Performance testing using `System.nanoTime()`
- Comparison of AVL Tree and Doubly Linked List execution times

## Data Structures

### AVL Tree

The `SPAVL` class implements a self-balancing binary search tree.

Each node stores:

- A word/token
- Its frequency
- Node height
- Left child
- Right child

The tree automatically performs rotations when necessary to maintain AVL balance.

Supported operations include:

- Insert
- Search
- Remove
- In-order traversal

Because the AVL Tree remains balanced, searching, insertion, and deletion generally have a time complexity of:

```text
O(log n)
```

### Doubly Linked List

The `SPDLIST` class implements a doubly linked list.

Each node stores:

- A word/token
- Its frequency
- A reference to the previous node
- A reference to the next node

If a word already exists in the list, its frequency is increased instead of creating another node.

Searching for an item may require traversing the entire list, resulting in a worst-case complexity of:

```text
O(n)
```

## Project Structure

```text
210ProjectAl/
│
├── pom.xml
│
└── src/
    └── main/
        └── java/
            ├── AIPulse/
            │   ├── AVLNode.java
            │   ├── Node.java
            │   ├── PerformanceTest.java
            │   ├── Solution.java
            │   ├── SPAVL.java
            │   └── SPDLIST.java
            │
            └── com/mycompany/projectal/
                └── App.java
```

## Main Classes

### `SPAVL.java`

Implements the AVL Tree, including:

- Left and right rotations
- Balance-factor calculation
- Word insertion
- Word search
- Word removal
- In-order traversal

### `SPDLIST.java`

Implements the Doubly Linked List, including:

- Word insertion
- Frequency updates
- Search
- Removal
- Sequential traversal

### `AVLNode.java`

Represents a node inside the AVL Tree.

### `Node.java`

Represents a node inside the Doubly Linked List.

### `PerformanceTest.java`

Tests the execution time of operations performed by both data structures.

The program measures:

```text
AVL Insert
AVL Search
AVL Remove

Doubly Linked List Insert
Doubly Linked List Search
Doubly Linked List Remove
```

Execution times are measured using:

```java
System.nanoTime()
```

and displayed in milliseconds.

## Command Format

The `Solution` class also supports commands entered through standard input.

### 1 — Insert into AVL Tree

```text
1 word1 word2 word3
```

Example:

```text
1 apple banana apple orange
```

This inserts the words into the AVL Tree.

`apple` will have a frequency of `2`.

### 2 — Insert into Doubly Linked List

```text
2 word1 word2 word3
```

Example:

```text
2 apple banana apple orange
```

### 3 — Search

```text
3 word
```

Example:

```text
3 apple
```

The program returns the frequency of the word.

If the word does not exist, it returns:

```text
-1
```

The search is performed on the data structure selected by the most recent insert command.

### 4 — Remove

```text
4 word
```

Example:

```text
4 apple
```

Removes the word from the currently selected data structure.

### 5 — Traverse

```text
5
```

Displays the words and their frequencies.

For the AVL Tree, the output is produced using an in-order traversal, so the words are displayed alphabetically.

Example:

```text
apple 2
banana 1
orange 1
```

## Performance Testing

`PerformanceTest.java` loads words from a text file and measures how long each data structure takes to perform common operations.

Example output:

```text
========== File: small.txt ==========
AVL Insert time (ms): ...
AVL Search time (ms): ...
AVL Remove time (ms): ...

DList Insert time (ms): ...
DList Search time (ms): ...
DList Remove time (ms): ...
```

This makes it possible to observe how the performance difference changes as the dataset becomes larger.

## Requirements

- Java 23
- Maven

The Maven configuration currently uses:

```xml
<maven.compiler.release>23</maven.compiler.release>
```

## Running the Project

Clone the repository:

```bash
git clone <your-repository-url>
cd 210ProjectAl
```

Compile the project:

```bash
mvn compile
```

The main project logic is located in:

```text
src/main/java/AIPulse/Solution.java
```

You can run `Solution` from your IDE or configure Maven to use:

```text
AIPulse.Solution
```

as the main class.

## Important Setup Note

The current `Solution.java` contains hard-coded Windows file paths for performance-test datasets:

```java
PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/small.txt");
PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/medium.txt");
PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/large.txt");
PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/xlarge.txt");
PerformanceTest.runTests("C:/Users/xxfoa/OneDrive/Desktop/massive.txt");
```

These paths should be changed to match the location of the test files on your computer.

For a repository intended to work on multiple computers, a better approach is to place the datasets inside the project, for example:

```text
data/
├── small.txt
├── medium.txt
├── large.txt
├── xlarge.txt
└── massive.txt
```

and reference them using relative paths.

## Performance Comparison

The purpose of the project is to demonstrate how choosing an appropriate data structure affects program performance.

An AVL Tree maintains its elements in sorted and balanced form, allowing efficient searching.

A Doubly Linked List must generally inspect nodes sequentially when searching for a word.

As the number of words increases, this difference becomes more noticeable and demonstrates why balanced search trees can be more suitable for large searchable datasets.

## Technologies

- Java
- Maven
- AVL Trees
- Doubly Linked Lists
- Object-Oriented Programming
- Algorithm Performance Analysis

## Course

Developed as a **CS210 Data Structures** project to practice implementing data structures and analyzing their performance.
