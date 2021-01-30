import copy

from Sorting.QuickSort import QuickSort


class QuickSelect:

    @staticmethod
    def find_k_smallest(arr, k):
        arr = copy.copy(arr)
        if len(arr) == k:
            return arr
        low = 0
        high = len(arr) - 1
        idx = 0
        while idx != k:
            subarr, idx = QuickSort.partition(arr[low: high + 1])
            # We partition sliced array arr[low: high + 1] so pivot at idx `i` has index
            #  `i + low` in the original array `arr`
            idx = idx + low
            arr[low: high + 1] = subarr
            if k > idx:
                low = idx + 1
            else:  # k < idx
                high = idx - 1
        return arr[0:idx]


if __name__ == "__main__":
    arr = [5, 1, 2, 2, 3, 4, 5]
    arr2 = [1, 1, 1]
    k = 1
    assert sorted(QuickSelect.find_k_smallest(arr, 1)) == [1]
    assert sorted(QuickSelect.find_k_smallest(arr, 2)) == [1, 2]
    assert sorted(QuickSelect.find_k_smallest(arr, 3)) == [1, 2, 2]
    assert sorted(QuickSelect.find_k_smallest(arr, 4)) == [1, 2, 2, 3]
    assert sorted(QuickSelect.find_k_smallest(arr, 5)) == [1, 2, 2, 3, 4]
    assert sorted(QuickSelect.find_k_smallest(arr, 6)) == [1, 2, 2, 3, 4, 5]
    assert sorted(QuickSelect.find_k_smallest(arr, 7)) == [1, 2, 2, 3, 4, 5, 5]
    assert sorted(QuickSelect.find_k_smallest(arr2, 1)) == [1]
    assert sorted(QuickSelect.find_k_smallest(arr2, 2)) == [1, 1]
    assert sorted(QuickSelect.find_k_smallest(arr2, 3)) == [1, 1, 1]
