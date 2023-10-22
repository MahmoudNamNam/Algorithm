import random


# Sorts array a[0..n-1] using Bogo sort
def bogoSort(a):
    while not is_sorted(a):
        shuffle(a)


# To check if the array is sorted or not
def is_sorted(a):
    n = len(a)
    for i in range(n - 1):
        if a[i] > a[i + 1]:
            return False
    return True


# To generate a random permutation of the array
def shuffle(a):
    n = len(a)
    for i in range(n):
        r = random.randint(0, n - 1)
        a[i], a[r] = a[r], a[i]


# Driver code to test the algorithm
a = [3, 2, 4, 1, 0, 5]
bogoSort(a)
print("Sorted array:")
for i in range(len(a)):
    print("%d" % a[i], end=" ")
