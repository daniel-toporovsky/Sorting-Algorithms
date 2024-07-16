import java.util.Arrays;
import java.util.Objects;

/**
 * Class containing sorting methods {@code QuickSort},
 * {@code MergeSort} and {@code RadixSort}
 * that are used to sort an array of {@link Comparable} objects.
 * @author Daniel Toporovsky
 */
public class Sorter {
    /**
     * Sorts an array of comparable elements using Quick Sort.
     * @param       array an array of elements to sort
     * @param       <T> type of elements in array, must extend comparable
     */
    public static <T extends Comparable<T>> void quickSort(T[] array) {
        if (isEmpty(array)) return;

        // If an array is 3 elements and fewer sorts them using SelectionSort
        if (array.length <= 3) {
            selectionSort(array);
        }
        else {
            // Sorting an array using QuickSort
            int p = 0;
            int r = array.length - 1;
            quickSort(array, p, r);
        }
    }

    /**
     * Sorts an array of comparable elements using iterative Merge Sort.
     * @param       array an array of elements to sort
     * @param       <T> Type of elements in array, must extend comparable
     */
    public static <T extends Comparable<T>> void mergeSortNoRecursion(T[] array) {
        if (isEmpty(array)) return;

        // Makes index '1' first in the reference system
        T[] arrayShifted = offset(array);

        // Iteratively merges sub-arrays of increasing sizes until the entire array is sorted
        int n = arrayShifted.length - 1;
        int currSize = 1;
        while (currSize <= n) {
            for (int i = 1; i <= n; i += (currSize * 2)) {
                int mid = Math.min(i + currSize - 1, n);
                int end = Math.min(i + (currSize * 2) - 1, n);
                merge(arrayShifted, i, mid, end);
            }
            currSize *= 2;
        }

        // Moves elements back to index 0
        System.arraycopy(arrayShifted, 1, array, 0, array.length);
    }

    /**
     * Sorts Long array with Radix Sort.
     * @param       array an array of non-negative Long numbers to sort
     * @param       bitsPerDigit the base is a power of 2 between {@code 1} and {@code 20}
     */
    public static void radixSort(Long[] array, int bitsPerDigit) {
        if (isEmpty(array)) return;

        // Makes index 1 first in the reference system
        Long[] arrayShifted = offset(array);

        int maxDigit = getMaxDigit(arrayShifted, bitsPerDigit);

        // Sorting iteratively by digit from the least significant digit
        for (int i = 0; i <= maxDigit; i++) {
            countingSort(arrayShifted, bitsPerDigit, i);
        }

        // Moves elements back to index 0
        System.arraycopy(arrayShifted, 1, array, 0, array.length);
    }

    /**
     * {@link Sorter#radixSort(Long[], int)} auxiliary method.<p>
     * Finds the maximum digit index based on the array's
     * maximum value and the bits per digit value.
     * @param   array an array of non-negative Long numbers
     * @param   bitsPerDigit the base is a power of 2 between {@code 1} and {@code 20}
     * @return  the maximal digit index
     */
    private static int getMaxDigit(Long[] array, int bitsPerDigit) {
        // Finds max value
        Long maxVal = 0L;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        // Finds max digit
        int maxDigit = (int)Math.ceil((double) 64 / bitsPerDigit) - 1;
        int maxBlock = (int)Math.ceil((double) 64 / bitsPerDigit) - 1;
        while (extractDigit(maxVal, bitsPerDigit, maxBlock) == 0) {
            maxDigit = --maxBlock;
        }

        return maxDigit;
    }

    /**
     * {@link Sorter#radixSort(Long[], int)} auxiliary method.<p>
     * Sorts an array based on the digit at specified index.
     * @param   arr array of non-negative Long numbers
     * @param   bitsPerDigit the base is a power of 2 between {@code 1} and {@code 20}
     * @param   digitIndex index of the digit to use as the key for sorting
     */
    private static void countingSort(Long[] arr, int bitsPerDigit, int digitIndex) {
        int[] countArr = new int[1 << bitsPerDigit];

        // Counts appearances of the given digitIndex in array
        for (int i = 1; i < arr.length; i++) {
            int currDigit = extractDigit(arr[i], bitsPerDigit, digitIndex);
            countArr[currDigit]++;
        }

        // Updates countArr to show cumulative count of elements less/equal to current element
        for (int i = 1; i < countArr.length; i++) { // Changed to i < countArr.length
            countArr[i] += countArr[i - 1];
        }

        // Inserts original values sorted by digitIndex field to a new array
        Long[] outputArr = new Long[arr.length];
        for (int i = arr.length - 1; i >= 1; i--) {
            int currDigit = extractDigit(arr[i], bitsPerDigit, digitIndex);
            outputArr[countArr[currDigit]] = arr[i];
            countArr[currDigit]--;
        }

        // Updates original array
        System.arraycopy(outputArr, 1, arr, 1, arr.length - 1);
    }

