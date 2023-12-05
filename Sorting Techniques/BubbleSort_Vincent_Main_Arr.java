public class BubbleSortingExercise {
    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90, 45, 72, 18};
        //Initializing the array
        System.out.println("Original Array:");
        printArray(arrayToSort);

        // Call the bubble sort function
        bubbleSort(arrayToSort);

        System.out.println("\nSorted Array:");
        //print the sorted function
        printArray(arrayToSort);
    }

    // Bubble Sort function (now complete)
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Implement Bubble Sort algorithm here
        for (int i = 0; i < n - 1; i++) {
            // make the number of passes 1 less than length
            for (int j = 0; j < n - i - 1; j++) {
                // from the first to the last unsorted element (n-i-1), check if first and second element should swap
                // if they should swap, swap them, then check second and third and so on. 
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                
            }
            // at the end of this for loop, another element is sorted at the end of the array
            // by the time all passes are complete, the array is sorted fully
        }
    }

    // Display array function
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
