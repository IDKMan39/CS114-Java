public class QuickSortExercise {
    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11, 90, 45, 72, 18};

        System.out.println("Original Array:");
        printArray(arrayToSort);

        // Call the quick sort function
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        // Print the sorted arr
        System.out.println("\nSorted Array:");
        printArray(arrayToSort);
    }

    // Quick Sort function (now complete)
    static void quickSort(int[] arr, int low, int high) {
        //System.out.println("Fcn call on  " + low + ";" + high);

        // Implement Quick Sort algorithm here
        // Since quicksort is a recursive algorithm, we must first set a condition for the end of the function calls. 
        // Once the section of the array to sort is less than 2 elements, there is no more sorting needed. 
        // Therefore, the sorting only continues while the low index < high index
        if (low < high) {

            int pivotdex = pivot(arr,low,high);
            // establishing the pivot splits the array into two smaller arrays.
            // the pivot function also pushes the pivot element to its rightful position in the array. 
            // this creates one sorted element and two smaller unsorted array sections

                //System.out.println("New pivot has at "+pivotdex);

            // Quicksort is then called on these smaller unsorted sections. This continues recursively until the array is sorted. 
            quickSort(arr,low,pivotdex-1); // the section of the array to the left of the pivot
            quickSort(arr,pivotdex+1,high); // the section of the array to the right of the pivot
            // Done above: Add logic to partition the array and recursively call quickSort on subarrays
           
        }
    }
    static int pivot(int[] arr,int low,int high){
        //System.out.println("==============");
        //printArraystf(arr,low,high);        

        int stored = low-1; //  // Index of smaller element and indicates where the pivot should go
        int pivot = arr[high];
        //System.out.println("Current Pivot "+ pivot);
        for(int i = low; i<high; i++){
            // iterates over the section of the array passed in as arguments
            if (arr[i] < pivot){
                // if the element should go to the left of the pivot, the above if statement is true 
                stored++;
                if (stored == i){
                    ;
                    //System.out.println("\t\t Self swap");
                    // this self swap was implemented to prevent swapping an element with the position its already in
                }else{ 
                    // then, swap this element to the smallest index that has not already been swapped to
                    // this is the necessity of the stored pointer, because it tells us the smallest index
                    // that has not already been swapped to 
                    int temp = arr[stored];
                    arr[stored] = arr[i];
                    arr[i] = temp;
                }
                
                
            }
        }
        // at the end, swap the pivot into the position after the values smaller than it. 
        
        stored++;
        // in order to not swap smaller values, we increment stored. 
        int temp = arr[stored];
        arr[stored] = arr[high];
        arr[high] = temp;
        //printArraystf(arr,low,high); <helper method I wrote to trouble shoot;
        // ^^ prints an array from a low index to a high index
        
        //System.out.println("==============");


        // As was explained, after this operation one element is sorted.
        return stored;
        
    }

   

    // Display array function
    static void printArray(int[] arr) {
        for (int value : arr) {
            
            System.out.print(value + " ");
            
        }
        System.out.println();
    }
    static void printArraystf(int[] arr,int start,int fin) {
        
        for (int i = start; i<=fin;i++) {
            
            System.out.print(arr[i] + " ");
            
        }
        System.out.println();
    }
}
