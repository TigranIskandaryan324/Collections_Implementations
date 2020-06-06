package collection.Arraylist;

public class CustomArrayList {
    private static final int DEFAULT_SIZE = 10;
    private  int size;
    private Integer[] arr ;
    public CustomArrayList(){
        this(DEFAULT_SIZE);
    }
    public  CustomArrayList(int size){
        if(size<0){
            throw new IllegalArgumentException();
        }
        arr = new Integer[size];
    }
    public  boolean add(Integer value){
        arr[size++] = value;
        return true;
    }
    public  boolean add(int index,Integer value){
        if(index == size){
            add(value);
        }
        if(index <= size) {
            int ind=size()+1;
            for (int i = size(); i >= index; i--) {
                arr[ind] = arr[ind++];
            }
            arr[index] = value;
            size++;
            return true;
        }
        return false;
    }
    public  Integer remove(int index){
        int temp;
        if(index < 0 || index >= size){
            throw new RuntimeException();
        }
        if(index < size){
        temp= arr[index];
        arr[index] = null;
            for (int i=index;i<size();i++){
                arr[index]=arr[index++];
            }
            size--;
            return temp;
        }
        return -1;

    }
    public  int get(int index){
        return arr[index];
    }
    public  boolean isEmpty(){
        return  size==0;
    }
    public  int size(){
        return  size;
    }
    public  void clear(){
        int currentLength = arr.length;
        arr = new Integer[currentLength];
    }
    public  boolean contains(Integer value){
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value))
                return true;
        }
        return false;
    }
    public void set(int index,Integer value){
        arr[index] = value;
    }
}
