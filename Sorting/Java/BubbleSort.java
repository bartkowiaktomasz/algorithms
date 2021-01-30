class BubbleSort{

    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void bubbleSort(int arr[]){
        int j;
        for(int i = 0; i < arr.length; i++){
            j = i + 1;
            while(j < arr.length){
                if(arr[j] < arr[j - 1])
                    swap(arr, j - 1, j);
                j++;
            }
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
        int arr[] = {3,1,5,2,10,10,3,12};    // Unsorted

        BubbleSort obj = new BubbleSort();
        obj.bubbleSort(arr);

        printArray(arr);
    }
}
