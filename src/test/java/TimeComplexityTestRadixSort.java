import java.text.DecimalFormat;
import java.util.Random;

public class TimeComplexityTestRadixSort {

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
        int[] sizes = {10000, 100000}; //////////////    <------------Modify n here, can put in number of sizes to check

        for (int size : sizes) {
            // Generate different types of inputs
            Long[] randomInputLong = generateRandomArrayLong(size);

            Long[] sortedInputLong = generateSortedArrayLong(size);

            Long[] reverseSortedInputLong = generateReverseSortedArrayLong(size);

            Long[] nearlySortedInputLong = generateNearlySortedArrayLong(size);

            // O(n) randomInputLong
            long randomInputLongTime = getTimeN(randomInputLong);

            // O(n) sortedInputLong
            long sortedInputLongTime = getTimeN(sortedInputLong);

            // O(n) reverseSortedInputLong
            long reverseSortedInputLongTime = getTimeN(reverseSortedInputLong);

            // O(n) nearlySortedInputLong
            long nearlySortedInputLongTime = getTimeN(nearlySortedInputLong);

            // O(n2) randomInputLong
            long randomInputLongTime2 = getTimeN2(randomInputLong);

            // O(n2) sortedInputLong
            long sortedInputLongTime2 = getTimeN2(sortedInputLong);

            // O(n2) reverseSortedInputLong
            long reverseSortedInputLongTime2 = getTimeN2(reverseSortedInputLong);

            // O(n2) nearlySortedInputLong
            long nearlySortedInputLongTime2 = getTimeN2(nearlySortedInputLong);

            // O(NLogN) randomInputLong
            long randomInputLongTimeNLogN = getTimeNLogN(randomInputLong);

            // O(NLogN) sortedInputLong
            long sortedInputLongTimeNLogN = getTimeNLogN(sortedInputLong);

            // O(NLogN) reverseSortedInputLong
            long reverseSortedInputLongTimeNLogN = getTimeNLogN(reverseSortedInputLong);

            // O(n2) nearlySortedInputLong
            long nearlySortedInputLongTimeNLogN = getTimeNLogN(nearlySortedInputLong);



            // Measure execution time for each input
            // RANDOM
            long startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 1);
            long endTime = System.nanoTime();
            long randomTime1 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(randomInputLong, 4);
            endTime = System.nanoTime();
            long randomTime4 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(randomInputLong, 8);
            endTime = System.nanoTime();
            long randomTime8 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(randomInputLong, 16);
            endTime = System.nanoTime();
            long randomTime16 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(randomInputLong, 20);
            endTime = System.nanoTime();
            long randomTime20 = endTime - startTime;

