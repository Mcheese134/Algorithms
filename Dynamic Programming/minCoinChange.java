/*
You are given coins of different denominations and a total amount of money amount. 

Write a function to compute the fewest number of coins that you need to make up that amount. 

If that amount of money cannot be made up by any combination of the coins, return -1.

Note: You have infinite amount of each coin

Example: Coins Available - [1, 2, 5]
         Amount - 5
         Min - 1 coin

         Coins Available - [10]
         Amount - 2
         Min -  -1 coins or invalid amount

This problem was taken from LeetCode 
*/

class Solution{
    public int coinChange(int[] coins, int amount) {

        //First check if the array exists/empty and if the amount is at non-negative/zero value
        if(coins.length == 0 || coins == null || amount <=0){
            return 0;
        }

        //Create an array that is the size of amount - we will use this array to find min value of coins to obtain each index
        int[] minChangePerIndex = new int[amount+1];

        //Starting from 1, initialize each index with a max value (the zero index is a base case since zero coins are needed)
        for(int i = 1; i<amount; i++){
            minChangePerIndex[i] = Integer.MAX_VALUE;
            
            //Checking all available coins 
            for(int j = 0; j<coins.length; j++){

                //check if the given coin can be used to reach a previous index with an established min value 
                if(coins[j] <= i && minChangePerIndex[i-coins[j]]!=Integer.MAX_VALUE){

                    //initialize the current index  with either its current value or the min of a previous index +1 more coin
                    minChangePerIndex[i] = Integer.min(minChangePerIndex[i], 1+minChangePerIndex[i-coins[j]])
                }
            }


            //If the minimum value changed for the amount index, then return that value
            if(minChangePerIndex[amount]==Integer.MAX_VALUE){
                return -1;
            }
            else
                return minChangePerIndex[amount];
        }
    }

}

/* Example Walkthrough: 
    Coins Available - [1, 2, 5]
    Amount - 5

    minChangePerIndex: [0, 0, 0, 0, 0, 0]

    First It:
        [0, MAX, 0, 0, 0, 0]
        i = 1, available = 1 

        i<=coin and minChangePerIndex[i - coin] = 0
        
        For 1:
            Minimum: Max or index 0 value + 1 coin = 1
            so
            Result: [0, 1, 0 , 0, 0, 0]

    Second It:
        [0, 1, MAX, 0, 0, 0]
        i =2, available coin = 1, 2

        For 1:
            Minimum: Max or index 1 + 1 coin = 2
            so 
            Result: [0, 1, 2, 0, 0, 0]

        For 2:
            Minimum: 2 or index 0 + 1 coin = 1
            so
            Result: [0, 1, 1, 0, 0, 0]

    Third It:
        [0, 1, 1, Max, 0, 0]
        i = 3, available coin = 1, 2

        For 1:
            Minimum: Max or index 2 + 1 coin = 2
            Result: [0,1, 1, 2, 0, 0]

        For 2:
            Minimum: 2 or index 1 + 1 coin = 2
            Result: [0, 1, 1, 2, 0, 0]

    Fourth It:
        [0, 1, 1, 2, Max, 0]
        i = 4, available coin = 1, 2
        
        For 1:
            Minimum: Max or index 3 + 1 coin = 3
            Result: [0, 1, 1, 2, 3, 0]

        For 2:
            Minimum: 3 or index 2 + 1 coin: 2 
            Result: [0, 1, 1, 2, 2, 0]

    Fifth It:
        [0, 1, 1, 2, 2, Max]
        i = 5, available coin = 1, 2, 5

        For 1:
            Minimum: Max or index 4 + 1 coin: 2 + 1 = 3
            Result: [0, 1, 1, 2, 2, 3]
        
        For 2: 
            Minimum: 3 or index 3 + 1 coin: 2 + 1 = 3
            Result: [0, 1, 1, 2, 2, 3]

        For 5: 
            Minimum: 3 or index 0 + 1 coin: 0 +1 = 1
            Result: [0,1, 1, 2, 2, 1]
        
    minChangePerIndex[amount]  = 1 not Integer.MAX_VALUE, so answer = 1 coin
        





*/