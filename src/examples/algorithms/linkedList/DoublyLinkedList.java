package examples.algorithms.linkedList;

public class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public void insertAtStart(int data) {
        if (this.head == null) {
            this.head = new DoublyLinkedNode(data);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            newNode.setNextNode(this.head);
            this.head.setPreviousNode(newNode);
            this.head = newNode;
        }
    }

    public String toString() {
        String result = "{";
        DoublyLinkedNode current = this.head;
        while (current != null) {
            if (result != "{") {
                result += ", ";
            }
            result += current.getData();
            current = current.getNextNode();
        }
        result += "}";
        return result;
    }

    public int lenght() {
        int result = 0;
        DoublyLinkedNode current = this.head;
        while (current != null) {
            result++;
            current = current.getNextNode();
        }
        return result;
    }

    public void insertionSort() {
        if (this.lenght() >= 2) {

            DoublyLinkedNode elementToSort = this.head.getNextNode();

            while (elementToSort != null) {
                DoublyLinkedNode nextElementToSort = elementToSort.getNextNode();
                DoublyLinkedNode elementToCheck = elementToSort.getPreviousNode();

                while (elementToCheck != null) {
                    if (elementToCheck.getData() > elementToSort.getData()) {
                        changeElements(elementToCheck, elementToSort);
                        elementToCheck = elementToSort.getPreviousNode();
                    } else {
                        elementToCheck = elementToCheck.getPreviousNode();
                    }
                }
                elementToSort = nextElementToSort;
            }
        }
    }

    private void changeElements(DoublyLinkedNode checkedNode, DoublyLinkedNode sortNode) {
        checkedNode.setNextNode(sortNode.getNextNode());
        if (sortNode.getNextNode() != null) {
            sortNode.getNextNode().setPreviousNode(checkedNode);
        }
        sortNode.setPreviousNode(checkedNode.getPreviousNode());
        sortNode.setNextNode(checkedNode);
        checkedNode.setPreviousNode(sortNode);
        if (sortNode.getPreviousNode() == null) {
            this.head = sortNode;
        }
    }

}
