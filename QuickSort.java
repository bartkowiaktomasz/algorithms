class QuickSort{

    /* Swap two elements with indexes i,j */
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int lomutoPartition(int arr[], int l, int r){
        int i = l;
        int j = l;
        int pivot = r - 1;

        while(i < pivot){
            if(arr[i] < arr[pivot]){
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        swap(arr, pivot, j);
        return j;
    }

    int hoarePartition(int arr[], int l, int r){
        int i = l - 1;
        int j = r;
        int pivot = arr[l];

        while(true){
            do{
                i++;
            } while(arr[i] < pivot);
            do{
                j--;
            } while(arr[j] > pivot);
            if(i >= j)
                return j;
            else
                swap(arr, i, j);
        }
    }

    void quickSort(int arr[]){
        quickSort(arr, 0, arr.length);
    }

    void quickSort(int arr[], int l, int r){
        if(r <= l + 1){     // 0 or 1 element in the array
            return;
        }
        // int pivot = lomutoPartition(arr, l, r);
        int pivot = hoarePartition(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);
        return;
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

        QuickSort obj = new QuickSort();
        obj.quickSort(arr);

        printArray(arr);
    }
}
