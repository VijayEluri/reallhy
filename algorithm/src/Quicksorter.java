import java.util.*;
public class Quicksorter {
	public static void main(String... args){
		int[] arr = {9,3,4,5,6,7,2,1,8};
		Quicksorter qs = new Quicksorter();		
		// qs.quicksort(arr, 0, arr.length - 1);
		qs.mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}

	void quicksort(int[] arr, int left, int right){
		if(left < right) {
			int pivot = (right + left) / 2;
			int pivotValue = arr[pivot];
			swap(arr, pivot, right);
			int newPivot = left;
			for(int i = left; i < right; i++){
				if(arr[i] < pivotValue) { 
					swap(arr, i, newPivot);  // lesser value to left side
					newPivot = newPivot + 1; // move new pivot index to the rightside
				}
			}
			swap(arr, right, newPivot);
			quicksort(arr, left, newPivot - 1);
			quicksort(arr, newPivot + 1, right);
		}
	}

	void mergesort(int[] arr){		
		int n  = arr.length;
		if(n < 2) { // only one element in this part
			return;	
		}
		// divide into two parts
		int m = n / 2; // m : middle
		int[] left = new int[m]; 
		int[] right = new int[n - m]; 
		for(int i = 0; i < m; i++){
			left[i] = arr[i];
		}
		for(int i = m; i < n; i++){
			right[i - m] = arr[i];
		}

		// sort each partition recursivelyJ
		mergesort(left);
		mergesort(right);

		// merge already sorted left and right array
		int i = 0; // index of left array
		int j = 0; // index of right array
		int k = 0; // index of whole array		
		while(i < left.length && j < right.length){
			if(left[i] < right[j]){  // if left is lesser, left one is first come.
				arr[k++] = left[i++];
			} else if(left[i] > right[j]){  // right is lesser, right one is placed
				arr[k++] = right[j++];
			}
		}
		// surplus of left
		while(i < left.length){
			arr[k++] = left[i++];
		}
		// surplus of right
		while(j < right.length){
			arr[k++] = right[j++];
		}
	}

	void swap(int[] arr, int a, int b){
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}
}