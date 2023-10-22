def stooge_sort(arr, l, h):
    if l >= h:
        return

    # If the first element is greater than the last, swap them
    if arr[l] > arr[h]:
        arr[l], arr[h] = arr[h], arr[l]

    # If there are more than 2 elements in the array
    if h - l + 1 > 2:
        t = (h - l + 1) // 3

        # Recursively sort the first 2/3 elements
        stooge_sort(arr, l, h - t)

        # Recursively sort the last 2/3 elements
        stooge_sort(arr, l + t, h)

        # Recursively sort the first 2/3 elements again to confirm
        stooge_sort(arr, l, h - t)


# Driver
arr = [2, 4, 5, 3, 1]
n = len(arr)

stooge_sort(arr, 0, n - 1)

print("Sorted array:")
for i in range(n):
    print(arr[i], end=' ')
