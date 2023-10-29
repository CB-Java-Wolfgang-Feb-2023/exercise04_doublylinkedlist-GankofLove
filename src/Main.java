public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();

        System.out.println("----- Test addFirst -----");
        list.addFirst(5);
        list.addFirst(4);
        list.printList();
        System.out.println();

        System.out.println("----- Test addLast -----");
        list.addLast(6);
        list.printList();
        System.out.println();

        System.out.println("----- Test addAtIndex -----");
        list.addAtIndex(1, 10);  // Liste: 4 -> 10 -> 5 -> 6
        list.printList();
        System.out.println();

        System.out.println("----- Test getSize -----");
        System.out.println("Listengröße: " + list.getSize());
        System.out.println();

        System.out.println("----- Test get -----");
        System.out.println("Element an Index 2: " + list.get(2));
        System.out.println();

        System.out.println("----- Test removeFirst -----");
        list.removeFirst();
        list.printList();
        System.out.println();

        System.out.println("----- Test removeLast -----");
        list.removeLast();
        list.printList();
        System.out.println();

        System.out.println("----- Test removeAtIndex -----");
        list.removeAtIndex(1);
        list.printList();
        System.out.println();

        System.out.println("----- Test removeDuplicates -----");
        list.addLast(5);
        list.addLast(4);
        list.addLast(5);
        list.printList();
        list.removeDuplicates();
        list.printList();
        System.out.println();

        System.out.println("----- Test reverseList -----");
        list.reverseList();
        list.printList();
        System.out.println();

        System.out.println("----- Test copyList -----");
        DoublyLinkedListCustom copiedList = list.copyList();
        copiedList.printList();
        System.out.println();

        System.out.println("----- Test insertAfter -----");
        list.insertAfter(5, 15);
        list.printList();
        System.out.println();

        System.out.println("----- Test deleteKey -----");
        list.deleteKey(15);
        list.printList();
        System.out.println();

        System.out.println("----- Test isEmpty -----");
        System.out.println("Ist die Liste leer? " + list.isEmpty());
        System.out.println();

        System.out.println("----- Test clear -----");
        list.clear();
        list.printList();
        System.out.println("Listengröße nach dem Löschen: " + list.getSize());
        System.out.println();

        System.out.println("----- Test remove -----");
        boolean isRemoved = list.remove(10);
        System.out.println("Element 10 entfernt? " + isRemoved);
        list.printList();
        System.out.println();

    }
}
