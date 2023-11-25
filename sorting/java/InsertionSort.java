class InsertionSort{

    void insertionSort(int arr[]){
        int currentElement;
        int j;
        for(int i = 0; i < arr.length; i++){
            currentElement = arr[i];
            j = i - 1;
            while(j >= 0 && arr[j] > currentElement){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentElement;
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

        InsertionSort obj = new InsertionSort();
        obj.insertionSort(arr);

        printArray(arr);
    }
}
