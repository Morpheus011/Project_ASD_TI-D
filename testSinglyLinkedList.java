import java.util.Arrays;

/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6); // isi list: 6,5,4,3,2,1
        System.out.println(linkedList.get(2));       // 4 (index 2 dari head)
        try {
            System.out.println(linkedList.get(12));  // exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println(linkedList.indexOf(4));   // 2
        System.out.println(linkedList.indexOf(10));  // -1
        linkedList.printReverse();                   // 1,2,3,4,5,6 (tail ke head)
        System.out.println(linkedList.remove(3));    // true
        System.out.println(linkedList.remove(8));    // false
        System.out.println(Arrays.toString(linkedList.toArray())); // [6, 5, 4, 2, 1]
    }
}
