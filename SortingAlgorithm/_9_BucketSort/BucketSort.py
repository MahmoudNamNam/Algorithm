def insertionSort(bucket):
    for i in range(1, len(bucket)):
        key = bucket[i]
        j = i - 1
        while j >= 0 and bucket[j] > key:
            bucket[j + 1] = bucket[j]
            j -= 1
        bucket[j + 1] = key
    return bucket


def bucketSort(arr):
    # Determine the number of buckets (slots)
    num_buckets = 10
    buckets = [[] for _ in range(num_buckets)]

    # Distribute elements into buckets
    for value in arr:
        index = int(value * num_buckets)
        buckets[index].append(value)

    # Sort individual buckets using Insertion Sort
    for i in range(num_buckets):
        buckets[i] = insertionSort(buckets[i])

    # Concatenate sorted buckets to get the final sorted array
    sorted_arr = [element for bucket in buckets for element in bucket]

    return sorted_arr


# Driver code
if __name__ == "__main__":
    x = [0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434]
    sorted_x = bucketSort(x)
    print("Sorted Array:", sorted_x)
