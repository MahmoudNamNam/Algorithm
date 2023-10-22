def countingSort(arr, exp):
    n = len(arr)
    output = [0] * n
    count = [0] * 10

    # Count the occurrences of each digit at the current position
    for i in range(n):
        index = (arr[i] // exp) % 10
        count[index] += 1

    # Calculate the actual position of each digit in the output array
    for i in range(1, 10):
        count[i] += count[i - 1]

    # Build the output array
    i = n - 1
    while i >= 0:
        index = (arr[i] // exp) % 10
        output[count[index] - 1] = arr[i]
        count[index] -= 1
        i -= 1

    # Copy the sorted output back to the original array
    for i in range(n):
        arr[i] = output[i]


def radixSort(arr):
    max_num = max(arr)
    exp = 1

    while max_num // exp > 0:
        countingSort(arr, exp)
        exp *= 10


# Driver code
arr = [170, 45, 75, 90, 802, 24, 2, 66]
radixSort(arr)

print("Sorted Array:", arr)
