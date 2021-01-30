"""
QuickSort is a recursive sorting algorithm.

Idea:
- Relies on a "partition" procedure that selects an element called "pivot", places
it in its final (sorted) position and shuffles elements in the list such that
elements smaller than pivot land to its left and elements equal or greater than pivot
land on its right
- Example partition Algorithms: Lomuto, Hoare

Complexity:
    - Time: Average-case O(nlogn) for a simple partition, Worst-case O(n^2)
    - Space: O(n) auxiliary (naive)
"""
import copy
from numbers import Number
from typing import List


class QuickSort:
    @staticmethod
    def swap(arr: List[Number], i: int, j: int):
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp

    @staticmethod
    def partition(arr: List[Number]):
        """
        Find index "j" of a partition (pivot) element. j is such that any element at
        index i < j is smaller than pivot, and any index i > j is greater or equal to
        pivot
        - Procedure changes input list by swapping elements to ensure
        pivot is in its (sorted) position
        - First element is selected as pivot
        """
        arr = copy.copy(arr)
        i = 1
        j = len(arr) - 1
        pivot = arr[0]
        while j >= i:
            if arr[i] >= pivot > arr[j]:
                QuickSort.swap(arr, i, j)
            elif arr[i] >= pivot:
                j -= 1
            elif arr[j] < pivot:
                i += 1
            else:
                j -= 1
                i += 1
        QuickSort.swap(arr, 0, j)
        return arr, j

    @staticmethod
    def sort(arr: List[Number]):
        """
        Sort array in-place using QuickSort Algorithm.
        Pseudocode:
            1. If array has no elements or one element - it is sorted
            2. Find an index of a partition element (pivot) that divides a list into
            left and  right sublists.
            "partition" procedure changes input list in-place to ensure
            pivot element is, after partition, in its (sorted) position.
            3. Sort left and right sublists recursively
            4. Combine left sublist, pivot and right sublists to output sorted array
        """
        if len(arr) == 1 or len(arr) == 0:
            return arr
        arr, idx = QuickSort.partition(arr)
        l = QuickSort.sort(arr[0:idx])
        r = QuickSort.sort(arr[idx + 1:])
        return l + [arr[idx]] + r


if __name__ == '__main__':
    sol = QuickSort()
    arr = [2, -1, -1, 3, 1, 1, 5]

    print(
        sol.sort(arr)
    )
