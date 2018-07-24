# PathFinding Visualization

A Visualization Desktop Software, written in Java, that visualizes the path finding
algorithm A*.

## Current Issues/Bugs

The AStar algorithm (my implementation at least) is having null pointer issues.
After moving to the next Node - Node(row=1, column=0, w=1), it finds the Node's neighbours, but for some reason stores
null as the total score - total score being = cost from start to current + heuristic (estimated cost from current to end) Planning to figure out the issue soon

**WORK IN PROGRESS**