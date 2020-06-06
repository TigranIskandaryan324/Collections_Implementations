package collection.treeMap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap myTreeMap = new MyHashMap();
        for (int i = 0; i < 17; i++) {
            String k = String.valueOf(i);
            myTreeMap.put(k,i);
        }
        myTreeMap.print();
        System.out.println(myTreeMap.size);
        System.out.println(myTreeMap.array.length);
        System.out.println("---------------------------");
        for (int i = 20; i < 25; i++) {
            String k = String.valueOf(i);
            myTreeMap.put(k,i);
        }
        myTreeMap.print();
        System.out.println(myTreeMap.size);
        System.out.println(myTreeMap.array.length);

    }
}
