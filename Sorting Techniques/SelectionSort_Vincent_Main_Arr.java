public class SelectionSortExercise {
    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90, 45, 72, 18};

        System.out.println("Original Array:");
        printArray(arrayToSort);

        // Call the selection sort function
        selectionSort(arrayToSort);
        // print the sorted array
        System.out.println("\nSorted Array:");
        printArray(arrayToSort);
    }

    // Selection Sort function (now complete)
    static void selectionSort(int[] arr) {
        int n = arr.length;

        // Implement Selection Sort algorithm here
        for (int i = 0; i < n - 1; i++) {
            // this loop again makes from one less than the length passes
            int mindex = i; // the index of the minimum value
            
            for (int j = i+1; j<n;j++){
                // this loop runs from i+1 because after each pass another element will be sorted starting at the front of the list.
                if (arr[mindex] > arr[j]){
                    mindex = j;
                }
                // checking if the current mindex is the index of the smallest value
            }
            // swap the smallest number in the current array with the lowest unsorted index 
            swap(arr,i,mindex);
        }
        // done: Add logic to find the minimum element and swap with the current element

    }
    

    // Swap function
    static void swap(int[] arr, int a, int b) {
        // swaps two elements giving thier indexs
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Display array function
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
