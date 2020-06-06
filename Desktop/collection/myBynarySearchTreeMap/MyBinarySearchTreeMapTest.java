package collection.myBynarySearchTreeMap;

public class MyBinarySearchTreeMapTest {
    public static void main(String[] args) {
        int[] array = {1, 10, 8, 4, 6, 3, 2, 5,15,12,20,17};
        CustomBinarySearchTree tree = new CustomBinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.print(tree.getRoot());
        tree.myRemove(15);
        tree.print(tree.getRoot());
    }
}
