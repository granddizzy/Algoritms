public class linkedList {
    private Node head;
    private Node tail;
    private int size;

    public linkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    private static class Node {
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
            next = null;
            previous = null;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return (((Node) obj).value == value);
            }
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        Node current = head;
        for (int i = 0; i < size; i++) {
            current.previous = null;
            current.next = null;
        }
        size = 0;
        head = null;
        tail = null;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
            return;
        }

        Node node1 = get(index1);
        Node node2 = get(index2);

        int tmp = node1.value;
        node1.value = node2.value;
        node2.value = tmp;
    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int left, int rigth) {
        int leftMarker = left;
        int rightMarker = rigth;
        int pivot = getValue((leftMarker + rightMarker) / 2);
        do {
            while (getValue(leftMarker) < pivot) {
                leftMarker++;
            }
            while (getValue(rightMarker) > pivot){
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker<rightMarker) {
                    swap(leftMarker, rightMarker);
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (left< rigth) {
            quickSort(leftMarker, rigth);
        }

        if (left < rightMarker) {
            quickSort(left, rightMarker);
        }
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            // если список пуст
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void insert(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node(value);
        newNode.previous = node;
        node.next = newNode;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }

        size++;
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }

            current = current.next;
        }
        return null;
    }

    public Node get(Integer index) {
        Node node;
        if (index >= 0 && index < size) {
            node = head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            return node;
        }

        return null;
    }

    public int getValue(Integer index) {
        if (index >= 0 && index < size) {
            Node node = head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            return node.value;
        }

        return 0;
    }

    public void del(Node node) {
        Node previous = node.previous;
        Node next = node.next;

        if (previous == null) {
            // если это первая нода
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                // если это последняя
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }

        size--;
    }

    public void delAt(int index) {
        if (index >= 0 && index < size) {
            Node node = head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            this.del(node);
        }
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            Node previous = current.previous;
            current.next = previous;
            current.previous = next;

            if (previous == null) {
                tail = current;
            }
            if (next == null) {
                head = current;
            }
            current = next;
        }
    }

    public void reverseSinglyConnected() {
        if (head != null && head.next != null) {
            reverseSinglyConnected(head.next, head);
        }
    }

    private void reverseSinglyConnected(Node current, Node previous) {
        if (current.next == null) {
            head = current;
        } else {
            reverseSinglyConnected(current.next, current);
        }
        current.next = previous;
        previous.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (head != null) {
            sb.append(head.value);

            if (head.next != null) {
                Node current = head.next;
                do {
                    sb.append(", ").append(current.value);
                    current = current.next;
                } while (current != null);
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
