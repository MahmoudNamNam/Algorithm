def pigeonhole_sort(a):
    """
    Pigeonhole Sort implementation.
    
    Args:
    a (list): The input list to be sorted.

    Note:
    - This function sorts the input list in place.
    - It assumes that the input list contains only integers.
    """
    # Find the range of values in the list
    min_ele = min(a)
    max_ele = max(a)
    size = max_ele - min_ele + 1

    # Create pigeonholes
    holes = [0] * size

    # Populate the pigeonholes
    for x in a:
        assert isinstance(x, int), "Integers only, please"
        holes[x - min_ele] += 1

    # Put the elements back into the array in order
    i = 0
    for count in range(size):
        while holes[count] > 0:
            holes[count] -= 1
            a[i] = count + min_ele
            i += 1


# Test the sorting algorithm
a = [8, 3, 2, 7, 4, 6, 8]
print("Sorted order is:", end=' ')
pigeonhole_sort(a)
print(*a, end=' ')
