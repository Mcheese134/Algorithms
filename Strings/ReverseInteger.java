/*
Given a 32-bit signed integer, reverse digits of an integer (Problem taken from LeetCode).

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Example: 
        Input - 1234
        Output - 4321
*/

class Solution{
    public int reverse(int x){
        
        //use long initially because max integer value 2147483647 is smaller than 32 bits
        long result = 0;

        while(x!=0){

            //builds the integer in reverse order
            result = (result*10) + x%10;

            //Check if it overflows beyond integer limitations
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

            //reduces the original until it floors at 0
            x = x/10;
        }

        return (int)result;


    }
}

/* Example: 
    Input - 1234

    1. (initial): result = 0
    
    loop:
        result = 0 + 4 = 4
        x = 123.4 = 123

    2. result = 4

    loop:
        result = 4*10  + 3 = 43
        x = 12.3 = 12
    
    3. result = 43

    loop: 
        result = 43*10 + 2 = 432
        x = 1.2 = 1
    
    4. result = 432
    
    loop:
        result = 432*10 + 1 = 4321
        x = 0.1 = 0

    return result = 4321

*/