package collection.myBynarySearchTreeMap;

import java.util.ArrayList;
import java.util.List;

public class CustomBinarySearchTree {
    Node root = null;
    static int size = 0;
    public Node getRoot() {
        return root;
    }

    void insert(int key) {
        if (root == null) {
            root = new Node(key, null, null);
            return;
        }

        Node current = root;
        Node previous = current;
        while (current != null) {
            previous = current;

            if (key > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (key < previous.data) {
            previous.left = new Node(key, null, null);
        } else {
            previous.right = new Node(key, null, null);
        }
        size++;
    }


    ////////// myRemove()
    public Integer myRemove(int data) {


        //case2 if root.left && root.rigth == null
        /*if (root.left == null && root.right == null && root.data == data) {
            int temp = root.data;
            root =null;
            size--;
            return temp;
        }*/

        //case3 if root.left or root.right == null
        Node deleted = root;
        Node parentDeleted = root;
        while(deleted != null && deleted.data != data){
            parentDeleted = deleted;
            if(data < deleted.data) {
                deleted = deleted.left;
            }
            else {
                deleted = deleted.right;
            }
        }
        if(deleted == null){
            return null;
        }
        if (deleted.left == null && deleted.right == null && root.data == data) {
            int temp = deleted.data;
            deleted = null;
            size--;
            return temp;
        }
        if (deleted.left != null && deleted.right == null) {
            int temp = deleted.data;
            parentDeleted.left = deleted.left;
            size--;
            return temp;
        }
        else if (deleted.left == null && deleted.right != null) {
            int temp = deleted.data;
            parentDeleted.right = deleted.right;
            size--;
            return temp;
        }
        else{
            Node replacedParent = deleted;
            Node replaced = deleted.right;
            while (replaced != null){
                replacedParent = replaced;
                replaced = replaced.left;
            }
            if(replacedParent.right == null){
                int temp = deleted.data;
                parentDeleted.right = replaced;
                replacedParent.left = null;
                size--;
                return temp;
            }
            else{
                Node t = replaced;
                int temp = deleted.data;
                parentDeleted.right = replaced;
                replacedParent.left = t.right;
                size--;
                return temp;
            }
        }




    }


    /////////
    static class Node {
        int data;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }
    }


    public void print(Node root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.data);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}
