public class QuickSort {

    // Function to perform quicksort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the pivot element such that
            // elements smaller than pivot are on the left
            // and elements greater than pivot are on the right
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);  // Before pivot
            quickSort(arr, pi + 1, high); // After pivot
        }
    }

    // Function to partition the array on the basis of pivot
    public static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];

        // Pointer for the greater element
        int i = (low - 1);

        // Traverse each element of the array
        // compare them with the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the greater element specified by i
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the position from where partition is done
        return i + 1;
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the quicksort algorithm
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        System.out.println("Given Array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}
