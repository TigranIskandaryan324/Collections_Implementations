package collection.myQueue;

public class MyQueue {
    int next = 0;
    final int head = 0;
    int size = 0;
    int[] array = new int[20];

    public void add(int el) {
        if (size < array.length) {
            if (size == 0)
                array[head] = el;
            else
                array[size] = el;
            size++;
        } else
            System.out.println("out of bends");
    }

    public int remove() {
        int temp = -1;
        if (size > 1) {
            temp = array[head];
            for (int i = 1; i < size; i++) {
                array[i-1] = array[i];
            }
            size--;
        } else if (size == 1) {
            temp = array[head];
            array[head] = 0;
            size = 0;
        } else {
            System.out.println("empty array");
        }
        return temp;
    }




    /*static class Node {
        Integer date;
        Node next;

        public void Node(Node next, Integer date) {
            this.next = next;
            this.date = date;
        }
    }*/
}
