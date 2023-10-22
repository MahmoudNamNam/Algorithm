package Algorithm.SortingAlgorithm._16_StrandSort;

import java.util.*;

public class StrandSort {

  public static <T extends Comparable<T>> List<T> sort(List<T> inputList) {
    return sort(inputList, Comparator.naturalOrder());
  }

  public static <T> List<T> sort(List<T> inputList, Comparator<T> comparator) {
    if (inputList.isEmpty()) {
      return new ArrayList<>();
    }

    // Create a sub-list.
    List<T> subList = new ArrayList<>();
    subList.add(inputList.remove(0));

    // Compare the last element in the sub-list to each subsequent element in
    // the original list.
    for (T element : inputList) {
      if (comparator.compare(element, subList.get(subList.size() - 1)) > 0) {
        subList.add(element);
        inputList.remove(element);
      }
    }

    // Merge the sub-list into the new list.
    List<T> newList = sort(inputList, comparator);
    newList.addAll(subList);

    // Return the sorted list.
    return newList;
  }

  public static void main(String[] args) {
      List<Integer> inputList = Arrays.asList(4, 3, 5, 1, 2);

      List<Integer> sortedList = StrandSort.sort(inputList);

      System.out.println(sortedList);

  }
}
