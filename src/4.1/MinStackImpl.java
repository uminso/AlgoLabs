public class MinStackImpl implements MinStack<Integer> {

    private Node head;

    private static class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    @Override
    public void push(Integer value) {
        if (head == null) {
            head = new Node(value, value, null);
        } else {
            int newMin = Math.min(value, head.min);
            head = new Node(value, newMin, head);
        }
    }

    @Override
    public Integer pop() {
        int value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        return head.value;
    }

    @Override
    public Integer min() {
        return head.min;
    }
}
