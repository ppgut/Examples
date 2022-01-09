package examples.algorithms.linkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();

        dList.insertAtStart(1);
        dList.insertAtStart(10);
        dList.insertAtStart(100);
        dList.insertAtStart(1000);
        dList.insertAtStart(10000);
        dList.insertAtStart(100000);

        System.out.println(dList);
        dList.insertionSort();
        System.out.println(dList);
        
    }
}
