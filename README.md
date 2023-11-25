# Algorithms
Implementations of various Algorithms in Java/Python

**Note:** For best experience consider installing [MathJax Plugin for Github](https://chrome.google.com/webstore/detail/mathjax-plugin-for-github/ioemnmodlmafdkllaclgeombjnmnbima?hl=en) 
which allows for rendering MathJax in the browser

## Searching
[About Searching Algorithms](search/README.md)

| Algorithm | Class | Worst-case time | Avg-case time | Space | Notation | Assumptions/Use-case |  
| -- | -- | -- |  -- | -- | -- |  -- |
| Binary Search | Search | $O(logn)$ | $O(logn)$ | $O(1)$ | (see above) | Find an index of `elem` in a sorted array `arr`
| Knuth-Morris-Pratt | String/Pattern search | $O(mn)$ | $O(mn)$ | $O(m + n)$ | `s` - length of string, `m` - length of pattern | Pattern `p` has repeated substrings
| QuickSelect | Selection | $O(n^2)$ | $O(n)$ | $O(1)$ | `n` - number of elements in a list | Find `k`th smallest element/Find `k` smallest elements
| Union-Find | Search | $O(m\alpha(n))$ | $O(m\alpha(n))$ | $O(N)$ | `n` - number of elements, `m` - number of union/find operations | Find if two elements belong to the same set/Merge two sets
