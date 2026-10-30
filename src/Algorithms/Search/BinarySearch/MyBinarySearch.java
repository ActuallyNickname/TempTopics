package Algorithms.Search.MyBinarySearch;

public class MyBinarySearch {

    private MyBinarySearch(){}

    public static int search(int[] array, int elementToIndexReturn){
        int from = 0;
        int to = array.length -1;
        int center = getCenterIndex(from,to);

        while(to!=from){
            if (elementToIndexReturn < array[center]) {
                to = center;
                center = getCenterIndex(from, to);
            } else if (elementToIndexReturn > array[center]){
                from = center;
                center = getCenterIndex(from, to);
            } else if (elementToIndexReturn == array[center]){
                break;
            }
        }
        return center;
    }

    private static int getCenterIndex(int from, int to){
        from = Math.min(from,to);
        to = Math.max(from,to);
        return (from + (to - from)/2);
    }
}
