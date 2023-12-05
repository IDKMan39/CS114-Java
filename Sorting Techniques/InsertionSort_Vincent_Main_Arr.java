public class InsertionSortExercise {
    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90, 45, 72, 18};

        System.out.println("Original Array:");
        printArray(arrayToSort);

        // Call the insertion sort function
        insertionSort(arrayToSort);
        // Print the new sorted 
        System.out.println("\nSorted Array:");
        printArray(arrayToSort);
    }

    // Insertion Sort function (incomplete - students need to complete the logic)
    static void insertionSort(int[] arr) {
        int n = arr.length;

        // Implement Insertion Sort algorithm here
        for (int i = 1; i < n; ++i) {
            // again we must iterate over the array. 
            //However for this algorithm, we can start preform the outer loop from 0 to length-2. 
            //This is because once we place all but one of the elements, the unplaced element will be in the correct spot.
            // TODO: Add logic to insert the current element into the sorted portion of the array
            int curr = arr[i] ;
            int j = i-1;
            
            while (j != -1 && arr[j] > curr){
                //This inner while loop finds the position j for which the current should go in front of.
                // It also swaps each element it passes forward, shifting the array down to fill the arr[i] element we are moving
                
                arr[j+1] = arr[j];
                j-=1;
                
            }  
           
            // Swap the start w/ the new position;
            arr[j+1] = curr; 
            
            
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
