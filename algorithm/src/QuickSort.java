
public class QuickSort {
    public void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        quicksort(arr, left, right);
    }

    //divide and conquer strategy
    public void quicksort(int[] arr, int low, int high) {
        int middle = (low + high) / 2;
        int pivot = arr[middle];
        // low values < pivot value, high values > pivot value
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        //recursion
        if(low < j)
            quicksort(arr, low, j);
        if(high > i)
            quicksort(arr, i, high);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
