class UnionFind:
    def __init__(self, n: int) -> None:
        """Create union-find (disjoint set) structure
        for n consecutive elements: 0, ..., n-1

        Args:
            n (int): _description_
        """
        self.parent = {i: i for i in range(n)}
        self.rank = {i: 0 for i in range(n)}

    def find(self, i: int) -> int:
        """Find the representative element for element "i".
        Do two passes to perform the path compression

        Alternative: one pass with recursive update:
        while x != self.parent[x]:
            self.parent[x] = self.find(x.parent)
            return self.parent[x]

        Args:
            i (int): Element to find

        Returns:
            int: Representative element
        """
        if i == self.parent[i]:
            return i

        root = i
        while root != self.parent[root]:
            root = self.parent[root]

        # Path compression
        while i != root:
            i, self.parent[i] = self.parent[i], root

        return root

    def union(self, i: int, j: int):
        """
        Union by rank
        - rank is an upper bound for its height

        While the rank of a node is clearly related to its height,
        storing ranks is more efficient than storing heights. The
        height of a node can change during a Find operation,
        so storing ranks avoids the extra effort of keeping the 
        height correct

        Args:
            i (int): Element to union
            j (int): Element to union
        """
        i = self.find(i)
        j = self.find(j)

        if i == j:
            return

        if self.rank[i] == self.rank[j]:
            self.rank[i] += 1

        if self.rank[i] < self.rank[j]:
            # Swap ranks so that i has higher rank
            i, j = j, i

        # i has higer rank because of swap
        self.parent[j] = i

uf = UnionFind(5)
assert uf.find(1) == 1
uf.union(1, 2)
assert uf.find(1) == uf.find(2)
uf.union(3, 4)
uf.union(1, 3)
assert uf.find(1) == uf.find(4)