# Introduction

For a group project, we are implementing Battleship in Java. There are many pieces that need to made and put together. This is one of those.

I had initially made an algorithm that scanned the fleet configuration (represented by a 2D array), verifying ships. However, that algorithm was needlessly complicated because I found out that I can use simpler checks after flattening the 2D array to 1D.

The rest of this readme are notes straight from the code file.

# Explanation

There's no need to use such a complicated algorithm that I made up!
We should instead use this much simpler algorithm (that I also made up)!

Take any 2D fleet configuration, and then flatten it to 1D.
Battleships can only have two orientations: vertical or horizontal.

In this new 1D format:
Horizontal ships's letters will be bunched together with no spaces in between them.
Vertical ships's letters will be spaced EXACTLY THE WIDTH OF THE GAME BOARD (in this case, 10 spaces).

These principles hold for any number of ships, however long they are, and any size game board!

# Example:
00000000000C0PP000000C000000000C00BBBB000C000B00000C000000000000D0S0000000D0S0000000D0S0000000000000
This is a valid fleet configuration. Why?

Either:
Each letter has exactly 10 spaces in between them OR
Each letter is grouped together.

# Pseudocode
Flatten 2D array to 1D array.

Check there are 17 non-zeros. If not, return false. (A brief, but necessary pre-validation)
Cycle through each element.

When a letter is hit, check the next element to see if it matches.
If it matches, it's horizontal. If not, it's vertical.

If horizontal, check that there are that many sequential letters.
If vertical, check if there are that many sequential letters with 10 space in between them.

This actually inherently takes care of placing boats in an L-shape.
The reason is because when a boat is discovered (its letter is found),
The algorithm is expecting to find 5, 4, 3, or 2 spaces.
And because of the 17 count check before the algorithm starts,
the ships MUST be in this configuration.