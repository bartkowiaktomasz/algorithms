# Searching

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
