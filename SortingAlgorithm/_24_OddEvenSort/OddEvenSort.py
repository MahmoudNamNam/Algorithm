def odd_even_sort(arr):
    """
    Sorts an array using the Odd-Even (or Brick) sort algorithm.

    :param arr: List of elements to be sorted.
    """
    n = len(arr)
    is_sorted = False

    while not is_sorted:
        is_sorted = True
        for i in range(1, n - 1, 2):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                is_sorted = False

        for i in range(0, n - 1, 2):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                is_sorted = False


if __name__ == "__main__":
    arr = [34, 2, 10, -9]
    odd_even_sort(arr)

    print("Sorted array:")
    for num in arr:
        print(num, end=" ")
