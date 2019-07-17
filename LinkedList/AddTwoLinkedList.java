/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example: 

LinkedList 1 : 1->7->4
LinkedList 2: 2->3->6

Sum: 3->0->1->1 


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

Problem Source: LeetCode

*/

class Solution{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result  = new ListNode(0);
        ListNode temp = result;
        int carry = 0;

        while(l1!=null || l2!=null || carry !=0 ){
            if(l1!=null){
                carry+=l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                carry+=l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(carry%10)
            carry = carry/10
            temp = temp.next;

        }

        return result.next;
    }

    /*
        Example: 
            LinkedList 1 : 1->7->4
            LinkedList 2: 2->3->6
                1. LinkedList result: 0->null, carry = 0, temp: 0->null
                2. result: 0->3->null, carry = 1 + 2 = 3/10 or 0, temp: 3->null
                3. result: 0->3->0->null, carry = 0 + 7  + 3 = 10/10 = 1, temp: 0->null
                4. result: 0->3->0->1->null, carry = 1 + 4 + 6 = 11/10 = 1, temp: 1 ->null
                5. result: 0->3->0->1->1->null, carry = 1 or 1/10 = 0 since l1 and l2 are null, temp: 1->null
                6. result: 0->3->0->1->1->null, carry = 0, l1 = null, and l2 = null, so conclude
                7. return result.next = 3->0->1->1->null
            
            LinkedList 1: 1->9
            LinkedList 2: 9
            Sum: 0 -> 0 -> 1
                1. LinkedList result: 0->null, carry =0, temp: 0->null
                2. result: 0->0->null, carry = (0+1+9)/10 or 1, temp: 0->null
                3. result: 0->0->0->null, carry = 1/10 or 0, temp: 1->null
                4. result: 0->0->0->1->null, carry = 0, l1 = null, and l2 = null, so conclude
                5. return result.next = 0->0->1->null
 
    */
}

