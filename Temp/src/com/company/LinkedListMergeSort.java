package com.company;

/**
 * Created by tecso on 9/6/16.
 */
//https://www.youtube.com/watch?v=jOyYaBHyN28
public class LinkedListMergeSort {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
        }
    }

    Node start, last;


    public void add(int data) {
        Node last_tmp = last;
        last = new Node(data);
        if (start == null) {
            start = last;
        } else {
            last_tmp.next = last;
        }
    }

    public Node getHead() {
        return start;
    }

    public Node findMiddle(Node head) {
        Node fast = head.next;
        Node slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        //as fast becomes null , slow becomes middle
        return slow;
//        Node slow = head;
//        Node fast = head;
//
//        if (head == null) {
//            return null;
//        }
//
//        while (fast != null && fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//
//        return slow;

    }

    public Node sortedMerge(Node a, Node b){

        Node result =null;

        if(a==null){
            return b;
        }
        else if(b==null){
            return a;
        }

        else if(b.data <a.data){
            result=b;
            result.next=sortedMerge(a,b.next);
        }
        else{
            result=a;
            result.next=sortedMerge(a.next,b);
        }

        return result;

    }
    

    public Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node first = head;
        Node middle = findMiddle(first);
        Node second = middle.next;
        middle.next = null;

        Node left = mergeSort(first);
        Node right = mergeSort(second);
        Node result = sortedMerge(left, right);
        return result;

    }

    public void print(Node head) {
        Node tmp = head;
        System.out.println("\n");
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }


    public static void main(String[] args) {
        LinkedListMergeSort mSort = new LinkedListMergeSort();
        mSort.add(5);
        mSort.add(4);
        mSort.add(3);
        mSort.add(2);
        mSort.add(1);
        Node result = mSort.mergeSort(mSort.getHead());
        mSort.print(result);


//        System.out.println(mSort.findMiddle(mSort.getHead()).data);

    }
}
