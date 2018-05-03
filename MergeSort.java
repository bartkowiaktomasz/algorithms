class MergeSort{

    void merge(int arr[], int left, int middle, int right){
        /* left = a[l,...,m]
            right = a[m+1,...,r-1] */

        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int L[] = new int[leftLength];
        int R[] = new int[rightLength];

        for(int i = 0; i < leftLength; i++){
            L[i] = arr[left + i];
        }
        for(int i = 0; i < rightLength; i++){
            R[i] = arr[middle + i + 1];
        }

        // Subarray indexes
        int i = 0, j = 0;

        // Merged array index
        int k = left;

        while(i < leftLength && j < rightLength){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < leftLength){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < rightLength){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[]){
        mergeSort(arr, 0, arr.length - 1);
    }

    void mergeSort(int arr[], int left, int right){
        if(left < right){

            // Find middle
            int middle = (left + right)/2;

            // Sort left and right halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge sorted halves
            merge(arr, left, middle, right);
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {3,1,5,2,10,10,3,12};    // Unsorted

        MergeSort obj = new MergeSort();
        obj.mergeSort(arr);

        printArray(arr);
    }
}
