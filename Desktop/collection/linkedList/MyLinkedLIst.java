package collection.linkedList;

public class MyLinkedLIst {
    Node head;
    Node rear;
    int size=0;
    public MyLinkedLIst(){
        //head = null;
        //rear = null;
    }

    //return size
    public int returnSize(){
        return size;
    }

    public void addFirst(Object o){
        Node f = head;
        Node newHead = new Node(f,null,o);
        head = newHead;
        if(size == 0){
            rear = newHead;
        }
        else{
            f.prev = newHead;
        }
        size++;
    }

    public void addLast(Object o){
        Node l = rear;
        Node newRear = new Node(null,l,o);
        if(size == 0) {
            head = newRear;
        }
        else{
            l.next = newRear;
        }
        size++;
    }

    public void add(int index,Object o){
        if(index >= 0 && index <= size){
            if(index == 0){
                addFirst(o);
            }
            else if(index == size){
                addLast(o);
            }
            else{
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                Node newNode = new Node(null,null,o);
                newNode.prev = current;
                newNode.next = current.next;
                current.next = newNode;
                //newNode.next.prev = newNode;
                size++;
            }
        }
        else {
            System.out.println("index out of bands");
        }
    }
    public  void print(){
        Node current=head;/*
        for (int i = 0; i < size; i++) {
            System.out.println(current.data.toString());
            current=current.next;

        }*/
        while (current.next != null){
            System.out.println(current.data.toString());
            current=current.next;
        }
    }




    static class Node{
        Node next;
        Node prev;
        Object data;
        public Node(Node next,Node prev,Object data){
            this.next=next;
            this.prev=prev;
            this.data=data;
        }
    }
}
