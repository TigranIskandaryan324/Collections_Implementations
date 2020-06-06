package collection.myQueue;

public class myQueueTest {
    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        for (int i = 0; i < m.array.length; i++) {
            m.add(i);
        }
        while(m.size > 0)
        {
            System.out.println(m.remove());
        }

    }

}
