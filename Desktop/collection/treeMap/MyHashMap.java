package collection.treeMap;

public class MyHashMap {
    public Entry[] array = new Entry[16];
    private double loadFactor = 0.75;
    public int size = 0;


    public Integer put(String key, Integer value) {
        checkTrashHold();
        Entry newEntry = new Entry(key, value, null);
        int index = getIndex(key);
        Entry current = array[index];
        if(newEntry.key == null ){
            array[0] = newEntry;
        }
        if (current == null) {
            array[index] = newEntry;
            size++;
            return null;
        }
        Entry previous = array[index];
        while (current != null) {
            if (current.key.hashCode() == key.hashCode()
                    && key.equals(current.key)) {
                int temp = current.value;
                current.value = newEntry.value;
                return temp;
            }
            previous = current;
            current = current.next;
        }
        previous.next = newEntry;
        size++;
        return null;
    }

    private void checkTrashHold() {
        double treshHold = (double) size/array.length;
        if (treshHold > loadFactor) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("***************");
        Entry[] temp = array;
        size=0;
        int newSize = array.length * 2;
        array = new Entry[newSize];
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        for (int i = 0; i < temp.length; i++) {
            Entry head = temp[i];
            while (head != null){
                put(head.key,head.value);
                head=head.next;
                //System.out.println(head.key);
            }
        }
    }

    public void print() {

        for (Entry item : array) {
            if (item == null) {
                System.out.println("[]");
                continue;
            }

            System.out.print("[");

            Entry current = item;
            while (current != null) {
                System.out.print(current.key + ":" + current.value + " => ");
                current = current.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }


    public int getIndex(String key) {
        return key == null ? 0 : key.hashCode() & array.length - 1;
    }

    static class Entry {
        String key;
        Integer value;
        Entry next;

        public Entry(String key, Integer value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
