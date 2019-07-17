/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Problem Source: LeetCode

Example: [P,E,n,G,u,I,N] => [N,I,u,G,n,E,P]
*/


class Solution{

    public void reverseString(char[]s){

        //Used to keep track of index and store current character in that index
        int currentArrayIndex = -1;
        char currentChar = 'a';

        //Marks the current index to be swapped
        int swapIndex = s.length-1;

        //An array of 1 or less or null reversed is itself
        if(s.length < 2 || s == null){
            return s;
        }

        //loop until you reach j, where it will swap the current and last.
        for(currentArrayIndex = 0; currentArrayIndex<j; currentArrayIndex++){
            currentChar = s[currentArrayIndex];
            s[currentArrayIndex] = s[swapIndex];
            s[swapIndex] = s[currentArrayIndex];
            swapIndex--;
        }

        /*
            Algorithm Test Cases: 

            Odd Length: 
                1. [P,E,n,G,u,I,N] Curr: 0, Swap: 6  
                2. [N,E,n,G,u,I,P] Curr: 1, Swap: 5
                3. [N,I,n,G,u,E,P] Curr: 2, Swap: 4
                4. [N, I, u, G, n, E, P] Curr: 3, Swap : 3

            Even Length:
                1. [E,V,E,N] Curr: 0, Swap: 3
                2. [N,V,E,E] Curr: 1, Swap:2
                3. [N,E,V,E] Curr: 2, Swap: 1 (Since curr > swap, it will stop) 
        */
    }

}