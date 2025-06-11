# EuroConnect Telecommunications Network

## Project Overview

This is a university project that implements a telecommunications network optimization system for connecting European capitals. The project uses Kruskal's algorithm to find the minimum spanning tree (MST) to determine the most cost-effective way to lay telecommunications cables between European cities.

## What it does

The EuroConnect system:
- Reads distance data between European capitals from a CSV file
- Constructs a weighted graph where cities are vertices and distances are edge weights
- Applies Kruskal's minimum spanning tree algorithm to find the optimal cable layout
- Calculates the total minimum cable length required to connect all cities
- Displays the connections that should be made and their individual distances

## Technical Implementation

### Key Components

- **Main.kt**: Entry point that handles user input and orchestrates the program flow
- **Graph.kt**: Graph data structure with methods to load data from CSV and calculate MST
- **KruskalAlgorithm.kt**: Implementation of Kruskal's algorithm using Union-Find data structure
- **input.csv**: Sample data file containing distances between European capitals

### Algorithm Details

The project implements Kruskal's algorithm with:
- **Union-Find (Disjoint Set)**: Efficiently detects cycles during MST construction
- **Path Compression**: Optimizes find operations in the Union-Find structure  
- **Union by Rank**: Balances the union operations for better performance

## How to Run

1. Compile the Kotlin files:
   ```bash
   kotlinc src/*.kt -include-runtime -d euroconnect.jar
   ```

2. Run the program:
   ```bash
   java -jar euroconnect.jar
   ```

3. When prompted, enter the path to your CSV file (e.g., `input.csv`)

## Input Format

The CSV file should contain distance data in the format:
```
City1,City2,Distance
London,Paris,344.0
Paris,Berlin,878.0
...
```

## Educational Purpose

This project demonstrates:
- Graph theory concepts and minimum spanning trees
- Kruskal's algorithm implementation
- Union-Find data structure with optimizations
- File I/O operations in Kotlin
- Object-oriented programming principles in Kotlin

## University Information

- **Institution**: University of Greenwich
- **Language**: Kotlin (JVM)
