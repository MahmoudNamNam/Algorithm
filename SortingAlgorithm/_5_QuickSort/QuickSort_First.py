
# Function to find the partition position
def partition(array, low, high):
    # Choose the leftmost element as pivot
    pivot = array[low]

    # Pointer for greater element
    i = low

    # Traverse through all elements, starting from the element after the pivot
    for j in range(low + 1, high + 1):
        if array[j] <= pivot:
            # If element smaller than pivot is found
            # swap it with the greater element pointed by i
            i = i + 1
            # Swapping element at i with element at j
            array[i], array[j] = array[j], array[i]

    # Swap the pivot element with
    # the greater element specified by i
    array[low], array[i] = array[i], array[low]

    # Return the position from where partition is done
    return i


# Function to perform quicksort
def quicksort(array, low, high):
    if low < high:
        # Find pivot element such that
        # element smaller than pivot are on the left
        # element greater than pivot are on the right
        pi = partition(array, low, high)

        # Recursive call on the left of pivot
        quicksort(array, low, pi - 1)

        # Recursive call on the right of pivot
        quicksort(array, pi + 1, high)


# Driver code
if __name__ == '__main__':
    array = [*map(int, input().split())]

    N = len(array)

    # Function call
    quicksort(array, 0, N - 1)
    print('Sorted array:')
    for x in array:
        print(x, end=" ")

