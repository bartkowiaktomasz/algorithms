class SelectionSort{

    void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void selectionSort(int arr[]){
        int smallestIndex;
        int j;
        for(int i = 0; i < arr.length; i++){
            smallestIndex = i;
            j = i + 1;
            while(j < arr.length){
                if(arr[j] < arr[smallestIndex])
                    smallestIndex = j;
                j++;
            }
            swap(arr, smallestIndex, i);
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

        SelectionSort obj = new SelectionSort();
        obj.selectionSort(arr);

        printArray(arr);
    }
}
