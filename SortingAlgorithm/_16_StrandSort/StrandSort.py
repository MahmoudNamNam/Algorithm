import operator


def strand_sort(arr: list,
                reverse: bool = False,
                solution: list = None) -> list:
    _operator = operator.lt if reverse else operator.gt
    solution = solution or []
    if not arr:
        return solution
    sublist = [arr.pop(0)]
    for i, item in enumerate(arr):
        if _operator(item, sublist[-1]):
            sublist.append(item)
            arr.pop(i)

    #  merging sublist into solution list
    if not solution:
        solution.extend(sublist)
    else:
        while sublist:
            item = sublist.pop(0)
            for i, xx in enumerate(solution):
                if not _operator(item, xx):
                    solution.insert(i, item)
                    break
            else:
                solution.append(item)

    strand_sort(arr, reverse, solution)
    return solution


lst = [4, 3, 5, 1, 2]
print("\nOriginal list:")
print(lst)
print("After applying  Strand sort the said list becomes:")
print(strand_sort(lst))
lst = [5, 9, 10, 3, -4, 5, 178, 92, 46, -18, 0, 7]
print("\nOriginal list:")
print(lst)
print("After applying Strand sort the said list becomes:")
print(strand_sort(lst))
lst = [1.1, 1, 0, -1, -1.1, .1]
print("\nOriginal list:")
print(lst)
print("After applying Strand sort the said list becomes:")
print(strand_sort(lst))