    /**
     * {@link Sorter#radixSort(Long[], int)} auxiliary method.<p>
     * Extracts a specific digit from a number represented in a certain base.
     * @param   key Long integer from which a digit is extracted
     * @param   bitsPerDigit the base is a power of 2 between {@code 1} and {@code 20}
     * @param   digitIndex index of the digit to be extracted, where index 0 is LSB
     * @return  the digit at {@code digitIndex}'th index
     */
    private static int extractDigit(Long key, int bitsPerDigit, int digitIndex) {
        int mask = (1 << bitsPerDigit) - 1;
        int resultToLSBblock = (int) (key >> (digitIndex * bitsPerDigit));
        return mask & resultToLSBblock;
    }

    /**
     * {@link Sorter#mergeSortNoRecursion(Comparable[])} auxiliary method.
     * <p>
     * Merges two sorted sub-arrays into a single sorted array.
     * @param   array of elements to merge
     * @param   <T> Type of elements in array, must extend comparable
     * @param   p the first sub-array lower-bound
     * @param   q the first sub-array upper-bound
     * @param   r the second sub-array upper-bound
     */
    private static <T extends Comparable<T>> void merge(T[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        // Creates sub-arrays
        T[] L = Arrays.copyOfRange(array, p, q + 1);
        T[] R = Arrays.copyOfRange(array, q + 1, r + 1);

        // Merges the sub-arrays
        int i = 0, j = 0, k = p;
        while (i < n1 && j < n2) {
            if (L[i] != null && (R[j] == null || L[i].compareTo(R[j]) <= 0)) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copies remaining elements of L[] and R[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * {@link Sorter#quickSort(Comparable[])} auxiliary method.
     * <p>
     * Used to handle the recursive sorting within the specified range.
     * @param   array an array of elements to sort
     * @param   <T> Type of elements in array, must extend comparable
     * @param   p range lower-bound
     * @param   r range upper-bound
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    /**
     * {@link Sorter#quickSort(Comparable[])} auxiliary method.
     * <p>
     * Places elements correctly around the pivot.
     * @param   array of elements to make partition
     * @param   <T> Type of elements in array, must extend comparable
     * @param   p range lower-bound
     * @param   r range upper-bound
     * @return  the index of the pivot element after partitioning the array
     */
    private static <T extends Comparable<T>> int partition(T[] array, int p, int r) {
        // Chooses pivot randomly
        int random = p + (int)(Math.random() * (r - p + 1));
        T x = array[random];

        // If pivot is not the last element swaps them
        if (random != r) {
            swap(array, random, r);
        }

        // Performs partition
        int j = r - 1;
        int i = p;
        while (true) {
            while (j >= p && (array[j] == null || array[j].compareTo(x) > 0)) {
                j--;
            }
            while (i <= r - 1 && (array[i] != null && array[i].compareTo(x) <= 0)) {
                i++;
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, i, r);
        return i;
    }

    /**
     * {@link Sorter#quickSort(Comparable[])} auxiliary method.
     * <p>
     * Swaps the elements on given indexes.
     * @param   array an array of elements to swap
     * @param   <T> Type of elements in array, must extend comparable
     * @param   i first element's index
     * @param   j second element's index
     */
    private static<T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * {@link Sorter#quickSort(Comparable[])} auxiliary method.
     * <p>
     * Sorts an array using Selection Sort.
     * @param   array an array of elements to sort
     * @param   <T> Type of elements in array, must extend comparable
     */
    private static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
    }

    /**
     * {@link Sorter} auxiliary method.
     * <p>
     * Moves elements from index {@code 0} to {@code 1} repeatedly.
     * @param   array array of elements to move
     * @param   <T> Type of elements in array, must extend comparable
     * @return  an array with index {@code 1} first in the reference system
     */
    private static <T extends Comparable<T>> T[] offset(T[] array) {
        int newSize = array.length + 1;
        T[] newArray = Arrays.copyOf(array, newSize);
        System.arraycopy(array, 0, newArray, 1, array.length);
        newArray[0] = null;
        return newArray;
    }

    /**
     * {@link Sorter} auxiliary method.
     * <p>
     * Checks if an array is empty.
     * @param   array array of elements to get checked
     * @param   <T> Type of elements in array, must extend comparable
     * @return  true if an array is empty
     */
    private static <T extends Comparable<T>> boolean isEmpty(T[] array) {
        return (array.length == 0 || Arrays.stream(array).allMatch(Objects::isNull));
    }
}
