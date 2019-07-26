/*

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 Problem was taken from LeetCode 

 Example (Odd):
        Input: 1->2->3->4->5->null
        Output: 1->3->5->2->4->null

Example (Even):
        Input: 1-2->3->4
        Output: 1->3->2->4

*/

class Solution{
    public ListNode oddEvenList(ListNode head) {

        //First check if the linkedlist exists
        if(head!=null){

            //Set pointers for odd and even starting positions for linked list
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenTemp = even;

            //Since even is always ahead of odd, loop will end if either next or current of even is null
            while(even!=null && even.next!=null){

                //Manipulate the pointers so they point every odd/even positions respectively
                odd.next = even.next;
                odd = odd.next;
                even.next = even.next.next;
                even = even.next;
            }
        }

        //connects the two linkedlist 
        odd.next = evenTemp;
    
    }

    return head;
}


/*
    Example (Odd):

        1 (Initial). Input: 1->2->3->4->5->null
        Odd = 1 -> 2 -> 3 -> 4 -> 5 -> null
        Even = 2 -> 3 -> 4- > 5 -> null
        EvenTemp = 2 -> 3 -> 4 -> 5 -> null

        Loop:

        Odd.next = 3 -> 4 ->5 -> null
        Odd = Odd.next = 3->4->5 -> null
       

        Even.next = Even.next.next = 4->5->null
        Even = Even.next = 4->5->null


        EvenTemp = 2->4->5->null
        Head = 1->3->4->5
                 


        2. Odd.next = 5->null
           Odd = Odd.next = 5->null

           Even.next = Even.next.next = null
           Even = Even.next = null

           EvenTemp = 2->4->null
           Head = 1->3->5->null



        3. Head = 1-3->5->null
           Odd = 5->null
           EvenTemp = 2-4->null

           Odd.next = EvenTemp = 5->2->4->null

           return head = 1->3->5->2->4->null


    Example (Even):

        1 (Initial). Input: 1->2->3->4->null
        Odd = 1 -> 2 -> 3 -> 4 -> null
        Even = 2 -> 3 -> 4 -> null
        EvenTemp = 2 -> 3 -> 4 -> null

        Loop:
        Odd.next = Even.next = 3->4->null
        Odd = Odd.next = 3 -> 4 -> null
        Head = 1 -> 3 -> 4 -> null

        Even.next = Even.next.next = 4->null
        Even = Even.next = 4 -> null

        
        Odd = 3 -> 4 -> null
        EvenTemp = 2->4->null
        Odd.next = Eventemp = 2->4->null

        return head = 1-3->2->4->null

*/

