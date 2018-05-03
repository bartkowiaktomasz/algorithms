class BinarySearch{

    public static boolean binarySearchRecursive(int arr[], int x){
        int left = 0;
        int right = arr.length - 1;

        return binarySearchRecursive(arr, x, left, right);
    }

    public static boolean binarySearchRecursive(int arr[], int x, int left, int right){
        int middle = (left + right) / 2;
        if(arr[middle] == x)
            return true;
        else{
            if(right <= left)
                return false;
            if(x > arr[middle])
                return binarySearchRecursive(arr, x, middle + 1, right);
            else{
                return binarySearchRecursive(arr, x, left, middle - 1);
            }
        }
    }

    public static boolean binarySearchIterative(int arr[], int x){
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;

        while(left <= right){
            middle = (left + right) / 2;

            if(arr[middle] == x)
                return true;
            else{
                if(x > arr[middle])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        return false;

    }

    public static void main(String args[]){
        int arr[] = {2,3,4,5,10,20};    // Assume sorted
        int x = 0;

        if(binarySearchIterative(arr, x))
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}
