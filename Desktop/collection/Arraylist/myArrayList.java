package collection.Arraylist;

import collection.Arraylist.CustomArrayList;

import java.util.ArrayList;

public class myArrayList {
    public static void main(String[] args) {
        CustomArrayList arr = new CustomArrayList();
        ArrayList a = new ArrayList();
        /*a.add(30);
        a.add(3,30);
        a.size();
        a.remove(2);*/
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        //System.out.println(a.remove(2));

        a.add(2,444);
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i));
        }
    }
}
