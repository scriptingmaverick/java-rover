# Phase 2: Plateau Boundaries + Fall Detection

**New Requirements**

- Plateau is now bounded
- Rover can fall off plateau
- Once fallen:
    - Rover becomes inactive
    - Remaining instructions are ignored

**Updated Input**

```text
5 5
1 2 N
LFFRFFFF
```

- Line 1: plateau size
- Line 2: rover start
- Line 3: instructions

**Expected Output**

- A domain object containing Final position & Status: LOST