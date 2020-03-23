package com.company.LinkedList;




public class Node {
    int data ;
    Node next;
    public Node(int data){
        this.data = data;
    }

}
class LinkedList{
    Node head ;
    void append(int data){
        if(head == null){
            head= new Node(data);
            return;
        }
        Node current = head ;
        while (current.next != null){
            current = current.next ;
        }
        current.next =new Node(data);

    }
    void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead; // swap between them
    }
    void deleteNode(int data){
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current = head ;
        while (current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }
    void show(){
        Node node = head;
        while (node.next !=null){
            System.out.println(node.data);
            node =node.next;
        }
        System.out.println(node.data);
    }


}


