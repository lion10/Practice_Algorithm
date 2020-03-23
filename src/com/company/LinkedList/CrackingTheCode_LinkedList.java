package com.company.LinkedList;

public class CrackingTheCode_LinkedList {

    public static void main(String[] args) {
        Node node = new Node(5);

        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(11);
        linkedList.append(12);
        linkedList.append(13);
        linkedList.prepend(9);
        linkedList.deleteNode(10);

       linkedList.show();



    }
}



