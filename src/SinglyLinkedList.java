public class SinglyLinkedList {
    public SinglyLinkedList() {
    }

    private Node first;
    private Node last;
    private int size = 0;

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        if (first == null) {
            System.out.print("Linked list is empty!");
        }
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int value) {
        Node current = first;
        int counter = 0;
        while (current != null) {
            if (current.value == value) {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }


    public boolean contains(int value) {
        return indexOf(value) != -1;
    }


    public void insertAfter(int value, int tmp) {
        Node current = first;
        while (current != null && current.value != value) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with value " + value + " not found!");
            return;
        }
        var newNode = new Node(tmp);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        if (first == last) {
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        if (first == last) {
            first = last = null;
            return;
        }
        Node current = first;
        while (current.next != last) {
            current = current.next;
        }
        current.next = null;
        last = current;
        size--;
    }

    public int[] toArray() {
        Node current = first;
        int[] arr = new int[size];
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse() {
        Node current = first;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    }

}
