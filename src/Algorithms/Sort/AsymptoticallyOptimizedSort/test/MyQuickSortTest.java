package Algorithms.Sort.AsymptoticallyOptimizedSort.test;

import Algorithms.Sort.AsymptoticallyOptimizedSort.MyQuickSort;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyQuickSortTest {


    private static int[] nullArray = null;

    @Test
    public void nullIsProcessed() {
        Assertions.assertDoesNotThrow(() -> MyQuickSort.sort(nullArray));
    }

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
        }
    }

    private static void assertSortsCorrectly(int index) {
        int[] source = notEmptyIntArrays.get(index);

        int[] expected = source.clone();
        Arrays.sort(expected);

        int[] actual = source.clone();
        MyQuickSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void array1SortedCorrect(){
        assertSortsCorrectly(0);
    }

    @Test
    public void array2SortedCorrect(){
        assertSortsCorrectly(1);
    }

    @Test
    public void array3SortedCorrect(){
        assertSortsCorrectly(2);
    }

    @Test
    public void array20SortedCorrect(){
        assertSortsCorrectly(3);
    }

    @Test
    public void manyArrays20SortedCorrect(){
        for (int i = 0; i < 30; i++) {
            array20SortedCorrect();
        }
    }


    private static final int N        = 100_000;  // размер массива
    private static final int WARMUP   = 20;       // прогонов на прогрев JIT
    private static final int RUNS     = 15;       // прогонов для замера
    private static final long SEED    = 42L;      // фиксированный seed → воспроизводимость

    @Test
    void compareWithLibrarySort() {
        int[] original = randomArray(N, SEED);

        // 1) прогрев — без него первый замер всегда врёт
        for (int i = 0; i < WARMUP; i++) {
            MyQuickSort.sort(original.clone());
            Arrays.sort(original.clone());
        }

        // 2) замер: медиана из RUNS прогонов
        long myTime  = medianTime(() -> MyQuickSort.sort(original.clone()));
        long libTime = medianTime(() -> Arrays.sort(original.clone()));

        System.out.printf("My:  %8.3f ms%n", myTime  / 1e6);
        System.out.printf("Lib: %8.3f ms%n", libTime / 1e6);
        System.out.printf("ratio = %.2fx%n", (double) myTime / libTime);

        assertTrue(myTime<=libTime, "мой sort отработал медленнее проф решения");
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
