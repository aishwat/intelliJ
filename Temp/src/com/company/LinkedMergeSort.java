package com.company;

/**
 * Created by tecso on 9/6/16.
 */


class LinkedMergeSort {

    private Node start;
    private Node last;

    private class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
        }

    }

    public LinkedMergeSort(){

        start=null;
        last=null;

    }

    public Node getHead(){
        return start;

    }

    public void add(int data){

        Node oldLast=last;
        last=new Node(data);

        if(start==null){
            start=last;
        }
        else{
            oldLast.next=last;
        }

    }

    public Node mergeSort(Node head){

        if(head==null || head.next==null){
            return head;
        }
        Node first=head;
        Node middle=findMiddle(head);
        Node second=middle.next;
        middle.next=null;

        Node left=mergeSort(first);
        Node right=mergeSort(second);

        Node result=sortedMerge(left,right);
        return result;

    }

    public Node findMiddle(Node head){

        Node slow=head;
        Node fast=head;

        if(head==null){
            return null;
        }

        while(fast !=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;


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

    public void display(Node head){

        Node current=head;
        while(current !=null){
            System.out.println(current.data);
            current=current.next;
        }

    }

    public static void main(String args[]){
        LinkedMergeSort msort=new LinkedMergeSort();
        msort.add(5);
        msort.add(2);
        msort.add(1);
        msort.add(4);
        msort.add(6);

        Node sortedResult=msort.mergeSort(msort.getHead());;
        msort.display(sortedResult);

    }

}
