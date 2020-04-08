package com.company.Contests;

public class Week_2_leetCodeContest_30Days {


    public static void main(String[] args) {




    }



    /** 7th day : Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     If there are two middle nodes, return the second middle node.
     */

   // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    public ListNode middleNode(ListNode head) {
            int length = 0 ;
            ListNode node = head;
            while(node.next != null){
                length++;
                node = node.next;
            }
            ListNode node1 = head;
            int length1 = 0 ;

            if(length % 2 == 0){
                while(isaBoolean(node1, length1, length / 2)){
                    length1++;
                    node1 = node1.next;
                }
            } else{
                while(isaBoolean(node1, length1, (length/ 2)+1)){
                    length1++;
                    node1 = node1.next;
                }
            }

            return node1 ;
    }

    private boolean isaBoolean(ListNode node1, int length1, int i) {
        return node1.next != null && length1 < (i);
    }

    /** 8th day */

}

