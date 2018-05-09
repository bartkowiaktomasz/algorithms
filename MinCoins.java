/* Given a sum of S compute the minimum number of coins required to
get that sum if values of possible coins are V=[v1,...,vn].

Solution using bottom-up (iterative) dynamic programming
approach with time O(N^2) */
class MinCoins{

    int minCoins(int sum, int values[]){
        int sumArr[] = new int[sum + 1];
        int sumMatrix[][] = new int[values.length][sum + 1];

        // Array with all possible sums up to "sum"
        for(int i = 0; i <= sum; i++){
            sumArr[i] = i;
        }

        // First column with zeros
        for(int i = 0; i < values.length; i++){
            sumMatrix[i][0] = 0;
        }

        // Compute first row (for the smallest possible value)
        for(int i = 1; i <= sum; i++){
            if(sumArr[i] % values[0] == 0)
                sumMatrix[0][i] = sumArr[i]/values[0];
            else
                sumMatrix[0][i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < values.length; i++){
            for(int j = 1; j <= sum; j++){
                if(sumArr[j] < values[i])
                    sumMatrix[i][j] = sumMatrix[i - 1][j];
                else if(sumArr[j] == values[i])
                    sumMatrix[i][j] = 1;
                else{
                    int a = 1 + sumMatrix[i][j - values[i]];
                    int b = sumMatrix[i - 1][j];
                    sumMatrix[i][j] = Math.min(a,b);
                }
            }
        }
        return sumMatrix[values.length - 1][sum];
    }

    public static void main(String args[]){
        int values[] = {1,3,5,8};
        int sum = 10;

        MinCoins obj = new MinCoins();
        int out = obj.minCoins(sum, values);

        System.out.printf("You need %d coins to get a sum of %d.", out, sum);
    }
}
