public class JosephusLinkedList {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static int solveJosephus(int n, int k) {
        Node head = new Node(1);
        Node current = head;

        for (int i = 2; i <= n; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        current.next = head;

        Node prev = current;
        current = head;
        while (current.next != current) {
            for (int i = 1; i < k; i++) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
            current = current.next;
        }

        return current.value;
    }
}