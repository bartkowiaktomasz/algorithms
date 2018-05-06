class BinaryHeap{

    /* Swap two elements with indexes i,j */
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Given a heap tree except for node i, arrange the node i
    To insert - add to the end of the list and then maxHeapify
    To delete - swap given node with the last one, delete and maxHeapify
    */
    void maxHeapify(int arr[], int i){
        int leftChildIndex = 2*i + 1;
        int rightChildIndex = 2*i + 2;
        int largestIndex = i;

        if(leftChildIndex < arr.length && arr[leftChildIndex] > arr[largestIndex])
            largestIndex = leftChildIndex;
        if(rightChildIndex < arr.length && arr[rightChildIndex] > arr[largestIndex])
            largestIndex = rightChildIndex;

        if(largestIndex != i){
            swap(arr, i, largestIndex);
            maxHeapify(arr, largestIndex);
        }
        return;
    }

    void buildMaxHeap(int arr[]){
        for(int i = (int)Math.floor(arr.length/2); i >= 0; i--){
            maxHeapify(arr, i);
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

        BinaryHeap obj = new BinaryHeap();
        obj.buildMaxHeap(arr);

        printArray(arr);
    }
}
