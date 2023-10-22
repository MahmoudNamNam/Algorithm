# To find the next gap from the current gap
def get_next_gap(gap):
    # Shrink gap by a shrink factor
    gap = (gap * 10) // 13
    if gap < 1:
        return 1
    return gap


# Function to sort arr[] using Comb Sort
def comb_sort(arr):
    n = len(arr)
    gap = n  # Initialize gap
    swapped = True  # Initialize swapped as true to ensure the loop runs

    # Keep running while the gap is more than 1 and the last iteration caused a swap
    while gap != 1 or swapped:
        # Find the next gap
        gap = get_next_gap(gap)
        swapped = False  # Initialize swapped as false to check if a swap happened

        # Compare all elements with the current gap
        for i in range(0, n - gap):
            if arr[i] > arr[i + gap]:
                arr[i], arr[i + gap] = arr[i + gap], arr[i]
                swapped = True


# Driver code to test the sorting
arr = [8, 4, 1, 56, 3, -44, 23, -6, 28, 0]
comb_sort(arr)

print("Sorted array:")
print(*arr, end=" ")  # Using list comprehension for printing
