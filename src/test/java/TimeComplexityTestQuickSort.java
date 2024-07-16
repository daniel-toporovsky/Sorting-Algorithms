import java.text.DecimalFormat;
import java.util.Random;

public class TimeComplexityTestQuickSort {

    public static<T extends Comparable<T>> Long getTimeN(T[] arr) {
        long startTime = System.nanoTime();
        System.arraycopy(arr, 0, arr, 0, arr.length);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static<T extends Comparable<T>> Long getTimeN2(T[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr, 0, arr, 0, arr.length);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static<T extends Comparable<T>> Long getTimeNLogN(T[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            Math.log(arr.length);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = {100000};

        for (int size : sizes) {
            // Generate different types of inputs
            Integer[] randomInputInt = generateRandomArrayInt(size);
            Long[] randomInputLong = generateRandomArrayLong(size);

            Integer[] sortedInputInt = generateSortedArrayInt(size);
            Long[] sortedInputLong = generateSortedArrayLong(size);

            Integer[] reverseSortedInputInt = generateReverseSortedArrayInt(size);
            Long[] reverseSortedInputLong = generateReverseSortedArrayLong(size);

            Integer[] nearlySortedInputInt = generateNearlySortedArrayInt(size);
            Long[] nearlySortedInputLong = generateNearlySortedArrayLong(size);

            // O(n) randomInputInt
            long randomInputIntTime = getTimeN(randomInputInt);
            // O(n) randomInputLong
            long randomInputLongTime = getTimeN(randomInputLong);

            // O(n) sortedInputInt
            long sortedInputIntTime = getTimeN(sortedInputInt);
            // O(n) sortedInputLong
            long sortedInputLongTime = getTimeN(sortedInputLong);

            // O(n) reverseSortedInputInt
            long reverseSortedInputIntTime = getTimeN(reverseSortedInputInt);
            // O(n) reverseSortedInputLong
            long reverseSortedInputLongTime = getTimeN(reverseSortedInputLong);

            // O(n) nearlySortedInputInt
            long nearlySortedInputIntTime = getTimeN(nearlySortedInputInt);
            // O(n) nearlySortedInputLong
            long nearlySortedInputLongTime = getTimeN(nearlySortedInputLong);

            // O(n2) randomInputInt
            long randomInputIntTime2 = getTimeN2(randomInputInt);
            // O(n2) randomInputLong
            long randomInputLongTime2 = getTimeN2(randomInputLong);

            // O(n2) sortedInputInt
            long sortedInputIntTime2 = getTimeN2(sortedInputInt);
            // O(n2) sortedInputLong
            long sortedInputLongTime2 = getTimeN2(sortedInputLong);

            // O(n2) reverseSortedInputInt
            long reverseSortedInputIntTime2 = getTimeN2(reverseSortedInputInt);
            // O(n2) reverseSortedInputLong
            long reverseSortedInputLongTime2 = getTimeN2(reverseSortedInputLong);

            // O(n2) nearlySortedInputInt
            long nearlySortedInputIntTime2 = getTimeN2(nearlySortedInputInt);
            // O(n2) nearlySortedInputLong
            long nearlySortedInputLongTime2 = getTimeN2(nearlySortedInputLong);

            // O(NLogN) randomInputInt
            long randomInputIntTimeNLogN = getTimeNLogN(randomInputInt);
            // O(NLogN) randomInputLong
            long randomInputLongTimeNLogN = getTimeNLogN(randomInputLong);

            // O(NLogN) sortedInputInt
            long sortedInputIntTimeNLogN = getTimeNLogN(sortedInputInt);
            // O(NLogN) sortedInputLong
            long sortedInputLongTimeNLogN = getTimeNLogN(sortedInputLong);

            // O(NLogN) reverseSortedInputInt
            long reverseSortedInputIntTimeNLogN = getTimeNLogN(reverseSortedInputInt);
            // O(NLogN) reverseSortedInputLong
            long reverseSortedInputLongTimeNLogN = getTimeNLogN(reverseSortedInputLong);

            // O(NLogN) nearlySortedInputInt
            long nearlySortedInputIntTimeNLogN = getTimeNLogN(nearlySortedInputInt);
            // O(n2) nearlySortedInputLong
            long nearlySortedInputLongTimeNLogN = getTimeNLogN(nearlySortedInputLong);



            // Measure execution time for each input
            long startTime = System.nanoTime();
            Sorter.quickSort(randomInputInt);
            long endTime = System.nanoTime();
            long randomTimeIntQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(randomInputLong);
            endTime = System.nanoTime();
            long randomTimeLongQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(sortedInputInt);
            endTime = System.nanoTime();
            long sortedTimeIntQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(sortedInputLong);
            endTime = System.nanoTime();
            long sortedTimeLongQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(nearlySortedInputInt);
            endTime = System.nanoTime();
            long nearlySortedTimeIntQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(nearlySortedInputLong);
            endTime = System.nanoTime();
            long nearlySortedTimeLongQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(reverseSortedInputInt);
            endTime = System.nanoTime();
            long reverseSortedTimeIntQuick = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.quickSort(reverseSortedInputLong);
            endTime = System.nanoTime();
            long reverseSortedTimeLongQuick = endTime - startTime;

            // Analyze results (print or plot the data)
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            // RANDOM INT
            System.out.println("Size: " + size);
            System.out.println("Random Input Time: randomInputIntTime`: " + formatter.format(randomTimeIntQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(randomInputIntTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(randomInputIntTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(randomInputIntTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            // RANDOM LONG
            System.out.println("Random Input Time: randomInputLongTime`: " + formatter.format(randomTimeLongQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(randomInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(randomInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(randomInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            // SORTED INT
            System.out.println("Random Input Time: sortedInputIntTime`: " + formatter.format(sortedTimeIntQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(sortedInputIntTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(sortedInputIntTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(sortedInputIntTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            // SORTED LONG
            System.out.println("Random Input Time: sortedInputLongTime`: " + formatter.format(sortedTimeLongQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(sortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(sortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(sortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            //NEARLY SORTED INT
            System.out.println("Random Input Time: nearlySortedInputIntTime`: " + formatter.format(nearlySortedTimeIntQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(nearlySortedInputIntTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(nearlySortedInputIntTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(nearlySortedInputIntTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            //NEARLY SORTED LONG
            System.out.println("Random Input Time: nearlySortedInputLongTime`: " + formatter.format(nearlySortedTimeLongQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(nearlySortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(nearlySortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(nearlySortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            //REVERSE SORTED INT
            System.out.println("Random Input Time: reverseSortedInputIntTime`: " + formatter.format(reverseSortedTimeIntQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(reverseSortedInputIntTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(reverseSortedInputIntTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(reverseSortedInputIntTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            //REVERSE SORTED LONG
            System.out.println("Random Input Time: reverseSortedInputLongTime`: " + formatter.format(reverseSortedTimeLongQuick/2) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(reverseSortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(reverseSortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(reverseSortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");
        }
    }

    // Functions to generate different types of inputs (implementation omitted for brevity)
    private static Integer[] generateRandomArrayInt(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    private static Long[] generateRandomArrayLong(int size) {
        Random random = new Random();
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.toUnsignedLong(random.nextInt(10000));
        }
        return array;
    }

    private static Integer[] generateSortedArrayInt(int size) {
        Random random = new Random();
        int start = random.nextInt(10000);
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = start;
            start += random.nextInt();

        }
        return array;
    }

    private static Long[] generateSortedArrayLong(int size) {
        Random random = new Random();
        int start = random.nextInt(10000);
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.toUnsignedLong(start);
            start += random.nextInt();
        }
        return array;
    }

    private static Integer[] generateReverseSortedArrayInt(int size) {
        Random random = new Random();
        int start = random.nextInt(10000);
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = start;
            start -= random.nextInt();

        }
        return array;
    }

    private static Long[] generateReverseSortedArrayLong(int size) {
        Random random = new Random();
        int start = random.nextInt(10000);
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.toUnsignedLong(start);
            start -= random.nextInt();
        }
        return array;
    }

    private static Long[] generateNearlySortedArrayLong(int size) {
        Random random = new Random();
        int swaps = random.nextInt(size/10);
        Long[] array = generateSortedArrayLong(size);
        for (int i = 0; i <= swaps; i++) {
            int nextVictim = random.nextInt(size-2);
            Long tmp = array[nextVictim];
            array[nextVictim] = array[nextVictim+1];
            array[nextVictim+1] = tmp;
        }
        return array;
    }

    private static Integer[] generateNearlySortedArrayInt(int size) {
        Random random = new Random();
        int swaps = random.nextInt(size/10);
        Integer[] array = generateSortedArrayInt(size);
        for (int i = 0; i <= swaps; i++) {
            int nextVictim = random.nextInt(size-2);
            Integer tmp = array[nextVictim];
            array[nextVictim] = array[nextVictim+1];
            array[nextVictim+1] = tmp;
        }
        return array;
    }
}
