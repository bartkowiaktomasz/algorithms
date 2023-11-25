# Searching

## Binary Search
Search algorithm for finding an index of `elem` in a (sorted) input array `arr`.

### Idea
The idea is to use divide and conquer and, at each iteration, divide the input list in
half and then search for `elem` in either left or right sublist.

#### Duplicate elements
Variations of binary search include `binary_search_leftmost` and `binary_search_rightmost`
which return an index of leftmost (rightmost) `elem` if the input array contains duplicates.

In such case it is important to carefully move pointers `low`/`high`. See docstring for
the implementation of `binary_search_leftmost`:

>- **invariant:** `low` is guaranteed to be to the left of `elem` or be the leftmost `elem`
>- move `left` to the right (position `mid + 1`) only if `mid` is pointing to an element
smaller than `elem`, thus keeping the invariant above
> - `mid` will be a floor of (low, high) so `high` moves towards `low`
>- if `low` == `high` then either `high` is the leftmost element or there is no
`elem` in the array

Note: `(low + high ) / 2` can cause overflow. Use `low + (high - low) / 2` instead.

## Knuth-Morris-Pratt
Knuth Morris Pratt is a linear-time algorithm for string matching.
> Given string `s` and pattern `p` find the starting index `m` in `s` that matches `p`

### Idea:
Given string `s` and pattern `p`:
```
s = "xxxabababd"
p =    "ababd"
```
When scanning through `s` we come across a mismatch with the pattern (`a` != `d`).
The pattern, however, contains repeated "ab" which means that if we are at element `d` in the
pattern, we must have scanned through "abab" in `s`. This means that we should backtrack
with our pointer `j` (that scans through the pattern) to the second `a` (at index 2) in the
pattern instead of backtracking to the beginning of the pattern. Pointer `i` that scans
through `s` doesn't move.

### Properties:
- Scanning through the string `s` is linear, there is no backtracking. Backtracking
occurs only when scanning the pattern `p`
- KMP Requires preprocessing the pattern, i.e. building an `lps` table (Longest Proper
Prefix which is also a Suffix). Proper prefix is prefix with whole string not allowed.
- `lps` tells us the count of characters to be skipped



## QuickSelect
QuickSelect is a linear time (average-case) algorithm for finding `k`th smallest element
(or a list of `k` smallest elements) in a list.

### Idea
The idea is to use QuickSort partitioning algorithm (e.g. Lomuto, Hoare) to find a pivot
(element which gets inserted at its sorted position) and shift all elements being
smaller than the pivot - to its left, and all elements being equal or greater to it - 
to its right. We iteratively want to find a pivot which belongs to index `k`. Then its
sufficient to return either `arr[k]` (if we want to find `k`th smallest) or `arr[0:k]`
(find `k` smallest elements). In order to find such a pivot we use divide-and-conquer,
where we iteratively find pivots thus splitting input list into two sublists. In each
iteration we decide whether to search in the right or left subarray depending on the 
value of `k`.


## Union-Find
Union-Find (Disjoint Data Set) is a data structure that allows to efficiently:
- find if two elements belong to the same set
- merge two sets
in time $O(M\alpha(N))$ where $\alpha(N)$ is the inverse Ackermann function (almost constant), `N` 
is the number of elements in the data structure and `M` is the number of operations.

Union-Find uses two techniques to achieve such efficiency:
- Use of **union by rank** which ensures that the tree is always balanced (rank is an upper bound for its height)
> While the rank of a node is clearly related to its height,
storing ranks is more efficient than storing heights. The
height of a node can change during a Find operation,
so storing ranks avoids the extra effort of keeping the 
height correct
- Use of **path compression** which ensures that the tree is always flat
> When running a `find` operation, change the data structure in place by making each node
point directly to the root