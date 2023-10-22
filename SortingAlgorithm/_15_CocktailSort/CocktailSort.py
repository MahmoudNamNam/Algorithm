def cocktailSort(arr):
    n = len(arr)
    swapped = True
    start = 0
    end = n - 1

    while swapped:
        swapped = False

        # Move the larger elements to the end
        for i in range(start, end):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        if not swapped:
            break

        swapped = False

        # Move the smaller elements to the beginning
        end -= 1
        for i in range(end - 1, start - 1, -1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        start += 1


# Driver code
a = [5, 1, 4, 2, 8, 0, 2]
cocktailSort(a)
print("Sorted array is:")
for element in a:
    print(element, end=" ")
