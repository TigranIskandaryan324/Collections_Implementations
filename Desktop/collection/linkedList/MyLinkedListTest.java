package collection.linkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedLIst myLinkedLIst = new MyLinkedLIst();
        for (int i = 0; i < 2; i++) {
            myLinkedLIst.add(i,i);
        }

       /* MyLinkedLIst.Node start = myLinkedLIst.head;
        for (int i = 0; i < 5; i++) {
            start = start.next;
        }*/

        //myLinkedLIst.rear.next = start;
        myLinkedLIst.print();
        System.out.println(myLinkedLIst.size);

        //System.out.println(myLinkedLIst[0]);


    }
}
