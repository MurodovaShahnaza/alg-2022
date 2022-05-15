import binaryTree.BinaryTree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.put(9);
        tree.put(11);
        tree.put(13);
        tree.put(15);
        tree.put(4);
        tree.put(3);
        tree.put(9);
        tree.put(5);
        tree.put(8);
        System.out.println("Высота дерева: " + tree.treeHeight());
        System.out.println("Удаление значений 9, 3 и 15");
        tree.remove(9);
        tree.remove(3);
        tree.remove(15);
        ArrayList<Integer> list = tree.toArray();
        for (int value : list) {
            System.out.println(value);
        }
        System.out.println("Число 11 присутствует в дереве: " + tree.contains(11));
        System.out.println("Число 15 присутствует в дереве: " + tree.contains(15));
    }
}
