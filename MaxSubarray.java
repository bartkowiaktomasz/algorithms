import java.util.Arrays;
import java.util.Collections;

class MaxSubarray{

    static int maxSumPrefixSubarray(int arr[], int prefix){
        int sumMax = 0;
        for(int i = prefix; i < arr.length; i++){
            int sumCurrent = 0;
            for(int j = prefix; j <=  i; j++){
                sumCurrent += arr[j];
            }
            if(sumCurrent > sumMax)
                sumMax = sumCurrent;
        }
        return sumMax;
    }

    static int maxSumSubarray(int arr[]){
        int[] maxSumArr = new int[arr.length];
        int lastIndex = arr.length - 1;
        maxSumArr[lastIndex] = arr[lastIndex];
        for(int prefix = lastIndex - 1; prefix >= 0; prefix--){
            if(maxSumArr[prefix + 1] > 0)
                maxSumArr[prefix] = arr[prefix] + maxSumArr[prefix + 1];
            else
                maxSumArr[prefix] = arr[prefix];
        }

        return Arrays.stream(maxSumArr).max().getAsInt();
        // return Collections.max(Arrays.asList(ArrayUtils.toObject(maxSumArr)));
    }


    public static void main(String args[]){
        int arr[] = {31,-41,59,26,-53,58,97,-93,-23,84};
        int sum = maxSumSubarray(arr);

        System.out.print(sum);
    }

}
