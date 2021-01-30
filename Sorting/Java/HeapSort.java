class HeapSort{

    /* Swap two elements with indexes i,j */
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapSort(int arr[]){
        int lastIndex = arr.length - 1;

        // Build the heap
        buildMaxHeap(arr);

        // Extract max element from the heap
        while(lastIndex >= 0){

            // Put currently biggest element at the end
            swap(arr, 0, lastIndex);
            maxHeapify(arr, 0, lastIndex);
            lastIndex --;
        }
    }

    void maxHeapify(int arr[], int i, int n){
        int leftChildIndex = 2*i + 1;
        int rightChildIndex = 2*i + 2;
        int largestIndex = i;

        if(leftChildIndex < n && arr[leftChildIndex] > arr[largestIndex]){
            largestIndex = leftChildIndex;
        }
        if(rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex]){
            largestIndex = rightChildIndex;
        }

        if(largestIndex != i){
            swap(arr, i, largestIndex);
            maxHeapify(arr, largestIndex, n);
        }

    }

    void buildMaxHeap(int[] arr){
        int n = arr.length;
        for(int i = (int)Math.floor(arr.length/2); i >= 0 ; i--){
            maxHeapify(arr, i, n);
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]){
        // Parent of a[n] is floor(a[(n-1)/2])
        // Children of a[n] are a[2n+1] and a[2n+2]

        int arr[] = {2,3,5,1,1,8,10,7,16,4,5,10,20};

        HeapSort obj = new HeapSort();
        obj.heapSort(arr);

        printArray(arr);
    }
}
