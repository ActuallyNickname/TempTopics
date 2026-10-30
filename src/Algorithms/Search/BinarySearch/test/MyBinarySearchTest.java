package Algorithms.Search.MyBinarySearch.test;

import Algorithms.Search.MyBinarySearch.MyBinarySearch;
import Algorithms.Sort.AsymptoticallyOptimizedSort.MyQuickSort;
import Algorithms.Sort.AsymptoticallyOptimizedSort.test.MyQuickSortTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MyBinarySearchTest {
    private static ArrayList<int[]> notEmptyIntArrays;

    @BeforeAll
    public static void prepare(){
        notEmptyIntArrays = new ArrayList<>(){{
            add(new int[1]);
            add(new int[2]);
            add(new int[3]);
            add(new int[20]);
        }};
        Random random = new Random();
        for (int[] array : notEmptyIntArrays) {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(150)- random.nextInt(99);
            }
            MyQuickSort.sort(array);
        }
    }

    @Test
    public void shoudFindCorrectIndex(){
        int[] array = notEmptyIntArrays.get(3);
        Random random = new Random();
        int randomIndex = random.nextInt(array.length - 1);
        Assert.assertEquals(array[randomIndex],
                array[MyBinarySearch.search(array, array[randomIndex])]);
    }


    private static final int N        = 100_000;  // размер массива
    private static final int WARMUP   = 20;       // прогонов на прогрев JIT
    private static final int RUNS     = 15;       // прогонов для замера
    private static final long SEED    = 42L;      // фиксированный seed → воспроизводимость

    @Test
    void myMethodShouldCompletedInLessOrTheSameTime() {

        int[] original = randomArray(N, SEED);
        MyQuickSort.sort(original);

        // 1) прогрев — без него первый замер всегда врёт
        for (int i = 0; i < WARMUP; i++) {
            MyBinarySearch.search(original, original[i]);
            Arrays.binarySearch(original, original[i]);
        }


        int[] array = notEmptyIntArrays.get(3);
        Random random = new Random();
        int randomIndex = random.nextInt(array.length - 1);

        // 2) замер: медиана из RUNS прогонов
        long myTime  = medianTime(() -> MyBinarySearch.search(array, array[randomIndex]));
        long libTime = medianTime(() -> Arrays.binarySearch(array, array[randomIndex]));

        System.out.printf("My:  %8.3f ms%n", myTime  / 1e6);
        System.out.printf("Lib: %8.3f ms%n", libTime / 1e6);
        System.out.printf("ratio = %.2fx%n", (double) myTime / libTime);

        assumeTrue(myTime<=libTime, "мой search отработал медленнее проф решения");
    }

    // --- helpers ---

    private static long medianTime(Runnable r) {
        long[] t = new long[RUNS];
        for (int i = 0; i < RUNS; i++) {
            long s = System.nanoTime();
            r.run();
            t[i] = System.nanoTime() - s;
        }
        Arrays.sort(t);
        return t[RUNS / 2];
    }

    private static int[] randomArray(int n, long seed) {
        int[] a = new int[n];
        Random rnd = new Random(seed);
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
        return a;
    }


}
