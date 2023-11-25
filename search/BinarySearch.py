import math
from typing import List


class BinarySearch:
    @staticmethod
    def binary_search_leftmost(arr: List[int], elem: int):
        """
        Return leftmost index of `elem` if it exists in `nums`, otherwise return -1
        Logic:
        - `low` is guaranteed to be to the left of `elem` or be the leftmost `elem`
        - move `left` to the right (to position `mid + 1`) only if `mid` is pointing to
        an elem smaller than `elem`, thus keeping the invariant above
        - mid will be a floor of (low, high) so `high` moves towards `low`
        - if `low` == `high` then either `high` is the leftmost element or there is no
        `elem` in the array
        """
        low = 0
        high = len(arr) - 1
        while high > low:
            mid = math.floor(low + (high - low) / 2)
            if arr[mid] < elem:
                low = mid + 1
            else:
                high = mid
        if arr and arr[high] == elem:
            return high
        return -1

    @staticmethod
    def binary_search_rightmost(arr: List[int], elem: int):
        """
        Return rightmost index of `elem` if it exists in `nums`, otherwise return -1
        Logic:
        - `high` is guaranteed to be to the right of `elem` or be the rightmost `elem`
        - move `high` to the left (to position `mid - 1`) only if `mid` is pointing to
         an elem greater than `elem` thus keeping the invariant above
        - mid will be a ceil of (low, high) so `low` moves towards `high`
        - if `low` == `high` then either `low` is the rightmost element or there is no
        `elem` in the array
        """
        low = 0
        high = len(arr) - 1
        while high > low:
            mid = math.ceil(low + (high - low) / 2)
            if arr[mid] > elem:
                high = mid - 1
            else:
                low = mid
        if arr and arr[low] == elem:
            return low
        return -1

    @staticmethod
    def binary_search(arr: List[int], elem: int):
        """
        Find an index of `elem` if it exists in `nums`, otherwise return -1
        """
        low = 0
        high = len(arr) - 1
        while high >= low:
            mid = math.floor(low + (high - low) / 2)
            if arr[mid] == elem:
                return mid
            if arr[mid] > elem:
                high = mid - 1
            else:
                low = mid + 1
        return -1


if __name__ == "__main__":
    assert BinarySearch.binary_search([1, 2, 3, 4, 5], 5) == 4
    assert BinarySearch.binary_search([1, 2, 3, 4, 5], 1) == 0
    assert BinarySearch.binary_search([1, 2, 3, 4, 5], 2) == 1
    assert BinarySearch.binary_search([1], 1) == 0
    assert BinarySearch.binary_search([1], 2) == -1
    assert BinarySearch.binary_search([1, 2], 2) == 1
    assert BinarySearch.binary_search([1, 2], 3) == -1
    assert BinarySearch.binary_search([1, 2, 2], 2) in [1, 2]
    assert BinarySearch.binary_search([1, 1, 2, 3, 3, 3], 5) == -1
    assert BinarySearch.binary_search([1, 1, 2, 3, 3, 3], 5) == -1
    assert BinarySearch.binary_search_leftmost([1, 1, 2, 3, 3, 3], 5) == -1
    assert BinarySearch.binary_search_leftmost([1, 1, 2, 3, 3, 3], 1) == 0
    assert BinarySearch.binary_search_leftmost([1, 1, 2, 3, 3, 3], 2) == 2
    assert BinarySearch.binary_search_leftmost([1, 1, 2, 3, 3, 3], 3) == 3
    assert BinarySearch.binary_search_rightmost([1, 1, 2, 3, 3, 3], 5) == -1
    assert BinarySearch.binary_search_rightmost([1, 1, 2, 3, 3, 3], 1) == 1
    assert BinarySearch.binary_search_rightmost([1, 1, 2, 3, 3, 3], 2) == 2
    assert BinarySearch.binary_search_rightmost([1, 1, 2, 3, 3, 3], 3) == 5
