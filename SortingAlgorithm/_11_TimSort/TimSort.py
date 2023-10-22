MIN_MERGE = 32


def calc_min_run(n):
    """Calculate the minimum length of a run for Timsort.

    Args:
        n (int): The length of the array.

    Returns:
        int: The minimum run length.
    """
    r = 0
    while n >= MIN_MERGE:
        r |= n & 1
        n >>= 1
    return n + r


def insertion_sort(arr, left, right):
    """Sort a subarray using Insertion Sort.

    Args:
        arr (List[int]): The input array.
        left (int): The left index of the subarray.
        right (int): The right index of the subarray.
    """
    for i in range(left + 1, right + 1):
        j = i
        while j > left and arr[j] < arr[j - 1]:
            arr[j], arr[j - 1] = arr[j - 1], arr[j]
            j -= 1


def merge(arr, l, m, r):
    """Merge two sorted subarrays into a single sorted subarray.

    Args:
        arr (List[int]): The input array.
        l (int): The left index of the left subarray.
        m (int): The right index of the left subarray.
        r (int): The right index of the right subarray.
    """
    len1, len2 = m - l + 1, r - m
    left = arr[l:m + 1]
    right = arr[m + 1:r + 1]
    i, j, k = 0, 0, l

    while i < len1 and j < len2:
        if left[i] <= right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1

    while i < len1:
        arr[k] = left[i]
        k += 1
        i += 1

    while j < len2:
        arr[k] = right[j]
        k += 1
        j += 1


def tim_sort(arr):
    """Sort an array using Timsort.

    Args:
        arr (List[int]): The input array to be sorted.
    """
    n = len(arr)
    min_run = calc_min_run(n)

    for start in range(0, n, min_run):
        end = min(start + min_run - 1, n - 1)
        insertion_sort(arr, start, end)

    size = min_run
    while size < n:
        for left in range(0, n, 2 * size):
            mid = min(n - 1, left + size - 1)
            right = min(left + 2 * size - 1, n - 1)
            if mid < right:
                merge(arr, left, mid, right)
        size = 2 * size


if __name__ == "__main":
    arr = [-2, 7, 15, -14, 0, 15, 0, 7, -7, -4, -13, 5, 8, -14, 12]
    print("Given Array is")
    print(arr)

    tim_sort(arr)

    print("After Sorting Array is")
    print(arr)
