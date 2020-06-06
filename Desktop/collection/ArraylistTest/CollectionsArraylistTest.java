package collection.ArraylistTest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

import static java.util.Comparator.*;

public class CollectionsArraylistTest{
    public static void main(String[] args) {
       List<String> fruits = new ArrayList<>();
        Collections.addAll(fruits,"apple","orange","banana");
        System.out.println(fruits);
        Collections.shuffle(fruits);
        System.out.println(fruits);
        Collections.reverse(fruits);
        System.out.println(fruits);
        List<String> subFruits = fruits.subList(0,2);
        System.out.println(subFruits);
        Collections.swap(fruits,0,2);
        System.out.println(fruits);
        fruits.addAll(subFruits);
        System.out.println(fruits);
        List arr = new ArrayList();
        ((ArrayList) arr).ensureCapacity(16);

    }
}
