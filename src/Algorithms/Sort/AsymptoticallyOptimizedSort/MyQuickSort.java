package Algorithms.Sort.AsymptoticallyOptimizedSort;

import java.util.Random;

public final class MyQuickSort {


    private MyQuickSort(){}
    /**
     * Classic Quick Sort
     * @param arr array to sort
     * @return sorted int array
     * */
    public static void sort(int[] arr){
        if ((arr == null) || (arr.length < 2)) return;

        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr,
                                   int from, int to){
        if (isBasicCase(from, to)) return;

        int pivotIndex = definePivotIndex(from, to);

        // прячем pivot
        pivotIndex = getHiddingElementIndex(arr, pivotIndex, to);
        int pivot = arr[to];


        int rightIndex = to-1;
        int leftIndex = from;


        while(leftIndex<rightIndex){

                if ((arr[leftIndex] < pivot)){
                    leftIndex++;
                }

                if (arr[rightIndex] > pivot){
                    rightIndex--;
                }



            if ((leftIndex<rightIndex) && (arr[leftIndex] >= pivot) &&
                    (arr[rightIndex] <= pivot)){
                swapWithReturning1stElemIndex(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        pivotIndex = getIndexOfRaisedPivot(arr, leftIndex, pivot, pivotIndex);

        quickSort(arr, from, pivotIndex-1);
         /* во второй рекурсии может быть from>to при pivotIndex==to
         (контрим вначале как базовый случай из 1 элемента)*/
        quickSort(arr, pivotIndex + 1, to);
    }

    private static int getHiddingElementIndex(int[] arr, int hiddingElemIndex, int newElemIndex) {
        return swapWithReturning1stElemIndex(arr, hiddingElemIndex, newElemIndex);
    }

    private static int getIndexOfRaisedPivot(int[] arr, int leftIndex, int pivot, int pivotIndex) {
        if (arr[leftIndex] > pivot){
            pivotIndex = swapWithReturning1stElemIndex(arr, pivotIndex, leftIndex);
        } else if (arr[leftIndex] <= pivot) {
            pivotIndex = swapWithReturning1stElemIndex(arr, pivotIndex, leftIndex + 1);
        }
        return pivotIndex;
    }

    private static boolean isBasicCase(int from, int to) {
        return (to - from) <= 0;
    }

    private static int definePivotIndex(int from, int to) {
        Random random = new Random();
        int pivotIndex = from + random.nextInt(to - from);
        return pivotIndex;
    }

    private static int swapWithReturning1stElemIndex(int[] arr,
                                                     int elem1Index, int returnableElem2Index){
        if (returnableElem2Index == elem1Index) return returnableElem2Index;
        int temp = arr[elem1Index];
        arr[elem1Index] = arr[returnableElem2Index];
        arr[returnableElem2Index] = temp;
        return returnableElem2Index;
    }
}