            // SORTED
            startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 1);
            endTime = System.nanoTime();
            long sortedTime1 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 4);
            endTime = System.nanoTime();
            long sortedTime4 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 8);
            endTime = System.nanoTime();
            long sortedTime8 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 16);
            endTime = System.nanoTime();
            long sortedTime16 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(sortedInputLong, 20);
            endTime = System.nanoTime();
            long sortedTime20 = endTime - startTime;

            // REVERSE SORTED
            startTime = System.nanoTime();
            Sorter.radixSort(nearlySortedInputLong, 1);
            endTime = System.nanoTime();
            long nearlySortedTime1 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(nearlySortedInputLong, 4);
            endTime = System.nanoTime();
            long nearlySortedTime4 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(nearlySortedInputLong, 8);
            endTime = System.nanoTime();
            long nearlySortedTime8 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(nearlySortedInputLong, 16);
            endTime = System.nanoTime();
            long nearlySortedTime16 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(nearlySortedInputLong, 20);
            endTime = System.nanoTime();
            long nearlySortedTime20 = endTime - startTime;

            // NEARLY SORTED
            startTime = System.nanoTime();
            Sorter.radixSort(reverseSortedInputLong, 1);
            endTime = System.nanoTime();
            long reverseSortedTime1 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(reverseSortedInputLong, 4);
            endTime = System.nanoTime();
            long reverseSortedTime4 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(reverseSortedInputLong, 8);
            endTime = System.nanoTime();
            long reverseSortedTime8 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(reverseSortedInputLong, 16);
            endTime = System.nanoTime();
            long reverseSortedTime16 = endTime - startTime;

            startTime = System.nanoTime();
            Sorter.radixSort(reverseSortedInputLong, 20);
            endTime = System.nanoTime();
            long reverseSortedTime20 = endTime - startTime;

            // Analyze results (print or plot the data)
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            long con = 1000;

            // RANDOM LONG
            System.out.println("Random Input Time: sortedTime1`: " + formatter.format(sortedTime1/con) + " ms");
            System.out.println("Random Input Time: sortedTime4`: " + formatter.format(sortedTime4/con) + " ms");
            System.out.println("Random Input Time: sortedTime8`: " + formatter.format(sortedTime8/con) + " ms");
            System.out.println("Random Input Time: sortedTime16`: " + formatter.format(sortedTime16/con) + " ms");
            System.out.println("Random Input Time: sortedTime20`: " + formatter.format(sortedTime20/con) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(randomInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(randomInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(randomInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");


            // SORTED LONG
            System.out.println("Random Input Time: sortedTime1`: " + formatter.format(sortedTime1/con) + " ms");
            System.out.println("Random Input Time: sortedTime4`: " + formatter.format(sortedTime4/con) + " ms");
            System.out.println("Random Input Time: sortedTime8`: " + formatter.format(sortedTime8/con) + " ms");
            System.out.println("Random Input Time: sortedTime16`: " + formatter.format(sortedTime16/con) + " ms");
            System.out.println("Random Input Time: sortedTime20`: " + formatter.format(sortedTime20/con) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(sortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(sortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(sortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");


            // REVERSE SORTED LONG
            System.out.println("Random Input Time: reverseSortedTime1`: " + formatter.format(reverseSortedTime1/con) + " ms");
            System.out.println("Random Input Time: reverseSortedTime4`: " + formatter.format(reverseSortedTime4/con) + " ms");
            System.out.println("Random Input Time: reverseSortedTime8`: " + formatter.format(reverseSortedTime8/con) + " ms");
            System.out.println("Random Input Time: reverseSortedTime16`: " + formatter.format(reverseSortedTime16/con) + " ms");
            System.out.println("Random Input Time: reverseSortedTime20`: " + formatter.format(reverseSortedTime20/con) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(reverseSortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(reverseSortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(reverseSortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");

            //NEARLY SORTED LONG
            System.out.println("Random Input Time: nearlySortedTime1`: " + formatter.format(nearlySortedTime1/con) + " ms");
            System.out.println("Random Input Time: nearlySortedTime4`: " + formatter.format(nearlySortedTime4/con) + " ms");
            System.out.println("Random Input Time: nearlySortedTime8`: " + formatter.format(nearlySortedTime8/con) + " ms");
            System.out.println("Random Input Time: nearlySortedTime16`: " + formatter.format(nearlySortedTime16/con) + " ms");
            System.out.println("Random Input Time: nearlySortedTime20`: " + formatter.format(nearlySortedTime20/con) + " ms");
            System.out.println("Reference Time (n): " + formatter.format(nearlySortedInputLongTime) + " ms");
            System.out.println("Reference Time (nlogn): " + formatter.format(nearlySortedInputLongTimeNLogN) + " ms");
            System.out.println("Reference Time (n2): " + formatter.format(nearlySortedInputLongTime2) + " ms");
            System.out.println("-----------------------------------------------------");
        }
    }

    // Functions to generate different types of inputs (implementation omitted for brevity)
    private static Long[] generateRandomArrayLong(int size) {
        Random random = new Random();
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.toUnsignedLong(random.nextInt(10000));
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
}
