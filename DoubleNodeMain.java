import java.io.File;
import java.io.FileNotFoundException;

public class DoubleNodeMain {
    static DoubleLinkedList root;
    public static void main(String[] args) throws FileNotFoundException{
        root = new DoubleLinkedList();
        root.loadFromFile(new File("numbers1.txt"));
        System.out.println(root.toString());

        root.insertionSort();
        System.out.println(root.toString());

        root.add(3, 7);
        root.insertionSort();
        System.out.println(root.toString());

        root.remove(5);
        System.out.println(root.toString());

        root.remove(7);
        System.out.println(root.toString());

        root.add(6);
        System.out.println(root.toString());
        

    }
}
